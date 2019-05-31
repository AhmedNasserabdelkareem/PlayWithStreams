package stream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {
	ArrayList<String> rows;
	ArrayList<Trip> trips;
	public JsonParser(ArrayList<String> rows) {
		rows= new ArrayList<>();
		trips= new ArrayList<>();
		this.rows = rows;
		parseStrings();
	}

	private void parseStrings() {
		// TODO Auto-generated method stub
		for(int i=0;i<rows.size();i++){
			try {
				JSONObject obj = new JSONObject(rows.get(i));
				setTripData(obj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private Trip setTripData(JSONObject obj) {
		// TODO Auto-generated method stub
	    SimpleDateFormat formatter =new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");  
		Trip t = new Trip();
		try {
			Date drop = formatter.parse(obj.getString(Titles.DROPOFFDATETIME));
			Date pick = formatter.parse(obj.getString(Titles.PICKUPDATETIME));
			t.setDriverId(obj.getInt(Titles.DRIVERID));
			t.setType(obj.getString(Titles.TYPE));
			t.setDropDate(drop);
			t.setDropLocId(obj.getInt(Titles.DROPOFFLOCATIONID));
			t.setPickDate(pick);
			t.setPickLocId(obj.getInt(Titles.PICKUPLOCATIONID));
			t.setTaxi(obj.getString(Titles.TAXI));
		} catch (ParseException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public ArrayList<Trip> getTrips() {
		return trips;
	}
	

}
