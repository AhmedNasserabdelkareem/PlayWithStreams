package stream;

import java.net.URI;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/endpoint")
public class WebsocketController {
	private String Query;
	private ArrayList<String> data;
	public ArrayList<String> getData() {
		return data;
	}

	public WebsocketController(String query) {
		super();
		Query = query;
		data = new ArrayList<>();
		start();
	}

	private LinkedList<String> start() {
   	 try {
         final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI(Query));
         clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
             public void handleMessage(String message) {
            	 data.add(message);            	 
                 System.out.println(message);
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
