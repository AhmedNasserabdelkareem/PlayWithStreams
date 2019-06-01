package stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LocationsReader {
    int count = 0;
    public LocationsReader(String path) {
        locations = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                if(count!=0) {
                    String[] data = line.split(",");
                    Location d = new Location(data[0], data[1], data[2]);
                    locations.add(d);
                }
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace(); }
            }
        }
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }
    private ArrayList<Location> locations;

}
