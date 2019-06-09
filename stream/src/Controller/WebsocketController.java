package Controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.websocket.server.ServerEndpoint;

import Model.Location;
import Model.Titles;
import Model.Trip;
import Model.TripDauration;
import Utils.JsonParser;
import View.DashBoard;

/**
 * @author Ahmednasser
 *
 */

@ServerEndpoint("/endpoint")
public class WebsocketController {
	private static final int MONTH_LENGTH = 32;
	private static final int YEAR_LENGTH = 13;
	private static final int TAXI_TYPES_NUMBER = 3;
	private String Query;
	private ArrayList<Trip>[][] data;
	private JsonParser parser;
	int[] avgMinTrips = new int[TAXI_TYPES_NUMBER];
	int[] nonDropOff = new int[TAXI_TYPES_NUMBER];
	int[] MadBrok = new int[TAXI_TYPES_NUMBER];
	int GlobalMonth, Trips_Count = 0, Failure_Count = 0;
	Set<String> UniqueVehicles[] = new HashSet[MONTH_LENGTH];
	Set<String> Vehicles = new HashSet<>();
	String MADBROOCLocationID = "", WoodsideQueensLocationID = "";
	int[] WoodsideTrips = new int[TAXI_TYPES_NUMBER];
	TripDauration[] tripTime = new TripDauration[TAXI_TYPES_NUMBER];
	ArrayList<Location> locations;
	PrintWriter writer;

	public WebsocketController(String query, int globalMonth, ArrayList<Location> loc) {
		super();
		Query = query;
		data = new ArrayList[YEAR_LENGTH][MONTH_LENGTH];
		locations = loc;
		GlobalMonth = globalMonth;
		parser = new JsonParser();
		DashBoard.main();
		initializeData();
		setImportantLocationIDs();
		start();
	}

	private void initializeData() {
		for (int i = 0; i < YEAR_LENGTH; i++) {
			for (int j = 0; j < MONTH_LENGTH; j++) {
				data[i][j] = new ArrayList<Trip>();
			}
		}
		for (int i = 0; i < TAXI_TYPES_NUMBER; i++) {
			avgMinTrips[i] = 0;
			nonDropOff[i] = 0;
			MadBrok[i] = 0;
			tripTime[i] = new TripDauration();
			WoodsideTrips[i] = 0;
		}
		for (int i = 0; i < MONTH_LENGTH; i++) {
			UniqueVehicles[i] = new HashSet<>();
		}
	}

