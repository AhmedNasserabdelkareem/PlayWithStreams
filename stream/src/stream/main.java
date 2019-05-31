package stream;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/endpoint")
public class main {
	final static String LOCAL_HOST = "ws://localhost:9000/ws";
    public static void main(String[] args) {
    	WebsocketController c = new WebsocketController(LOCAL_HOST); 
    	JsonParser parser = new JsonParser(c.getData());
    	Visualizer v = new Visualizer (parser.trips);
    //	printTrips(c.getData());
  }
     
    static void printTrips(ArrayList<String> x){
    	for(int i=0;i<x.size();i++){
    		System.out.println(x.get(i));
    	}
    }
}
