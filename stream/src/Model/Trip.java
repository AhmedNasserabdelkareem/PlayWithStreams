package Model;

import java.util.Date;

/**
 * @author Ahmednasser
 *
 */
public class Trip {
	String taxi;
	String DriverId;
	String pickLocId;
	String dropLocId;
	String Type;
	Date pickDate;
	Date dropDate;
	Double Tripdauration;

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

	public String getTaxi() {
		return taxi;
	}

	public String getDriverId() {
		return DriverId;
	}

	public String getPickLocId() {
		return pickLocId;
	}

	public String getDropLocId() {
		return dropLocId;
	}

	public String getType() {
		return Type;
	}

	public Date getPickDate() {
		return pickDate;
	}

	public Date getDropDate() {
		return dropDate;
	}

	public Double getTripdauration() {
		return Tripdauration;
	}

	public void setTripdauration(Double diffMinutes) {
		Tripdauration = diffMinutes;
	}

}
