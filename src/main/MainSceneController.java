package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ResourceBundle;

import Slimes.SlimePedia;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MainSceneController implements Initializable, EventHandler<KeyEvent> {

	public static Scene firstPedia;
	public static Scene secondPedia;
	public static Label _money;

	@FXML
	Pane noMoney;

	@FXML
	Label moneyText;

	@FXML
	Pane _option;
	
	@FXML
	Label _noticeText;

	// close option
	@FXML
	public void btCloseOptionPressed() {
		_option.setVisible(false);
		buttonClicked();
	}

	// store file
	@FXML
	public void btStoredFilePressed() {
		BufferedWriter fw = null;
		try {
			File file = new File("record" + LoadController.choose + ".txt");
			fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
			fw.write(LoadController.finalName);
			fw.newLine();
			fw.write(moneyText.getText());
			fw.newLine();

			String tmp = "";
			for (int i = 0; i < 16; i++) {
				if (SlimePedia.getIndex(i)) {
					tmp = tmp + "1";
				} else {
					tmp = tmp + "0";
				}
			}

			fw.write(tmp);
			fw.flush();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		buttonClicked();
	}

	// summon
	@FXML
	public void btSummonPressed() throws IOException {
		if (spendMoney(100)) {
			Parent summonRoot = FXMLLoader.load(getClass().getResource("summon.fxml"));
			Scene summon = new Scene(summonRoot);
			Final_108502003.currentStage.setScene(summon);
		}
		buttonClicked();
	}

	// no enough balance notice
	@FXML
	public void btNoMoneyPressed() {
		noMoney.setVisible(false);
		buttonClicked();
	}

	// battle
	@FXML
	public void btBattlePressed() throws IOException {
		if(SlimePedia.ownAmount()==0) {
			noMoney.setVisible(true);
			_noticeText.setText("©|¥¼¾Ö¦³¥vµÜ©i");
		}else {
			_money = moneyText;
			Parent chooseSlimeRoot = FXMLLoader.load(getClass().getResource("chooseSlime.fxml"));
			Scene chooseSlime = new Scene(chooseSlimeRoot);
			chooseSlime.getRoot().requestFocus();
			Final_108502003.currentStage.setScene(chooseSlime);
		}
		buttonClicked();
	}

	// guild
	@FXML
	public void btPediaPressed() throws IOException {
		Parent pediaRoot1 = FXMLLoader.load(getClass().getResource("pediaFirst.fxml"));
		firstPedia = new Scene(pediaRoot1);
		Parent pediaRoot2 = FXMLLoader.load(getClass().getResource("pediaSecond.fxml"));
		secondPedia = new Scene(pediaRoot2);
		Final_108502003.currentStage.setScene(firstPedia);
		buttonClicked();
	}

	// back to menu
	@FXML
	public void btBackPressed() {
		Final_108502003.currentStage.setScene(Final_108502003.menuScene);
		buttonClicked();
	}

	// work for summon and check if user has enough money
	private boolean spendMoney(int cost) {
		int money = Integer.parseInt(moneyText.getText());
		if (money - cost < 0) {
			noMoney.setVisible(true);
			_noticeText.setText("¾lÃB¤£¨¬");
			return false;
		} else {
			moneyText.setText((money - cost) + "");
			return true;
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		moneyText.setText(LoadController.finalMoney);

	}

	@Override
	public void handle(KeyEvent e) {
		if (e.getCode() == KeyCode.ESCAPE) {
			_option.setVisible(true);
		}
	}
	
	public void buttonClicked() {
		Media media = new Media(getClass().getResource("/sounds/button.wav").toString());
		MediaPlayer player = new MediaPlayer(media);
		player.play();
	}
}
