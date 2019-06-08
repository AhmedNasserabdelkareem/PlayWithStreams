package stream;

import java.net.URI;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.websocket.server.ServerEndpoint;

import Gui.DashBoard;

@ServerEndpoint("/endpoint")
public class WebsocketController {
	private static final int MONTH_LENGTH = 32;
	private static final int YEAR_LENGTH = 13;
	private String Query;
	private ArrayList<Trip> [][] data;
	private JsonParser parser ;
	int [] avgMinTrips = new int[3];
	int [] nonDropOff = new int[3];
	int [] MadBrok = new int[3];
	int GlobalMonth;
	Set<String> UniqueVehicles [] = new HashSet [32];
	String MADBROOCLocationID ="";
	TripDauration [] tripTime = new TripDauration[3];
	ArrayList<Location> locations;
	public ArrayList<Trip> [][] getData() {
		return data;
	}

	public WebsocketController(String query,int globalMonth ,ArrayList<Location> loc) {
		super();
		Query = query;
		data = new ArrayList[13][32];
		locations=loc;
		GlobalMonth=globalMonth;
		parser = new JsonParser();
		DashBoard.main();
		initializeData();
		getMadBrock();
		start();
	}

	private void initializeData() {
		for(int i=0;i<YEAR_LENGTH;i++)	{
		for (int j = 0; j < MONTH_LENGTH; j++) {
				data[i][j] = new ArrayList<Trip>();
			
		}}
		for (int i=0;i<3;i++){
			avgMinTrips[i]=0;
			nonDropOff[i]=0;
			MadBrok[i]=0;
			tripTime[i] = new TripDauration();
		}
		for(int i=0;i<MONTH_LENGTH;i++){
			UniqueVehicles[i]= new HashSet<>();
		}
	}

	private LinkedList<String> start() {
   	 try {
         final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI(Query));
         clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
             public void handleMessage(String message) {
            	 Trip t = parser.setTripData(message);
               	 int day = t.dropDate.getDate();
 				 data[GlobalMonth][day].add(t);
            	 UpdateGUI(t,day);

             }
         }
         
         );
         Thread.sleep(Long.MAX_VALUE);

     } catch (InterruptedException ex) {
         System.err.println("InterruptedException exception: " + ex.getMessage());
     } catch (URISyntaxException ex) {
         System.err.println("URISyntaxException exception: " + ex.getMessage());
     }
		return null;
	}

	private void getMadBrock() {
		for (int i=0;i<locations.size();i++){
			if(locations.get(i).zone.equals("Madison")&&locations.get(i).borough.equals("Brooklyn")){
			MADBROOCLocationID=locations.get(i).id;
		}}
	}
	
	private void UpdateGUI (Trip t,int day){
   	 UniqueVehicles[day-1].add(t.DriverId);
		 int tripGui = Integer.parseInt(DashBoard.totalTrips[day-1].getText().toString())+1;
		 DashBoard.totalTrips[day-1].setText(String.valueOf(tripGui));
		 DashBoard.Vehicles[day-1].setText(String.valueOf(UniqueVehicles[day-1].size()));
		 String type =t.taxi;
			if (t.pickLocId==MADBROOCLocationID) {
			switch (type) {
				case Titles.GREEN:
					 int greenMadBroc = Integer.parseInt(DashBoard.MadBroc[day-1][1].getText().toString())+1;
					 DashBoard.MadBroc[day-1][1].setText(String.valueOf(greenMadBroc));
				case Titles.YELLOW:
					 int yellowMadbroc = Integer.parseInt(DashBoard.MadBroc[day-1][0].getText().toString())+1;
					 DashBoard.MadBroc[day-1][0].setText(String.valueOf(yellowMadbroc));
				case Titles.FHV:
					 int fhvMadBroc = Integer.parseInt(DashBoard.MadBroc[day-1][2].getText().toString())+1;
					 DashBoard.MadBroc[day-1][2].setText(String.valueOf(fhvMadBroc));
			}
			}
			if(t.dropLocId.length()==0){
				switch (type){
					case Titles.GREEN : 
					 int NDGREEN = Integer.parseInt(DashBoard.NDGreen.getText().toString())+1;
					 DashBoard.NDGreen.setText(String.valueOf(NDGREEN));
					case Titles.YELLOW :
						int NDYELLOW = Integer.parseInt(DashBoard.NDYellow.getText().toString())+1;
						 DashBoard.NDYellow.setText(String.valueOf(NDYELLOW));
					case Titles.FHV : 
						int NDFHV = Integer.parseInt(DashBoard.NDFhv.getText().toString())+1;
						 DashBoard.NDFhv.setText(String.valueOf(NDFHV));
				}
			}
			
			switch (type){
			case Titles.GREEN : 
				tripTime[0].totalTrips++;tripTime[0].totalTime+=t.Tripdauration;
				DashBoard.MinGreen.setText(String.format("%02d", tripTime[0].totalTime/tripTime[0].totalTrips));
			case Titles.YELLOW : 
				tripTime[1].totalTrips++;tripTime[1].totalTime+=t.Tripdauration;
				DashBoard.MinYellow.setText(String.format("%02d", tripTime[1].totalTime/tripTime[1].totalTrips));
			case Titles.FHV : 
				tripTime[2].totalTrips++;tripTime[2].totalTime+=t.Tripdauration;
				DashBoard.MinFhv.setText(String.format("%02d", tripTime[2].totalTime/tripTime[2].totalTrips));
				
    }
	}


}
