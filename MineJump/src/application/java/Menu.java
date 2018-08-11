package application.java;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu {
	double slidervol = 0.0;
	double actualvol;
	Slider slider = new Slider();

	public double getActualvol() {
		return actualvol;
	}

	public void setActualvol() {
		actualvol = slider.getValue();
	}

	public double getSlidervol() {
		System.out.println(slidervol);
		return slidervol;
	}

	public void setSlidervol(double slidervol) {
		System.out.println(slidervol);
		this.slidervol = slidervol;
	}

	public void mainmenu(Stage primaryStage) {
		try {
			// Hauptmenü laden
			FXMLLoader root = new FXMLLoader(getClass().getResource("/application/ressources/Main.fxml"));
			Pane pane = root.load();
			Scene mainmenu = new Scene(pane);
			MainController mainController = root.getController();
			mainController.setPrimaryStage(primaryStage);
			primaryStage.setScene(mainmenu);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void level(Stage primaryStage) {
		try {
			// Levelmenü laden und anzeigen
			FXMLLoader root = new FXMLLoader(getClass().getResource("/application/ressources/Level.fxml"));
			Pane pane = root.load();
			Scene level = new Scene(pane);
			MainController mainController = root.getController();
			mainController.setPrimaryStage(primaryStage);
			primaryStage.setScene(level);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void win(Stage primaryStage) {
		try {
			// Level beendet laden und anzeigen
			FXMLLoader root = new FXMLLoader(getClass().getResource("/application/ressources/Win.fxml"));
			Pane pane = root.load();
			Scene level = new Scene(pane);
			MainController mainController = root.getController();
			mainController.setPrimaryStage(primaryStage);
			primaryStage.setScene(level);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void settings(Stage primaryStage) {
		try {
			// Einstellungsmenü laden und anzeigen
			FXMLLoader root = new FXMLLoader(getClass().getResource("/application/ressources/Settings.fxml"));
	
			
			slider.setMin(0);
		    slider.setMax(100);
		    slider.setValue(slidervol*100);
			slider.setBlockIncrement(1);
			slider.setLayoutX(427);
			slider.setScaleX(1);
			slider.setTranslateX(2);
			slider.setLayoutY(200);
			slider.setScaleY(1);
			slider.setTranslateY(0);
			slider.setPrefWidth(98);
			slider.setPrefHeight(14);
			
			Pane pane = root.load();
			pane.getChildren().add(slider);
			Scene level = new Scene(pane);
			MainController mainController = root.getController();
			mainController.setPrimaryStage(primaryStage);
			primaryStage.setScene(level);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void spiel(Stage primaryStage) throws IOException {

		Level_1 Spiel = new Level_1();
		Spiel.spiel(primaryStage);

	}

	public void spiel2(Stage primaryStage) throws IOException {

		Level_2 Spiel = new Level_2();
		Spiel.spiel(primaryStage);

	}
	public void spiel3(Stage primaryStage) throws IOException {

		Level_3 Spiel = new Level_3();
		Spiel.spiel(primaryStage);

	}
	public void spiel4(Stage primaryStage) throws IOException {

		Level_4 Spiel = new Level_4();
		Spiel.spiel(primaryStage);

	}
	
	
}
