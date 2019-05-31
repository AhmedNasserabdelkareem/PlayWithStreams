package stream;

import java.util.Date;

public class Trip {
	String taxi;
	public void setTaxi(String tripType) {
		this.taxi = tripType;
	}
	public void setDriverId(int driverId) {
		DriverId = driverId;
	}
	public void setPickLocId(int pickLocId) {
		this.pickLocId = pickLocId;
	}
	public void setDropLocId(int dropLocId) {
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
	int DriverId;
	int pickLocId;
	int dropLocId;
	String Type;
	Date pickDate;
	Date dropDate;
	

}
