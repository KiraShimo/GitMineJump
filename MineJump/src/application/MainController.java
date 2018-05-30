package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
	
	public Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	private void BtnStartAction(ActionEvent actionevent) {
		/*public void game(Stage primaryStage) {
			try {
				//Scene game = new Scene(HIER DEINE PANE);
		        primaryStage.setScene(Spiel); 
		        primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}*/
	}
	
	@FXML
	private void BtnExitAction(ActionEvent actionEvent) {
		Platform.exit();
	}
	
}
