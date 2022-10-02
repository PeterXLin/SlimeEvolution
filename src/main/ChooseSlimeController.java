package main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Slimes.MetalSlime;
import Slimes.Slime;
import Slimes.SlimePedia;
import Slimes.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class ChooseSlimeController implements Initializable {

	ArrayList<Slime> slimes = new ArrayList<Slime>();
	
	ArrayList<ImageView> attack = new ArrayList<ImageView>();
	ArrayList<ImageView> bulletAmount = new ArrayList<ImageView>();
	ArrayList<ImageView> moveSpeed = new ArrayList<ImageView>();
	ArrayList<ImageView> reloadSpeed = new ArrayList<ImageView>();
	ArrayList<ImageView> HP = new ArrayList<ImageView>();

	static Slime choosed;

	int choose = 0;
	boolean moving = false;

	@FXML
	Pane _pane1;
	@FXML
	Pane _pane2;
	@FXML
	Pane _pane3;
	@FXML
	Pane _pane4;
	@FXML
	Pane _pane5;

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
	ImageView _choosed;
	@FXML
	ImageView _right;
	@FXML
	ImageView _left;
	
	@FXML
	Button _use;
	
	
	//attributes
	@FXML
	ImageView _attack1;
	@FXML
	ImageView _attack2;
	@FXML
	ImageView _attack3;
	
	@FXML
	ImageView _bulletAmount1;
	@FXML
	ImageView _bulletAmount2;
	@FXML
	ImageView _bulletAmount3;
	
	@FXML
	ImageView _moveSpeed1;
	@FXML
	ImageView _moveSpeed2;
	@FXML
	ImageView _moveSpeed3;
	
	@FXML
	ImageView _reloadSpeed1;
	@FXML
	ImageView _reloadSpeed2;
	@FXML
	ImageView _reloadSpeed3;
	
	@FXML
	ImageView _HP1;
	@FXML
	ImageView _HP2;
	@FXML
	ImageView _HP3;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// load slime
		for (int i = 0; i < 16; i++) {
			if (SlimePedia.getIndex(i)) {
				switch (i) {
				case 0:
					MetalSlime metal = new MetalSlime();
					slimes.add(metal);
					break;
				case 1:
					WoodSlime wood = new WoodSlime();
					slimes.add(wood);
					break;
				case 2:
					WaterSlime water = new WaterSlime();
					slimes.add(water);
					break;
				case 3:
					FireSlime fire = new FireSlime();
					slimes.add(fire);
					break;
				case 4:
					EarthSlime earth = new EarthSlime();
					slimes.add(earth);
					break;
				case 5:
					MercurySlime mercury = new MercurySlime();
					slimes.add(mercury);
					break;
				case 6:
					FlowerSlime flower = new FlowerSlime();
					slimes.add(flower);
					break;
				case 7:
					LakeSlime lake = new LakeSlime();
					slimes.add(lake);
					break;
				case 8:
					VolcanoSlime volcano = new VolcanoSlime();
					slimes.add(volcano);
					break;
				case 9:
					MineSlime mine = new MineSlime();
					slimes.add(mine);
					break;
				case 10:
					ScrapIronSlime scrapIron = new ScrapIronSlime();
					slimes.add(scrapIron);
					break;
				case 11:
					WeedSlime weed = new WeedSlime();
					slimes.add(weed);
					break;
				case 12:
					SewageSlime sewage = new SewageSlime();
					slimes.add(sewage);
					break;
				case 13:
					AshSlime ash = new AshSlime();
					slimes.add(ash);
					break;
				case 14:
					MudSlime mud = new MudSlime();
					slimes.add(mud);
					break;
				case 15:
					YinYangSlime yinYang = new YinYangSlime();
					slimes.add(yinYang);
					break;
				default:
					System.out.println("out of bound");
					break;
				}
			} else {
				switch (i) {
				case 0:
					MetalSlime metal = new MetalSlime();
					metal.setURL("question.png");
					slimes.add(metal);
					break;
				case 1:
					WoodSlime wood = new WoodSlime();
					wood.setURL("question.png");
					slimes.add(wood);
					break;
				case 2:
					WaterSlime water = new WaterSlime();
					water.setURL("question.png");
					slimes.add(water);
					break;
				case 3:
					FireSlime fire = new FireSlime();
					fire.setURL("question.png");
					slimes.add(fire);
					break;
				case 4:
					EarthSlime earth = new EarthSlime();
					earth.setURL("question.png");
					slimes.add(earth);
					break;
				case 5:
					MercurySlime mercury = new MercurySlime();
					mercury.setURL("question.png");
					slimes.add(mercury);
					break;
				case 6:
					FlowerSlime flower = new FlowerSlime();
					flower.setURL("question.png");
					slimes.add(flower);
					break;
				case 7:
					LakeSlime lake = new LakeSlime();
					lake.setURL("question.png");
					slimes.add(lake);
					break;
				case 8:
					VolcanoSlime volcano = new VolcanoSlime();
					volcano.setURL("question.png");
					slimes.add(volcano);
					break;
				case 9:
					MineSlime mine = new MineSlime();
					mine.setURL("question.png");
					slimes.add(mine);
					break;
				case 10:
					ScrapIronSlime scrapIron = new ScrapIronSlime();
					scrapIron.setURL("question.png");
					slimes.add(scrapIron);
					break;
				case 11:
					WeedSlime weed = new WeedSlime();
					weed.setURL("question.png");
					slimes.add(weed);
					break;
				case 12:
					SewageSlime sewage = new SewageSlime();
					sewage.setURL("question.png");
					slimes.add(sewage);
					break;
				case 13:
					AshSlime ash = new AshSlime();
					ash.setURL("question.png");
					slimes.add(ash);
					break;
				case 14:
					MudSlime mud = new MudSlime();
					mud.setURL("question.png");
					slimes.add(mud);
					break;
				case 15:
					YinYangSlime yinYang = new YinYangSlime();
					yinYang.setURL("question.png");
					slimes.add(yinYang);
					break;
				default:
					System.out.println("out of bound");
					break;
				}
			}
		}
		
		attack.add(_attack1);
		attack.add(_attack2);
		attack.add(_attack3);
		
		bulletAmount.add(_bulletAmount1);
		bulletAmount.add(_bulletAmount2);
		bulletAmount.add(_bulletAmount3);
		
		moveSpeed.add(_moveSpeed1);
		moveSpeed.add(_moveSpeed2);
		moveSpeed.add(_moveSpeed3);
		
		reloadSpeed.add(_reloadSpeed1);
		reloadSpeed.add(_reloadSpeed2);
		reloadSpeed.add(_reloadSpeed3);
		
		HP.add(_HP1);
		HP.add(_HP2);
		HP.add(_HP3);
		
		_slime3.setImage(new Image(getClass().getResourceAsStream("/images/slimes/" + slimes.get(0).getURL())));
		_slime4.setImage(new Image(getClass().getResourceAsStream("/images/slimes/" + slimes.get(1).getURL())));
		_choosed.setImage(new Image(getClass().getResourceAsStream("/images/slimes/" + slimes.get(0).getURL())));
		showAttributes(0);
		if(SlimePedia.getIndex(0)) {
			_use.setVisible(true);
		}
	}

	@FXML
	public void btRightPressed() {
		// when the choose bar is moving you can't click the button
		if (!moving) {
			// 15 is the last one
			if (choose >= 15) {

			} else if (choose == 0) {
				
				_pane2.setVisible(false);
				
				moveLeft();
				
				Timeline afterMove = new Timeline(new KeyFrame(Duration.millis(525), (d) -> {
					_left.setVisible(true);
				}));
				afterMove.setCycleCount(1);
				afterMove.play();
				
			}else if(choose == 1) {
				// when choose == 0, we close it
				_pane2.setVisible(true);
				
				moveLeft();
			} else if (choose == 14) {
				_right.setVisible(false);
				moveLeft();
			} else {
				moveLeft();
			}
		}
	}

	@FXML
	public void btLeftPressed() {
		if (!moving) {
			if (choose <= 0) {

			} else if (choose == 15) {
				
				_pane4.setVisible(false);
				
				Timeline afterMove = new Timeline(new KeyFrame(Duration.millis(525), (d) -> {
					_right.setVisible(true);
				}));
				afterMove.setCycleCount(1);
				afterMove.play();
				
				moveRight();

			} else if(choose == 14) {
				
				_pane4.setVisible(true);
				moveRight();
				
			} else if (choose == 1) {
				
				_pane2.setVisible(true);
				
				moveRight();
				Timeline afterMove = new Timeline(new KeyFrame(Duration.millis(525), (d) -> {
					_left.setVisible(false);
				}));
				
				afterMove.setCycleCount(1);
				afterMove.play();

			} else {
				moveRight();
			}
		}
	}

	private void moveLeft() {
		
		
		moving = true;
		_use.setVisible(false);
		
		TranslateTransition move1 = new TranslateTransition(Duration.millis(500), _pane1);
		move1.setFromX(0);
		move1.setToX(0);
		move1.setCycleCount(1);
		move1.play();

		if (choose > 0) {
			_slime2.setImage(
					new Image(getClass().getResourceAsStream("/images/slimes/" + slimes.get(choose - 1).getURL())));
			_slime2.setLayoutX(100-(_slime2.getFitWidth()/2));
		}
		TranslateTransition move2 = new TranslateTransition(Duration.millis(500), _pane2);
		move2.setFromX(0);
		move2.setToX(-224);
		move2.setCycleCount(1);
		move2.play();

		_slime3.setImage(new Image(getClass().getResourceAsStream("/images/slimes/" + slimes.get(choose).getURL())));
		_slime3.setLayoutX(100-(_slime3.getFitWidth()/2));
		TranslateTransition move3 = new TranslateTransition(Duration.millis(500), _pane3);
		move3.setFromX(0);
		move3.setToX(-224);
		move3.setCycleCount(1);
		move3.play();

		_slime4.setImage(
				new Image(getClass().getResourceAsStream("/images/slimes/" + slimes.get(choose + 1).getURL())));
		_slime4.setLayoutX(100-(_slime4.getFitWidth()/2));
		TranslateTransition move4 = new TranslateTransition(Duration.millis(500), _pane4);
		move4.setFromX(0);
		move4.setToX(-224);
		move4.setCycleCount(1);
		move4.play();
		
		// choose = 14, click the button to become 15, don't show pane 5
		if (choose < 14) {
			_pane5.setVisible(true);
			_slime5.setImage(
					new Image(getClass().getResourceAsStream("/images/slimes/" + slimes.get(choose + 2).getURL())));
			_slime5.setLayoutX(100-(_slime5.getFitWidth()/2));
		}else {
			_pane5.setVisible(false);
		}
		
		TranslateTransition move5 = new TranslateTransition(Duration.millis(500), _pane5);
		move5.setFromX(0);
		move5.setToX(-224);
		move5.setCycleCount(1);
		move5.play();

		Timeline afterMove = new Timeline(new KeyFrame(Duration.millis(525), (d) -> {
			choose++;
			showAttributes(choose);
			_choosed.setImage(
					new Image(getClass().getResourceAsStream("/images/slimes/" + slimes.get(choose).getURL())));
			if(SlimePedia.getIndex(choose)) {
				_use.setVisible(true);
			}
			moving = false;
			
		}));
		afterMove.setCycleCount(1);
		afterMove.play();
	}

	private void moveRight() {
		moving = true;
		_use.setVisible(false);

		if (choose > 1) {
			_pane1.setVisible(true);
			_slime1.setImage(
					new Image(getClass().getResourceAsStream("/images/slimes/" + slimes.get(choose - 2).getURL())));
			_slime1.setLayoutX(100-(_slime1.getFitWidth()/2));
		} else {
			_pane1.setVisible(false);
		}
		TranslateTransition move1 = new TranslateTransition(Duration.millis(500), _pane1);
		move1.setFromX(0);
		move1.setToX(224);
		move1.setCycleCount(1);
		move1.play();

		_slime2.setImage(
				new Image(getClass().getResourceAsStream("/images/slimes/" + slimes.get(choose - 1).getURL())));
		_slime2.setLayoutX(100-(_slime2.getFitWidth()/2));
		TranslateTransition move2 = new TranslateTransition(Duration.millis(500), _pane2);
		move2.setFromX(0);
		move2.setToX(224);
		move2.setCycleCount(1);
		move2.play();

		_slime3.setImage(new Image(getClass().getResourceAsStream("/images/slimes/" + slimes.get(choose).getURL())));
		_slime3.setLayoutX(100-(_slime3.getFitWidth()/2));
		TranslateTransition move3 = new TranslateTransition(Duration.millis(500), _pane3);
		move3.setFromX(0);
		move3.setToX(224);
		move3.setCycleCount(1);
		move3.play();

		if (choose < 15) {
			_slime4.setImage(
					new Image(getClass().getResourceAsStream("/images/slimes/" + slimes.get(choose + 1).getURL())));
			_slime4.setLayoutX(100-(_slime4.getFitWidth()/2));
		}
		TranslateTransition move4 = new TranslateTransition(Duration.millis(500), _pane4);
		move4.setFromX(0);
		move4.setToX(224);
		move4.setCycleCount(1);
		move4.play();

		TranslateTransition move5 = new TranslateTransition(Duration.millis(500), _pane5);
		move5.setFromX(0);
		move5.setToX(0);
		move5.setCycleCount(1);
		move5.play();

		Timeline afterMove = new Timeline(new KeyFrame(Duration.millis(525), (d) -> {
			choose--;
			showAttributes(choose);
			_choosed.setImage(
					new Image(getClass().getResourceAsStream("/images/slimes/" + slimes.get(choose).getURL())));
			if(SlimePedia.getIndex(choose)) {
				_use.setVisible(true);
			}
			moving = false;
		}));
		afterMove.setCycleCount(1);
		afterMove.play();
	}
	
	@FXML
	public void btSurePressed() throws IOException{
		choosed = slimes.get(choose);
		
		Parent gameRoot = FXMLLoader.load(getClass().getResource("game.fxml"));
		Scene gameScene = new Scene(gameRoot);
		gameScene.getRoot().requestFocus();
		Final_108502003.currentStage.setScene(gameScene);
	}
	
	public void showAttributes(int a) {
		
		for(int i=0;i<slimes.get(a).getAttack();i++) {
			attack.get(i).setVisible(true);
		}
		for(int i=slimes.get(a).getAttack();i<3;i++) {
			attack.get(i).setVisible(false);
		}
		
		for(int i=0;i<slimes.get(a).getShootAmount();i++) {
			bulletAmount.get(i).setVisible(true);
		}
		for(int i=slimes.get(a).getShootAmount();i<3;i++) {
			bulletAmount.get(i).setVisible(false);
		}
		
		for(int i=0;i<slimes.get(a).getMoveSpeed();i++) {
			moveSpeed.get(i).setVisible(true);
		}
		for(int i=(int)slimes.get(a).getMoveSpeed();i<3;i++) {
			moveSpeed.get(i).setVisible(false);
		}
		
		for(int i=0;i<slimes.get(a).getShootSpeed();i++) {
			reloadSpeed.get(i).setVisible(true);
		}
		for(int i=slimes.get(a).getShootSpeed();i<3;i++) {
			reloadSpeed.get(i).setVisible(false);
		}
		
		for(int i=0;i<slimes.get(a).getHP();i++) {
			HP.get(i).setVisible(true);
		}
		for(int i=slimes.get(a).getHP();i<3;i++) {
			HP.get(i).setVisible(false);
		}
	}
	
}
