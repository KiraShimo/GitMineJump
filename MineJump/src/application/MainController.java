package application;

//import application.Menu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MainController{
	
	public Stage primaryStage;
	
	public Main main;
	
	Menu menu = new Menu();
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	public void setPrimaryStage(Stage primaryStage) {
		 this.primaryStage = primaryStage;
	}
	
	@FXML
	private void BtnStartAction(ActionEvent actionEvent) {
		//menu.level(primaryStage);
		menu.spiel(primaryStage);        //Spielaufruf in Menu.java
	}
	
	@FXML
	private void BtnExitAction(ActionEvent actionEvent) {
		Platform.exit();
	}
	
	@FXML
	private void BtnLevel1Action(ActionEvent actionEvent) {
		menu.spiel(primaryStage);        //Spielaufruf in Menu.java
	}
}
