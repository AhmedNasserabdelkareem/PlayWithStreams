package Model;

/**
 * @author Ahmednasser
 *
 */
public class Location {

	public String id;

	public Location(String id, String zone, String borough) {
		this.id = id;
		this.zone = zone;
		this.borough = borough;
	}

	public String zone;
	public String borough;

}
