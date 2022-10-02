package main;

import java.net.URL;
import java.util.ResourceBundle;

import Slimes.SlimePedia;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class SummonController implements Initializable{
	
	int mental = 0, wood = 0, water = 0, fire = 0, earth = 0;
	int count = 0;
	int bt1 = 5, bt2 = 5, bt3 = 5;
	
	@FXML
	ImageView _elementTable;
	
	@FXML
	Label _slimeName;
	
	@FXML
	ImageView _background;
	
	@FXML
	Pane _elementPane;
	
	@FXML
	Label _metalAmount;
	
	@FXML
	Label _woodAmount;
	
	@FXML
	Label _waterAmount;
	
	@FXML
	Label _fireAmount;
	
	@FXML
	Label _earthAmount;

	@FXML
	Button btConfirm;

	@FXML
	ImageView image1;

	@FXML
	ImageView image2;

	@FXML
	ImageView image3;

	@FXML
	ImageView result;
	
	@FXML
	Button _bt1;
	
	@FXML
	Button _bt2;
	
	@FXML
	Button _bt3;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bt1 = getRandomFood(image1);
		bt2 = getRandomFood(image2);
		bt3 = getRandomFood(image3);
	}
	
	@FXML
	public void elementPaneEntered() {
		_elementTable.setVisible(true);
	}
	
	@FXML
	public void elementPaneExited() {
		_elementTable.setVisible(false);
	}


	@FXML
	public void bt1Pressed() {
		eat(bt1);
	}

	@FXML
	public void bt2Pressed() {
		eat(bt2);
	}

	@FXML
	public void bt3Pressed() {
		eat(bt3);
	}

	@FXML
	public void btConfirmPressed() {
		Final_108502003.currentStage.setScene(LoadController.mainScene);
	}

	private void eat(int bt) {
		if (count < 5) {
			switch (bt) {
			case 0:
				mental++;
				_metalAmount.setText(""+mental);
				break;
			case 1:
				wood++;
				_woodAmount.setText(""+wood);
				break;
			case 2:
				water++;
				_waterAmount.setText(""+water);
				break;
			case 3:
				fire++;
				_fireAmount.setText(""+fire);
				break;
			case 4:
				earth++;
				_earthAmount.setText(""+earth);
				break;
			default:
				break;
			}
			bt1 = getRandomFood(image1);
			bt2 = getRandomFood(image2);
			bt3 = getRandomFood(image3);
			count++;
		}
		
		if (count == 5) {
			
			_bt1.setVisible(false);
			_bt2.setVisible(false);
			_bt3.setVisible(false);
			image1.setVisible(false);
			image2.setVisible(false);
			image3.setVisible(false);
			_elementPane.setVisible(false);
			
			_slimeName.setVisible(true);
			
			_background.setImage(new Image(getClass().getResourceAsStream("/images/stage2.jpg")));
			result.setImage(new Image(getClass().getResourceAsStream(generateSlime(mental, wood, water, fire, earth))));
			result.setLayoutX(375);
			
			//background
			FadeTransition ft = new FadeTransition(Duration.millis(4000));
			ft.setNode(_background);
			ft.setFromValue(0.0);
			ft.setToValue(1.0);
			ft.play();
			
			// result image
			FadeTransition ft2 = new FadeTransition(Duration.millis(5000));
			ft2.setNode(result);
			ft2.setFromValue(0.0);
			ft2.setToValue(1.0);
			ft2.play();
			
			// slime name
			FadeTransition ft3 = new FadeTransition(Duration.millis(7000));
			ft3.setNode(_slimeName);
			ft3.setFromValue(0.0);
			ft3.setToValue(1.0);
			ft3.play();
			
			
		}
	}
	
	@FXML
	public void showComfirmButton() {
		if(count == 5) {
			btConfirm.setVisible(true);
			btConfirm.setDisable(false);
		}
	}

	private int getRandomFood(ImageView view) {
		int type = (int) (Math.random() * 5);
		if (type == 0) {
			view.setImage(new Image(
					getClass().getResourceAsStream("/images/foods/metal/" + (int) (Math.random() * 20 + 1) + ".png")));
			return 0;
		} else if (type == 1) {
			view.setImage(new Image(
					getClass().getResourceAsStream("/images/foods/wood/" + (int) (Math.random() * 16 + 1) + ".png")));
			return 1;
		} else if (type == 2) {
			view.setImage(new Image(
					getClass().getResourceAsStream("/images/foods/water/" + (int) (Math.random() * 20 + 1) + ".png")));
			return 2;
		} else if (type == 3) {
			view.setImage(new Image(
					getClass().getResourceAsStream("/images/foods/fire/" + (int) (Math.random() * 20 + 1) + ".png")));
			return 3;
		} else {
			view.setImage(new Image(
					getClass().getResourceAsStream("/images/foods/earth/" + (int) (Math.random() * 19 + 1) + ".png")));
			return 4;
		}
	};

	private String generateSlime(int me, int wo, int wa, int fi, int ea) {
		if (me >= 3) {
			if (me >= 4) {
				SlimePedia.setIndex(0, true);
				_slimeName.setText("¶Àª÷¥vµÜ©i");
				return "/images/slimes/metal.png";
			} else {
				SlimePedia.setIndex(5, true);
				_slimeName.setText("¤ô»È¥vµÜ©i");
				return "/images/slimes/silver.png";
			}
		} else if (wo >= 3) {
			if (wo >= 4) {
				SlimePedia.setIndex(1, true);
				_slimeName.setText("ºñ¸­¥vµÜ©i");
				return "/images/slimes/wood.png";
			} else {
				SlimePedia.setIndex(6, true);
				_slimeName.setText("ªáªá¥vµÜ©i");
				return "/images/slimes/flower.png";
			}
		} else if (wa >= 3) {
			if (wa >= 4) {
				SlimePedia.setIndex(2, true);
				_slimeName.setText("¤ôºw¥vµÜ©i");
				return "/images/slimes/water.png";
			} else {
				SlimePedia.setIndex(7, true);
				_slimeName.setText("´òªy¥vµÜ©i");
				return "/images/slimes/lake.png";
			}
		} else if (fi >= 3) {
			if (fi >= 4) {
				SlimePedia.setIndex(3, true);
				_slimeName.setText("¯P¤õ¥vµÜ©i");
				return "/images/slimes/fire.png";
			} else {
				SlimePedia.setIndex(8, true);
				_slimeName.setText("¤õ¤s¥vµÜ©i");
				return "/images/slimes/volcano.png";
			}
		} else if (ea >= 3) {
			if (ea >= 4) {
				SlimePedia.setIndex(4, true);
				_slimeName.setText("¤j¦a¥vµÜ©i");
				return "/images/slimes/earth.png";
			} else {
				SlimePedia.setIndex(9, true);
				_slimeName.setText("Äq¥Û¥vµÜ©i");
				return "/images/slimes/mine.png";
			}
		} else if (me == 2 && (wo == 2 || wa == 2 || fi == 2 || ea == 2)) {
			if (wo == 2) {
				SlimePedia.setIndex(11, true);
				_slimeName.setText("Âø¯ó¥vµÜ©i");
				return "/images/slimes/weed.png";
			} else if (wa == 2) {
				SlimePedia.setIndex(5, true);
				_slimeName.setText("¤ô»È¥vµÜ©i");
				return "/images/slimes/silver.png";
			} else if (fi == 2) {
				SlimePedia.setIndex(10, true);
				_slimeName.setText("¼oÅK¥vµÜ©i");
				return "/images/slimes/scrapiron.png";
			} else {
				SlimePedia.setIndex(9, true);
				_slimeName.setText("Äq¥Û¥vµÜ©i");
				return "/images/slimes/mine.png";
			}
		} else if (wo == 2 && (wa == 2 || fi == 2 || ea == 2)) {
			if (wa == 2) {
				SlimePedia.setIndex(7, true);
				_slimeName.setText("´òªy¥vµÜ©i");
				return "/images/slimes/lake.png";
			} else if (fi == 2) {
				SlimePedia.setIndex(6, true);
				_slimeName.setText("ªáªá¥vµÜ©i");
				return "/images/slimes/flower.png";
			} else {
				SlimePedia.setIndex(14, true);
				_slimeName.setText("Äêªd¥vµÜ©i");
				return "/images/slimes/mud.png";
			}
		} else if (wa == 2 && (fi == 2 || ea == 2)) {
			if (fi == 2) {
				SlimePedia.setIndex(13, true);
				_slimeName.setText("¦ÇÂu¥vµÜ©i");
				return "/images/slimes/ash.png";
			} else {
				SlimePedia.setIndex(12, true);
				_slimeName.setText("¦¾¤ô¥vµÜ©i");
				return "/images/slimes/sewage.png";
			}
		} else if (fi == 2 && ea == 2) {
			SlimePedia.setIndex(8, true);
			_slimeName.setText("¤õ¤s¥vµÜ©i");
			return "/images/slimes/volcano.png";
		} else if (me == 2 && wo < 2 && wa < 2 && fi < 2 && ea < 2) {
			SlimePedia.setIndex(10, true);
			_slimeName.setText("¼oÅK¥vµÜ©i");
			return "/images/slimes/scrapiron.png";
		} else if (wo == 2 && me < 2 && wa < 2 && fi < 2 && ea < 2) {
			SlimePedia.setIndex(11, true);
			_slimeName.setText("Âø¯ó¥vµÜ©i");
			return "/images/slimes/weed.png";
		} else if (wa == 2 && wo < 2 && me < 2 && fi < 2 && ea < 2) {
			SlimePedia.setIndex(12, true);
			_slimeName.setText("¦¾¤ô¥vµÜ©i");
			return "/images/slimes/sewage.png";
		} else if (fi == 2 && wo < 2 && wa < 2 && me < 2 && ea < 2) {
			SlimePedia.setIndex(13, true);
			_slimeName.setText("¦ÇÂu¥vµÜ©i");
			return "/images/slimes/ash.png";
		} else if (ea == 2 && wo < 2 && wa < 2 && fi < 2 && me < 2) {
			SlimePedia.setIndex(14, true);
			_slimeName.setText("Äêªd¥vµÜ©i");
			return "/images/slimes/mud.png";
		} else {
			SlimePedia.setIndex(15, true);
			_slimeName.setText("³±¶§¥vµÜ©i");
			return "/images/slimes/yinyang.png";
		}
	}

	
}
