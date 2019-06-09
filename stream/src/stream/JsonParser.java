package stream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Ahmednasser
 *
 */
public class JsonParser {

	public Trip setTripData(String message) {
		JSONObject obj;
		Trip t = new Trip();
		try {
			obj = new JSONObject(message);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				String dropS = obj.getString(Titles.DROPOFFDATETIME).replaceAll("\"", "");
				Date drop = formatter.parse(dropS);
				String pickS = obj.getString(Titles.PICKUPDATETIME).replaceAll("\"", "");
				Date pick = formatter.parse(pickS);
				String driverS = obj.getString(Titles.DRIVERID).replaceAll("\"", "");
				t.setDriverId(driverS);
				t.setType(obj.getString(Titles.TYPE));
				t.setDropDate(drop);
				String dropLoc = obj.getString(Titles.DROPOFFLOCATIONID).replaceAll("\"", "");
				t.setDropLocId(dropLoc);
				t.setPickDate(pick);
				String pickLock = obj.getString(Titles.PICKUPLOCATIONID).replaceAll("\"", "");
				t.setPickLocId(pickLock);
				t.setTaxi(obj.getString(Titles.TAXI));
				Double diff = (double) (drop.getTime() - pick.getTime());
				;
				Double diffMinutes = (diff / (60 * 1000) % 60);
				t.setTripdauration(diffMinutes);
			} catch (ParseException | JSONException e) {
				e.printStackTrace();
			}
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		return t;
	}
}
