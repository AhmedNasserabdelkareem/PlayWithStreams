package stream;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    LocationsReader r = new LocationsReader("taxi_zones_simple.csv");
		WebsocketController c = new WebsocketController("ws://localhost:9000/ws",11, r.getLocations());

	}

}
