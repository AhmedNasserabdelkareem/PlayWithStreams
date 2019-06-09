package stream;

/**
 * @author Ahmednasser
 *
 */
public class main {

	public static void main(String[] args) {
		LocationsReader locationsReader = new LocationsReader("taxi_zones_simple.csv");
		WebsocketController controller = new WebsocketController("ws://localhost:9000/ws", 11,
				locationsReader.getLocations());

	}

}
