package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;

import application.ProgrammStartKlasse;

public class MainController {
	=======
	public class MainController {
		>>>>>>>branch'master'
		of https:// github.com/KiraShimo/GitMineJump.git

		public Main main;

		public void setMain(Main main) {
			this.main = main;
		}

	@FXML
	private void BtnStartAction(ActionEvent actionevent){
<<<<<<< HEAD

		public void game(Stage primaryStage) {

	=======

		/*@Override
		public void start(Stage primaryStage) {
>>>>>>> branch 'master' of https://github.com/KiraShimo/GitMineJump.git
			try {
				SpielFX Spiel = new SpielFX();
				Scene game = new Scene(Spiel.getRootPane());
		        primaryStage.setScene(game); 
		        primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
<<<<<<< HEAD
		}
=======
		}*/
>>>>>>> branch 'master' of https://github.com/KiraShimo/GitMineJump.git
		}
	}

		@FXML
		private void BtnExitAction(ActionEvent actionEvent) {
			Platform.exit();
		}

		public void start(Stage primaryStage) {
			try {
				factory();
				Scene game = new Scene(Spiel.getRootPane());
				primaryStage.setScene(game);
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}