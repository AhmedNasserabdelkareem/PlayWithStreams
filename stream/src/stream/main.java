package stream;

import Gui.Dashboard;
import javafx.application.Application;
import javafx.stage.Stage;


public class main extends Application {

	@Override
	public void start(Stage primaryStage) {
		/*
		Application to pick your target Date
		 */
		Dashboard d = new Dashboard();
		d.show(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}