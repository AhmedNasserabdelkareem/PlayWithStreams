package stream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

	public Trip setTripData(String message) {
		// TODO Auto-generated method stub
		JSONObject obj;
		Trip t = new Trip();
		try {
			obj = new JSONObject(message);
			 SimpleDateFormat formatter =new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
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
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
		return t;
	}
}
