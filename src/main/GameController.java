package main;

import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class GameController implements Initializable, EventHandler<KeyEvent> {

	@FXML
	Pane _field;

	// win
	@FXML
	Pane _result;
	@FXML
	Label _resultMessage;

	// game
	@FXML
	ImageView _slime;
	@FXML
	ImageView _slimeBall;
	@FXML
	Label _money;
	int money = 0;
	
	int enemyGeneraterSpeed = 150;
	double enemyMoveSpeed = 1.5;

	// HP
	@FXML
	ImageView heart1;
	@FXML
	Label _HP;

	// generate enemy
	int count = 0;

	// upgrade
	@FXML
	Pane _upgrade;
	@FXML
	ImageView _upgrade1;
	@FXML
	ImageView _upgrade2;
	@FXML
	ImageView _upgrade3;
	@FXML
	Label _upgradeText;

	int goal = 10;
	int kills = 0;
	
	int upgrade = 0;

	int choose1;
	int choose2;
	int choose3;
	boolean resetUpgrade = true;
	

	// 
	int HP = 3;
	double moveSpeed;
	int attack;
	int reloadSpeed;
	int shootAmount;
	String attackURL;

	double ballWidth = 30;
	double enemyHeight = 40;
	double enemyWidth = 40;
	int slimeHeight = 99;
	int slimeWidth = 102;

	boolean ableShoot = true;
	boolean ableMove = true;

	LinkedList<ImageView> _bullets = new LinkedList<ImageView>();
	LinkedList<Label> _enemys = new LinkedList<Label>();

	////////////////////////////////////////////////////////////////////////////////////////////
	// keyboard
	public void handle(KeyEvent e) {

		// move left
		if (e.getCode() == KeyCode.A) {
			if (ableMove) {
				if (!tooLeft()) {
					_slime.setLayoutX(_slime.getLayoutX() - moveSpeed);
				} else {
					_slime.setLayoutX(0);
				}

				Timeline moveLeft = new Timeline(new KeyFrame(Duration.millis(10), (d) -> {
					if (!tooLeft()) {
						_slime.setLayoutX(_slime.getLayoutX() - moveSpeed);
					} else {
						_slime.setLayoutX(0);
					}
				}));
				moveLeft.setCycleCount(9);
				moveLeft.play();
			}
		}

		// move right
		if (e.getCode() == KeyCode.D) {
			if (ableMove) {
				if (!tooRight()) {
					_slime.setLayoutX(_slime.getLayoutX() + moveSpeed);
				} else {
					_slime.setLayoutX(900 - slimeWidth);
				}

				Timeline moveRight = new Timeline(new KeyFrame(Duration.millis(10), (d) -> {
					if (!tooRight()) {
						_slime.setLayoutX(_slime.getLayoutX() + moveSpeed);
					} else {
						_slime.setLayoutX(900 - slimeWidth);
					}
				}));
				moveRight.setCycleCount(9);
				moveRight.play();
			}
		}

		// shoot
		if (e.getCode() == KeyCode.SPACE) {
			if (ableShoot) {
				ableShoot = false;
				generateBullet();
				Timeline shoot = new Timeline(new KeyFrame(Duration.millis(250 - reloadSpeed), (d) -> {
					ableShoot = true;
				}));
				shoot.setCycleCount(1);
				shoot.play();
			}
		}
	}

	private boolean tooRight() {
		if (_slime.getLayoutX() + moveSpeed*10 + slimeWidth > 900) {
			return true;
		} else {
			return false;
		}
	}

	private boolean tooLeft() {
		if (_slime.getLayoutX() - moveSpeed*10 < 0) {
			return true;
		} else {
			return false;
		}
	}

	private void generateBullet() {
		if (shootAmount % 2 == 1) {
			for (int i = -(shootAmount / 2); i <= (shootAmount / 2); i++) {
				ImageView newImg = new ImageView(new Image(getClass().getResourceAsStream("/images/attacks/"+attackURL)));
				newImg.setFitWidth(30);
				newImg.setFitHeight(30);
				newImg.setLayoutX(
						_slime.getLayoutX() + _slime.getFitWidth() / 2 - _slimeBall.getFitWidth() / 2 + i * ballWidth);
				newImg.setLayoutY(_slime.getLayoutY());
				_bullets.push(newImg);
				_field.getChildren().add(newImg);
			}
		} else {
			for (int i = -(shootAmount / 2); i < (shootAmount / 2); i++) {
				ImageView newImg = new ImageView(new Image(getClass().getResourceAsStream("/images/attacks/"+attackURL)));
				newImg.setFitWidth(30);
				newImg.setFitHeight(30);
				newImg.setLayoutX(_slime.getLayoutX() + (_slime.getFitWidth() / 2) + i * ballWidth);
				newImg.setLayoutY(_slime.getLayoutY());
				_bullets.push(newImg);
				_field.getChildren().add(newImg);
			}
		}

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////
	// game proceed
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {

		HP = 2 + ChooseSlimeController.choosed.getHP();
		attack = ChooseSlimeController.choosed.getAttack();
		moveSpeed = 1.5 + (ChooseSlimeController.choosed.getMoveSpeed() / 2);
		reloadSpeed = 30 * ChooseSlimeController.choosed.getShootSpeed();
		shootAmount = ChooseSlimeController.choosed.getShootAmount();
		attackURL = ChooseSlimeController.choosed.getAttackURL();
		_HP.setText("" + HP);
		_slime.setImage(
				new Image(getClass().getResourceAsStream("/images/slimes/" + ChooseSlimeController.choosed.getURL())));

		// keep doing
		Timeline fps = new Timeline(new KeyFrame(Duration.millis(1000 / 60), (e) -> {
			// (1) upgrade
			if (kills >= goal && upgrade < 4) {
				if (resetUpgrade) {
					choose1 = upgradeChoice( _upgrade1);
					choose2 = upgradeChoice(_upgrade2);
					choose3 = upgradeChoice(_upgrade3);
					_upgrade.setVisible(true);
					resetUpgrade = false;
					
					ableShoot = false;
					ableMove = false;
		
					
					ArrayList<Label> tEnemys = new ArrayList<Label>(_enemys);
					ArrayList<ImageView> tBullets = new ArrayList<ImageView>(_bullets);
					for(var a:tEnemys) {
						_field.getChildren().remove(a);
						_enemys.remove(a);
					}
					for(var b:tBullets) {
						_field.getChildren().remove(b);
						_bullets.remove(b);
					}
				}
				else if(_bullets.size()!=0||_enemys.size()!=0){
					ableShoot = false;
					ArrayList<Label> tEnemys = new ArrayList<Label>(_enemys);
					ArrayList<ImageView> tBullets = new ArrayList<ImageView>(_bullets);
					for(var a:tEnemys) {
						_field.getChildren().remove(a);
						_enemys.remove(a);
					}
					for(var b:tBullets) {
						_field.getChildren().remove(b);
						_bullets.remove(b);
					}
				}
			// become harder
			}else if(kills >= 40) {
				kills = 0;
				upgrade++;
				if(enemyGeneraterSpeed>10) {
					enemyGeneraterSpeed = enemyGeneraterSpeed - 10;
				}
			}
			// (2) game proceed
			else if (HP > 0) {

				ArrayList<Label> tEnemys = new ArrayList<Label>(_enemys);
				ArrayList<ImageView> tBullets = new ArrayList<ImageView>(_bullets);

				// enemy move and check if enemy out of bound
				for (var a : tEnemys) {
					a.setLayoutY(a.getLayoutY() + enemyMoveSpeed);

					if (a.getLayoutY() > 600 - enemyWidth) {
						HP--;
						_HP.setText("" + HP);
						_enemys.remove(a);
						_field.getChildren().remove(a);
					}
				}

				// bullet move, hit enemy and bullet out of bounds
				for (var b : tBullets) {
					b.setLayoutY(b.getLayoutY() - 5);

					for (var a : tEnemys) {

						if (b.getLayoutY() <= a.getLayoutY() + enemyHeight && b.getLayoutY() >= a.getLayoutY()
								&& b.getLayoutX() > a.getLayoutX() - ballWidth
								&& b.getLayoutX() < a.getLayoutX() + enemyWidth) {

							if (Integer.parseInt(a.getText()) - attack >= 1) {
								a.setText("" + (Integer.parseInt(a.getText()) - attack));
								_bullets.remove(b);
								_field.getChildren().remove(b);
							} else {
								
								_enemys.remove(a);
								_field.getChildren().remove(a);
								_bullets.remove(b);
								_field.getChildren().remove(b);
			
								money = money + 2;
								_money.setText(money + " dollars");
								
								kills++;
							}
						}
					}
					if (b.getLayoutY() < 0) {
						_bullets.remove(b);
						_field.getChildren().remove(b);
					}
				}

				// run 150 times, then create an enemy
				if (count == enemyGeneraterSpeed) {
					generateEnemy();
					count = 0;
				} else {
					count++;
				}

				// (3) end game
			} else {

				for (var a : _bullets) {
					a.setVisible(false);
				}
				for (var b : _enemys) {
					b.setVisible(false);
				}

				ableMove = false;
				ableShoot = false;
				_resultMessage.setText("你獲得了" + money + "元");
				_result.setVisible(true);
			}
		}));
		fps.setCycleCount(Timeline.INDEFINITE);
		fps.play();
	}

	////////////////////////////////////////////////////////////////////////////////////////

	// (1) upgrade

	public int upgradeChoice(ImageView img) {
		int tmpChoose =  ((int) (Math.random() * 5) + 1 );

		switch (tmpChoose) {
		case 1:
			img.setImage(new Image(getClass().getResourceAsStream("/images/metal.png")));
			break;
		case 2:
			img.setImage(new Image(getClass().getResourceAsStream("/images/wood.png")));
			break;
		case 3:
			img.setImage(new Image(getClass().getResourceAsStream("/images/water.png")));
			break;
		case 4:
			img.setImage(new Image(getClass().getResourceAsStream("/images/fire.png")));
			break;
		case 5:
			img.setImage(new Image(getClass().getResourceAsStream("/images/earth.png")));
			break;
		default:
			System.out.println("upgrade error");
			break;
		}
		
		return tmpChoose;
	}

	@FXML
	public void choose1Entered() {
		setText(choose1);
	}

	@FXML
	public void choose2Entered() {
		setText(choose2);
	}

	@FXML
	public void choose3Entered() {
		setText(choose3);
	}

	@FXML
	public void upgrade1Clicked() {
		choose(choose1);
		endUpgrade();
	}

	@FXML
	public void upgrade2Clicked() {
		choose(choose2);
		endUpgrade();
	}

	@FXML
	public void upgrade3Clicked() {
		choose(choose3);
		endUpgrade();
	}

	private void setText(int a) {
		_upgradeText.setVisible(true);
		switch (a) {
		case 1:
			_upgradeText.setText("增加攻擊力");
			break;
		case 2:
			_upgradeText.setText("增加發射數");
			break;
		case 3:
			_upgradeText.setText("增加移動速度");
			break;
		case 4:
			_upgradeText.setText("增加發射速度");
			break;
		case 5:
			_upgradeText.setText("增加生命");
		}
	}

	private void choose(int a) {
		switch (a) {
		case 1:
			attack++;
			break;
		case 2:
			shootAmount++;
			break;
		case 3:
			moveSpeed = moveSpeed + 0.5
			;
			break;
		case 4:
			reloadSpeed = reloadSpeed + 30;
			break;
		case 5:
			HP++;
			break;
		default:
			System.out.println("choose error");
			break;
		}
	}
	
	private void endUpgrade() {
		_upgrade.setVisible(false);
		ableMove = true;
		ableShoot = true;
		
		kills = 0;
		goal = 30;
		upgrade++;
		
		_upgradeText.setVisible(false);
		resetUpgrade = true;
		
		enemyMoveSpeed = enemyMoveSpeed + 0.7;
		enemyGeneraterSpeed = enemyGeneraterSpeed - 20;
		count = 0;
	}

	////////////////////////////////////////////////////////////////////////////////////////
	// (2) game proceed
	
	private void generateEnemy() {
		Label newEnemy = new Label("" + ((int) (Math.random() * 6) + 1 + (upgrade*2)));
		newEnemy.setPrefWidth(40);
		newEnemy.setPrefHeight(40);
		newEnemy.setStyle("-fx-background-color:#FFAF99");
		newEnemy.setLayoutX((int) (Math.random() * (900 - slimeWidth)) + slimeWidth / 2);
		newEnemy.setLayoutY(0);
		newEnemy.setAlignment(Pos.CENTER);
		newEnemy.setFont(Font.font("System", FontWeight.BOLD, 24));
		_enemys.push(newEnemy);
		_field.getChildren().add(newEnemy);
	}
	////////////////////////////////////////////////////////////////////////////////////////

	// (3) end game
	@FXML
	public void btSurePressed() {
		MainSceneController._money.setText((Integer.parseInt(MainSceneController._money.getText()) + money) + "");
		LoadController.mainScene.getRoot().requestFocus();
		Final_108502003.currentStage.setScene(LoadController.mainScene);
	}

}