	private LinkedList<String> start() {
		try {
			final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI(Query));
			clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
				public void handleMessage(String message) {
					Trip t = parser.setTripData(message);
					if (t.getDriverId().length() == 0 || t.getTaxi().length() == 0) {
						Failure_Count++;
					} else {
						int day = t.getDropDate().getDate();
						data[GlobalMonth][day].add(t);
						UpdateGUI(t, day);
						writeResults();
						Trips_Count++;
					}
				}
			});
			Thread.sleep(Long.MAX_VALUE);

		} catch (InterruptedException ex) {
			System.err.println("InterruptedException exception: " + ex.getMessage());
		} catch (URISyntaxException ex) {
			System.err.println("URISyntaxException exception: " + ex.getMessage());
		}
		return null;
	}

	private void setImportantLocationIDs() {
		for (int i = 0; i < locations.size(); i++) {
			if (locations.get(i).zone.equals("Madison") && locations.get(i).borough.equals("Brooklyn")) {
				MADBROOCLocationID = locations.get(i).id;
			}

			if (locations.get(i).zone.equals("Woodside") && locations.get(i).borough.equals("Queens")) {
				WoodsideQueensLocationID = locations.get(i).id;
			}
		}
	}

	private void UpdateGUI(Trip t, int day) {
		UniqueVehicles[day - 1].add(t.getDriverId());
		Vehicles.add(t.getDriverId());
		int tripGui = Integer.parseInt(DashBoard.totalTrips[day - 1].getText().toString()) + 1;
		DashBoard.totalTrips[day - 1].setText(String.valueOf(tripGui));
		DashBoard.Vehicles[day - 1].setText(String.valueOf(UniqueVehicles[day - 1].size()));
		String type = t.getTaxi();
		if (t.getPickLocId() == MADBROOCLocationID) {
			switch (type) {
			case Titles.GREEN:
				int greenMadBroc = Integer.parseInt(DashBoard.MadBroc[day - 1][1].getText().toString()) + 1;
				DashBoard.MadBroc[day - 1][1].setText(String.valueOf(greenMadBroc));
			case Titles.YELLOW:
				int yellowMadbroc = Integer.parseInt(DashBoard.MadBroc[day - 1][0].getText().toString()) + 1;
				DashBoard.MadBroc[day - 1][0].setText(String.valueOf(yellowMadbroc));
			case Titles.FHV:
				int fhvMadBroc = Integer.parseInt(DashBoard.MadBroc[day - 1][2].getText().toString()) + 1;
				DashBoard.MadBroc[day - 1][2].setText(String.valueOf(fhvMadBroc));
			}
		}

		if (t.getDropLocId().length() == 0) {
			switch (type) {
			case Titles.GREEN:
				int NDGREEN = Integer.parseInt(DashBoard.NDGreen.getText().toString()) + 1;
				DashBoard.NDGreen.setText(String.valueOf(NDGREEN));
			case Titles.YELLOW:
				int NDYELLOW = Integer.parseInt(DashBoard.NDYellow.getText().toString()) + 1;
				DashBoard.NDYellow.setText(String.valueOf(NDYELLOW));
			case Titles.FHV:
				int NDFHV = Integer.parseInt(DashBoard.NDFhv.getText().toString()) + 1;
				DashBoard.NDFhv.setText(String.valueOf(NDFHV));
			}
		}

		switch (type) {
		case Titles.GREEN:
			tripTime[0].totalTrips++;
			tripTime[0].totalTime += t.getTripdauration();
			DashBoard.MinGreen.setText(String.format("%.2f", tripTime[0].totalTime / tripTime[0].totalTrips));
		case Titles.YELLOW:
			tripTime[1].totalTrips++;
			tripTime[1].totalTime += t.getTripdauration();
			DashBoard.MinYellow.setText(String.format("%.2f", tripTime[1].totalTime / tripTime[1].totalTrips));
		case Titles.FHV:
			tripTime[2].totalTrips++;
			tripTime[2].totalTime += t.getTripdauration();
			DashBoard.MinFhv.setText(String.format("%.2f", tripTime[2].totalTime / tripTime[2].totalTrips));

		}
		if (t.getPickLocId() == WoodsideQueensLocationID) {
			switch (type) {
			case Titles.GREEN:
				WoodsideTrips[0]++;
			case Titles.YELLOW:
				WoodsideTrips[1]++;
			case Titles.FHV:
				WoodsideTrips[2]++;
			}
		}
	}

	public ArrayList<Trip>[][] getData() {
		return data;
	}

	private void writeResults() {
		try {
			writer = new PrintWriter(System.getProperty("user.dir")+"\\stream\\results\\result.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		writer.println("Total number of received records : " + String.valueOf(Trips_Count + Failure_Count));
		writer.println("Total number of trips : " + String.valueOf(Trips_Count));
		writer.println("Average trips per day the given month : " + String.format("%.2f", Trips_Count / 31.0));
		writer.println("Total number of distinct vehicles : " + MONTH_LENGTH);
		writer.println("Total number of trips picked up from Woodside,Queens :" + "Green( " + WoodsideTrips[0]
				+ " ), Yellow( " + WoodsideTrips[1] + " ), FHV( " + WoodsideTrips[2] + " )");
		writer.close();
	}
}
