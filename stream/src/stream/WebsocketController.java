package stream;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;

public class WebsocketController {
	private String Query;
	private LinkedList<String> data;
	
	public LinkedList<String> getData() {
		return data;
	}

	public WebsocketController(String query) {
		super();
		Query = query;
		start();
	}

	private LinkedList<String> start() {
		data = new LinkedList<>();
   	 try {
         final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI(Query));
         clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
             public void handleMessage(String message) {
            	 data.push(message);
                // System.out.println(message);
             }
         });

         clientEndPoint.sendMessage("start");
         Thread.sleep(1000);

     } catch (InterruptedException ex) {
         System.err.println("InterruptedException exception: " + ex.getMessage());
     } catch (URISyntaxException ex) {
         System.err.println("URISyntaxException exception: " + ex.getMessage());
     }
		return null;
	}
	

}
