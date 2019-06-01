package stream;

import java.net.URI;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/endpoint")
public class WebsocketController {
	private static final int MONTH_LENGTH = 32;
	private static final int YEAR_LENGTH = 13;
	private String Query;
	private int globalMonth,globalDay;
	private ArrayList<Trip> [][] data;
	private JsonParser parser ;
	int [] avgMinTrips = new int[3];
	int [] nonDropOff = new int[3];
	int [] MadBrok = new int[3];

	ArrayList<Location> locations;
	public ArrayList<Trip> [][] getData() {
		return data;
	}

	public WebsocketController(String query, int m, int d, ArrayList<Location> loc) {
		super();
		Query = query;
		data = new ArrayList[13][32];
		globalMonth=m;
		globalDay=d;
		locations=loc;
		parser = new JsonParser();
		initializeData();
		start();
	}

	private void initializeData() {
		for(int i=0;i<YEAR_LENGTH;i++) {
			for (int j = 0; j < MONTH_LENGTH; j++) {
				data[i][j] = new ArrayList<Trip>();
			}
		}
		for (int i=0;i<3;i++){
			avgMinTrips[i]=0;
			nonDropOff[i]=0;
			MadBrok[i]=0;
		}
	}

	private LinkedList<String> start() {
   	 try {
         final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI(Query));
         clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
             public void handleMessage(String message) {
            	 Trip t = parser.setTripData(message);
            	 int day = t.dropDate.getDate();
				 int month = t.dropDate.getMonth()+1;
				 data[month][day].add(t);
				 if(day==globalDay&&month==globalMonth) {
					 System.out.println("-------------------------------------------------");
					 makeReport();
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

	void makeReport () {
		System.out.println(" * Numbers of Trips per the day :"+data[globalMonth][globalDay].size());
		System.out.println(" * Averege Vehicles per the day :"+getNoOfVehicles());
		System.out.println(" * Numbers of Trips without drop-off :");
		System.out.println("   Green( "+getNonDrop()[0]+" ), Yellow( "+getNonDrop()[1]+" ), FHV( "+getNonDrop()[2]+" )");
		System.out.println(" * Minutes per trips :");
		System.out.println("   Green( "+getMinutesperTrips()[0]+" ), Yellow( "+getMinutesperTrips()[1]+" ), FHV( "+getMinutesperTrips()[2]+" )");
		System.out.println(" * Numbers of Trips picked from Madison,Broklyn :");
		System.out.println("   Green( "+getMadBrock()[0]+" ), Yellow( "+getMadBrock()[1]+" ), FHV( "+getMadBrock()[2]+" )");
	}

	private int[] getMadBrock() {
		String LocationID ="";
		for (int i=0;i<locations.size();i++){
			if(locations.get(i).zone.equals("Madison")&&locations.get(i).zone.equals("Brooklyn"));
			LocationID=locations.get(i).id;
		}
		if(LocationID!="") {
			for (int i = 0; i < data[globalMonth][globalDay].size(); i++) {
				if (data[globalMonth][globalDay].get(i).pickLocId==LocationID) {
					String type = data[globalMonth][globalDay].get(i).taxi;
					switch (type) {
						case Titles.GREEN:
							MadBrok[0]++;
						case Titles.YELLOW:
							MadBrok[1]++;
						case Titles.FHV:
							MadBrok[2]++;
					}
				}
			}
		}
		return MadBrok;
	}

	private int[] getMinutesperTrips() {
		int countA=1,countB=1,countC=1;
		for(int i=0;i<data[globalMonth][globalDay].size();i++){
			String type = data[globalMonth][globalDay].get(i).taxi;
			long diff =  data[globalMonth][globalDay].get(i).dropDate.getTime()- data[globalMonth][globalDay].get(i).pickDate.getTime();
			long diffMinutes = diff / (60 * 1000) % 60;
			switch (type){
				case Titles.GREEN : avgMinTrips[0]+=diffMinutes;countA++;
				case Titles.YELLOW : avgMinTrips[1]+=diffMinutes;countB++;
				case Titles.FHV : avgMinTrips[2]+=diffMinutes;countC++;
			}
		}
		avgMinTrips[0]/=countA;
		avgMinTrips[1]/=countB;
		avgMinTrips[2]/=countC;
		return avgMinTrips;
	}

	private int [] getNonDrop() {
		for(int i=0;i<data[globalMonth][globalDay].size();i++){
			if(data[globalMonth][globalDay].get(i).dropLocId==""){
				String type = data[globalMonth][globalDay].get(i).taxi;
				switch (type){
					case Titles.GREEN : nonDropOff[0]++;
					case Titles.YELLOW : nonDropOff[1]++;
					case Titles.FHV : nonDropOff[2]++;
				}
			}
		}
		return nonDropOff;
	}

	private int getNoOfVehicles() {
		Set<String> s = new HashSet<>();
		for(int i=0;i<data[globalMonth][globalDay].size();i++){
			s.add(data[globalMonth][globalDay].get(i).DriverId);
		}
				return s.size();
	}


}
