package main;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MenuController {
	
	@FXML
	public void btStartPressed() throws IOException{
		Parent loadRoot = FXMLLoader.load(getClass().getResource("load.fxml"));
		Scene loadScene = new Scene(loadRoot);
		Final_108502003.currentStage.setScene(loadScene);
		buttonClicked();
	}
	@FXML
	public void btEndPressed() {
		buttonClicked();
		Final_108502003.currentStage.close();
	}
	
	public void buttonClicked() {
		Media media = new Media(getClass().getResource("/sounds/button.wav").toString());
		MediaPlayer player = new MediaPlayer(media);
		player.play();
	}
}
