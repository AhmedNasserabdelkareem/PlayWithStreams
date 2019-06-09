package stream;

import java.util.Date;

/**
 * @author Ahmednasser
 *
 */
public class Trip {
	String taxi;

	public void setTaxi(String tripType) {
		this.taxi = tripType;
	}

	public void setDriverId(String driverId) {
		DriverId = driverId;
	}

	public void setPickLocId(String pickLocId) {
		this.pickLocId = pickLocId;
	}

	public void setDropLocId(String dropLocId) {
		this.dropLocId = dropLocId;
	}

	public void setType(String type) {
		Type = type;
	}

	public void setPickDate(Date pickDate) {
		this.pickDate = pickDate;
	}

	public void setDropDate(Date dropDate) {
		this.dropDate = dropDate;
	}

	String DriverId;
	String pickLocId;
	String dropLocId;
	String Type;
	Date pickDate;
	Date dropDate;
	Double Tripdauration;

	public void setTripdauration(Double diffMinutes) {
		Tripdauration = diffMinutes;
	}

}
