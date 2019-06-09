package test;

import Controller.WebsocketController;
import Utils.LocationsReader;

/**
 * @author Ahmednasser
 *
 */
public class main {

	public static void main(String[] args) {
		LocationsReader locationsReader = new LocationsReader(System.getProperty("user.dir")+"\\steam\\src\\dataset\\taxi_zones_simple.csv");
		WebsocketController controller = new WebsocketController("ws://localhost:9000/ws", 11,
				locationsReader.getLocations());

	}

}
