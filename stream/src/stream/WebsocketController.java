package stream;

import java.net.URI;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.websocket.server.ServerEndpoint;

import org.json.JSONObject;

@ServerEndpoint("/endpoint")
public class WebsocketController {
	private static final int MONTH_LENGTH = 31;
	private String Query;
	private ArrayList<Trip> [] data;
	private JsonParser parser ;
	public ArrayList<Trip> [] getData() {
		return data;
	}

	public WebsocketController(String query) {
		super();
		Query = query;
		data = new ArrayList[31];
		parser = new JsonParser();
		initializeData();
		start();
	}

	private void initializeData() {
		// TODO Auto-generated method stub
		for(int i=0;i<MONTH_LENGTH;i++){
			data[i] = new ArrayList<Trip>();
		}
		
	}

	private LinkedList<String> start() {
   	 try {
         final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI(Query));
         clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
             public void handleMessage(String message) {
            	 Trip t = parser.setTripData(message);
            	 int day = t.dropDate.getDate()-1;
            	 data[day].add(t);
                // System.out.println(message);
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
	

}
