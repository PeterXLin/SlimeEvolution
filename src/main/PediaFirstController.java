package main;

import java.util.ArrayList;
import java.util.ResourceBundle;

import Slimes.SlimePedia;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

public class PediaFirstController implements Initializable{
	
	@FXML
	ImageView _block1;
	@FXML
	ImageView _block2;
	@FXML
	ImageView _block3;
	@FXML
	ImageView _block4;
	@FXML
	ImageView _block5;
	@FXML
	ImageView _block6;
	@FXML
	ImageView _block7;
	@FXML
	ImageView _block8;
	
	@FXML
	ImageView _slime1;
	@FXML
	ImageView _slime2;
	@FXML
	ImageView _slime3;
	@FXML
	ImageView _slime4;
	@FXML
	ImageView _slime5;
	@FXML
	ImageView _slime6;
	@FXML
	ImageView _slime7;
	@FXML
	ImageView _slime8;
	
	@FXML
	public void btBackPressed() {
		Final_108502003.currentStage.setScene(LoadController.mainScene);
	}
	
	@FXML
	public void btNextPressed() {
		Final_108502003.currentStage.setScene(MainSceneController.secondPedia);
	}
	
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		ArrayList<ImageView> blocks = new ArrayList<>();
		blocks.add(_block1);
		blocks.add(_block2);
		blocks.add(_block3);
		blocks.add(_block4);
		blocks.add(_block5);
		blocks.add(_block6);
		blocks.add(_block7);
		blocks.add(_block8);
		ArrayList<ImageView> slimes = new ArrayList<>();
		slimes.add(_slime1);
		slimes.add(_slime2);
		slimes.add(_slime3);
		slimes.add(_slime4);
		slimes.add(_slime5);
		slimes.add(_slime6);
		slimes.add(_slime7);
		slimes.add(_slime8);
		for(int i=0;i<8;i++) {
			if(SlimePedia.getIndex(i)) {
				blocks.get(i).setVisible(false);
				slimes.get(i).setVisible(true);
			}
		}
	}
}
