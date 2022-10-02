package main;

import java.util.ArrayList;
import java.util.ResourceBundle;

import Slimes.SlimePedia;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

public class PediaSecondController implements Initializable{
	
	@FXML
	ImageView block9;
	@FXML
	ImageView block10;
	@FXML
	ImageView block11;
	@FXML
	ImageView block12;
	@FXML
	ImageView block13;
	@FXML
	ImageView block14;
	@FXML
	ImageView block15;
	@FXML
	ImageView block16;
	
	@FXML
	ImageView _slime9;
	@FXML
	ImageView _slime10;
	@FXML
	ImageView _slime11;
	@FXML
	ImageView _slime12;
	@FXML
	ImageView _slime13;
	@FXML
	ImageView _slime14;
	@FXML
	ImageView _slime15;
	@FXML
	ImageView _slime16;
	
	@FXML
	public void btBackPressed() {
		Final_108502003.currentStage.setScene(LoadController.mainScene);
	}
	
	@FXML
	public void btNextPressed() {
		Final_108502003.currentStage.setScene(MainSceneController.firstPedia);
	}
	
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		
		ArrayList<ImageView> blocks = new ArrayList<>();
		blocks.add(block9);
		blocks.add(block10);
		blocks.add(block11);
		blocks.add(block12);
		blocks.add(block13);
		blocks.add(block14);
		blocks.add(block15);
		blocks.add(block16);
		
		ArrayList<ImageView> slimes = new ArrayList<>();
		slimes.add(_slime9);
		slimes.add(_slime10);
		slimes.add(_slime11);
		slimes.add(_slime12);
		slimes.add(_slime13);
		slimes.add(_slime14);
		slimes.add(_slime15);
		slimes.add(_slime16);
		
		for(int i=8;i<16;i++) {
			if(SlimePedia.getIndex(i)) {
				blocks.get(i-8).setVisible(false);
				slimes.get(i-8).setVisible(true);
			}
		}
	}
}
