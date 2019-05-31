package stream;

import java.util.LinkedList;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/endpoint")
public class main {
  //  final static CountDownLatch messageLatch = new CountDownLatch(1000);
    public static void main(String[] args) {
    	WebsocketController c = new WebsocketController("ws://localhost:9000/ws"); 
    	LinkedList<String> data =c.getData();
    	for(int i=0;i<data.size();i++){
    		System.out.println(data.get(i));
    	}
  }
}
