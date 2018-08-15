package application.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu {
	double volume;
	double actualvol;
	char hilf;
		Slider slider = new Slider();

	

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
			FileReader Lautstaerke = new FileReader(
					"C:\\Users\\max.burkhardt\\git\\GitMineJump02\\MineJump\\src\\application\\ressources\\Music.txt");
			BufferedReader Lautstärkeausleser = new BufferedReader(Lautstaerke);
			volume = Double.parseDouble(Lautstärkeausleser.readLine());
			Lautstärkeausleser.close();
			slider.setMin(0);
		    slider.setMax(100);
		    slider.setValue(volume);
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
	
	public int getActualvol() {
		actualvol = slider.getValue();
		System.out.println(slider.getValue());
		return (int) actualvol;
	}

}
