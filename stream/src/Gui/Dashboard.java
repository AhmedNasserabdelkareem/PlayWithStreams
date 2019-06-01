package Gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import stream.LocationsReader;
import stream.WebsocketController;

import java.time.LocalDate;

public class Dashboard {
    final static String LOCAL_HOST = "ws://localhost:9000/ws";
    private static Stage s;

    @FXML
    private DatePicker datePick;

    public void show(Stage primaryStage){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent root1 = fxmlLoader.load();
            s=primaryStage;
            primaryStage.setScene(new Scene(root1));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    Read Taxi_Zone_simple to get Locations IDs
     */

@FXML
    public void PrintData(javafx.event.ActionEvent actionEvent) {
    LocationsReader r = new LocationsReader("taxi_zones_simple.csv");
    LocalDate value = datePick.getValue();
    int Day = value.getDayOfMonth();
    int Month = value.getMonthValue();
    s.close();// Close Application and Start receiving from Websocket
    WebsocketController c = new WebsocketController(LOCAL_HOST,Month,Day,r.getLocations());

}
}
