package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ResourceBundle;

import Slimes.SlimePedia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class LoadController implements Initializable {
	
	public static Scene mainScene;
	
	public static String finalMoney; 
	public static String finalName;

	public static String name1;
	public static String name2;
	public static String name3;

	public static String money1;
	public static String money2;
	public static String money3;

	public String slime1;
	public String slime2;
	public String slime3;

	boolean fileEmpty1 = false, fileEmpty2 = false, fileEmpty3 = false;

	public static int choose = 0;

	@FXML
	Pane _pane1;
	@FXML
	Pane _pane2;
	@FXML
	Pane _pane3;
	@FXML
	Pane _newRolePane;

	@FXML	
	Button _confirm;
	@FXML
	Button _delete;
	@FXML
	Button _newFile;

	@FXML
	Label _nullNotice1;
	@FXML
	Label _nullNotice2;
	@FXML
	Label _nullNotice3;

	@FXML
	Label _moneyText1;
	@FXML
	Label _moneyText2;
	@FXML
	Label _moneyText3;

	@FXML
	Label _slimeText1;
	@FXML
	Label _slimeText2;
	@FXML
	Label _slimeText3;

	@FXML
	Label _name1;
	@FXML
	Label _name2;
	@FXML
	Label _name3;

	@FXML
	Label _money1;
	@FXML
	Label _money2;
	@FXML
	Label _money3;

	@FXML
	Label _slime1;
	@FXML
	Label _slime2;
	@FXML
	Label _slime3;
	
	@FXML
	Label _unableNotice;
	
	@FXML
	TextField _input;
	
	// load all the records
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		readFile(1);
		readFile(2);
		readFile(3);
	}

	// let the pane be selected and the button appear
	@FXML
	public void pane1Clicked() {
		int newSelected = 0;
		if (choose == 0) {
			_pane1.setStyle("-fx-background-color:AntiqueWhite; -fx-border-color:OliveDrab; -fx-border-width:5;"
					+ "-fx-border-radius:10; -fx-background-radius:13");
			newSelected = 1;
		} else if (choose == 2) {
			_pane2.setStyle("-fx-background-color:transparent; -fx-border-color:SteelBlue; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			_pane1.setStyle("-fx-background-color:AntiqueWhite; -fx-border-color:OliveDrab; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			newSelected = 1;
		} else if (choose == 3) {
			_pane3.setStyle("-fx-background-color:transparent; -fx-border-color:DimGray; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			_pane1.setStyle("-fx-background-color:AntiqueWhite; -fx-border-color:OliveDrab; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			newSelected = 1;
		} else if (choose == 1) {
			_pane1.setStyle("-fx-background-color:transparent; -fx-border-color:OliveDrab; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			newSelected = 0;
		} else {
			System.out.println("backgroundColorFalse");
		}

		if (choose == 1) {
			_newFile.setVisible(false);
			buttonAppear(false);
		} else {
			if (fileEmpty1) {
				_newFile.setVisible(true);
				buttonAppear(false);
			} else {
				_newFile.setVisible(false);
				buttonAppear(true);
			}
		}

		choose = newSelected;

	}

	// let the pane be selected and the button appear
	@FXML
	public void pane2Clicked() {
		int newSelected = 0;
		if (choose == 0) {
			_pane2.setStyle("-fx-background-color:AntiqueWhite; -fx-border-color:SteelBlue; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			newSelected = 2;
		} else if (choose == 2) {
			_pane2.setStyle("-fx-background-color:transparent; -fx-border-color:SteelBlue; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			newSelected = 0;
		} else if (choose == 3) {
			_pane3.setStyle("-fx-background-color:transparent; -fx-border-color:DimGray; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			_pane2.setStyle("-fx-background-color:AntiqueWhite; -fx-border-color:SteelBlue; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			newSelected = 2;
		} else if (choose == 1) {
			_pane1.setStyle("-fx-background-color:transparent; -fx-border-color:OliveDrab; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			_pane2.setStyle("-fx-background-color:AntiqueWhite; -fx-border-color:SteelBlue; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			newSelected = 2;
		} else {
			System.out.println("backgroundColorFalse");
		}

		if (choose == 2) {
			_newFile.setVisible(false);
			buttonAppear(false);
		} else {
			if (fileEmpty2) {
				_newFile.setVisible(true);
				buttonAppear(false);
			} else {
				_newFile.setVisible(false);
				buttonAppear(true);
			}
		}

		choose = newSelected;

	}

	// let the pane be selected and the button appear
	@FXML
	public void pane3Clicked() {
		int newSelected = 0;
		if (choose == 0) {
			_pane3.setStyle("-fx-background-color:AntiqueWhite; -fx-border-color:DimGray; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			newSelected = 3;
		} else if (choose == 3) {
			_pane3.setStyle("-fx-background-color:transparent; -fx-border-color:DimGray; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			newSelected = 0;
		} else if (choose == 2) {
			_pane2.setStyle("-fx-background-color:transparent; -fx-border-color:SteelBlue; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			_pane3.setStyle("-fx-background-color:AntiqueWhite; -fx-border-color:DimGray; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			newSelected = 3;
		} else if (choose == 1) {
			_pane1.setStyle("-fx-background-color:transparent; -fx-border-color:OliveDrab; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			_pane3.setStyle("-fx-background-color:AntiqueWhite; -fx-border-color:DimGray; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
			newSelected = 3;
		} else {
			System.out.println("backgroundColorFalse");
		}

		if (choose == 3) {
			_newFile.setVisible(false);
			buttonAppear(false);
		} else {
			if (fileEmpty3) {
				_newFile.setVisible(true);
				buttonAppear(false);
			} else {
				_newFile.setVisible(false);
				buttonAppear(true);
			}
		}

		choose = newSelected;
	}

	// enter game
	@FXML
	public void btConfirmPressed() throws IOException{
		if(choose == 1) {
			loadSlimeRecord(slime1);
			finalMoney = money1;
			finalName = name1;
		}else if(choose == 2) {
			loadSlimeRecord(slime2);
			finalMoney = money2;
			finalName = name2;
		}else if(choose == 3) {
			loadSlimeRecord(slime3);
			finalMoney = money3;
			finalName = name3;
		}
		buttonClicked();
		Parent mainRoot = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
		mainScene = new Scene(mainRoot);
		mainScene.getRoot().requestFocus();
		Final_108502003.currentStage.setScene(mainScene);
	}

	// create new file, reset the record and hide all the button
	@FXML
	public void btDeletedPressed() {
		BufferedWriter fw = null;
		try {
			File file = new File("record" + choose + ".txt");
			fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
			fw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		readFile(choose);
		buttonAppear(false);
		_newFile.setVisible(false);

		if (choose == 1) {
			_pane1.setStyle("-fx-background-color:transparent; -fx-border-color:OliveDrab; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
		} else if (choose == 2) {
			_pane2.setStyle("-fx-background-color:transparent; -fx-border-color:SteelBlue; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
		} else if (choose == 3) {
			_pane3.setStyle("-fx-background-color:transparent; -fx-border-color:DimGray; -fx-border-width:5;"
					+ " -fx-border-radius:10; -fx-background-radius:13");
		}
		choose = 0;
		buttonClicked();
	}
	
	// start create new file
	@FXML
	public void btCreateNewFilePressed() {
		_newRolePane.setVisible(true);
		buttonAppear(false);
		_newFile.setVisible(false);
		_pane1.setDisable(true);
		_pane2.setDisable(true);
		_pane3.setDisable(true);
		buttonClicked();
	}
	
	
	// confirm the new name
	@FXML
	public void btSummitPressed() {
	
		String tmp = _input.getText();
		
		if (tmp.length() > 7||tmp.length()<1) {
			_input.clear();
			_unableNotice.setVisible(true);
		} else {
			BufferedWriter fw = null;
			try {
				File file = new File("record"+choose+".txt");
				fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
				fw.write(_input.getText());
				fw.newLine();
				fw.write("200");
				fw.newLine();
				fw.write("0000000000000000");
				fw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fw != null) {
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			_input.clear();
			readFile(choose);
			_newRolePane.setVisible(false);
			if (choose == 1) {
				_pane1.setStyle("-fx-background-color:transparent; -fx-border-color:OliveDrab; -fx-border-width:5;"
						+ " -fx-border-radius:10; -fx-background-radius:13");
			} else if (choose == 2) {
				_pane2.setStyle("-fx-background-color:transparent; -fx-border-color:SteelBlue; -fx-border-width:5;"
						+ " -fx-border-radius:10; -fx-background-radius:13");
			} else if (choose == 3) {
				_pane3.setStyle("-fx-background-color:transparent; -fx-border-color:DimGray; -fx-border-width:5;"
						+ " -fx-border-radius:10; -fx-background-radius:13");
			}
			
			_pane1.setDisable(false);
			_pane2.setDisable(false);
			_pane3.setDisable(false);
			choose = 0;
		}
		buttonClicked();
	}
	
	// back to menu
	@FXML
	public void btBackPressed() {
		Final_108502003.currentStage.setScene(Final_108502003.menuScene);
		buttonClicked();
	}

	// read record, set labels and decide whether to show the label
	public void readFile(int number) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("record" + number + ".txt"), "UTF-8"));
			String str = null;
			if ((str = reader.readLine()) != null) {
				if (number == 1) {
					
					_nullNotice1.setVisible(false);
					fileEmpty1 = false;

					// input name 1
					name1 = str;
					_name1.setText(name1);
					_name1.setVisible(true);

					// input money 1
					money1 = reader.readLine();
					_money1.setText(money1);
					_moneyText1.setVisible(true);
					_money1.setVisible(true);

					// input slime record 1
					slime1 = reader.readLine();
					_slime1.setText(readSlimeRecord(slime1) + "/16");
					_slimeText1.setVisible(true);
					_slime1.setVisible(true);

				} else if (number == 2) {
					
					_nullNotice2.setVisible(false);
					fileEmpty2 = false;

					// input name 2
					name2 = str;
					_name2.setText(name2);
					_name2.setVisible(true);

					// input money 2
					money2 = reader.readLine();
					_money2.setText(money2);
					_moneyText2.setVisible(true);
					_money2.setVisible(true);

					// input slime record 2
					slime2 = reader.readLine();
					_slime2.setText(readSlimeRecord(slime2) + "/16");
					_slimeText2.setVisible(true);
					_slime2.setVisible(true);

				} else {
					
					_nullNotice3.setVisible(false);
					fileEmpty3 = false;

					// input name 3
					name3 = str;
					_name3.setText(name3);
					_name3.setVisible(true);

					// input money 3
					money3 = reader.readLine();
					_money3.setText(money3);
					_moneyText3.setVisible(true);
					_money3.setVisible(true);

					// input slime record 3
					slime3 = reader.readLine();
					_slime3.setText(readSlimeRecord(slime3) + "/16");
					_slimeText3.setVisible(true);
					_slime3.setVisible(true);

				}
			} else {
				if (number == 1) {

					// reset all the notice label
					_nullNotice1.setVisible(true);
					_name1.setVisible(false);
					_moneyText1.setVisible(false);
					_money1.setVisible(false);
					_slimeText1.setVisible(false);
					_slime1.setVisible(false);

					fileEmpty1 = true;

				} else if (number == 2) {

					// reset all the notice label
					_nullNotice2.setVisible(true);
					_name2.setVisible(false);
					_moneyText2.setVisible(false);
					_money2.setVisible(false);
					_slimeText2.setVisible(false);
					_slime2.setVisible(false);

					fileEmpty2 = true;

				} else {

					// reset all the notice label
					_nullNotice3.setVisible(true);
					_name3.setVisible(false);
					_moneyText3.setVisible(false);
					_money3.setVisible(false);
					_slimeText3.setVisible(false);
					_slime3.setVisible(false);

					fileEmpty3 = true;

				}
			}
		} catch (Exception e) {
			BufferedWriter fw = null;
			try {
				File file = new File("record"+number+".txt");
				fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
				fw.flush();
				if (number == 1) {

					// reset all the notice label
					_nullNotice1.setVisible(true);
					_name1.setVisible(false);
					_moneyText1.setVisible(false);
					_money1.setVisible(false);
					_slimeText1.setVisible(false);
					_slime1.setVisible(false);

					fileEmpty1 = true;

				} else if (number == 2) {

					// reset all the notice label
					_nullNotice2.setVisible(true);
					_name2.setVisible(false);
					_moneyText2.setVisible(false);
					_money2.setVisible(false);
					_slimeText2.setVisible(false);
					_slime2.setVisible(false);

					fileEmpty2 = true;

				} else {

					// reset all the notice label
					_nullNotice3.setVisible(true);
					_name3.setVisible(false);
					_moneyText3.setVisible(false);
					_money3.setVisible(false);
					_slimeText3.setVisible(false);
					_slime3.setVisible(false);

					fileEmpty3 = true;

				}
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
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// let button confirm and delete appear
	public void buttonAppear(boolean appear) {
		if (appear) {
			_confirm.setVisible(true);
			_delete.setVisible(true);
		} else {
			_confirm.setVisible(false);
			_delete.setVisible(false);
		}
	}

	// count how many slime you have
	public int readSlimeRecord(String record) {
		int have = 0;
		for (int i = 0; i < 16; i++) {
			if (record.charAt(i) == '1') {
				have++;
			}
		}
		return have;
	}

	// load slime record
	public void loadSlimeRecord(String record) {
		for (int i = 0; i < 16; i++) {
			if (record.charAt(i) == '1') {
				SlimePedia.setIndex(i, true);
			} else {
				SlimePedia.setIndex(i, false);
			}
		}
	}
	
	public void buttonClicked() {
		Media media = new Media(getClass().getResource("/sounds/button.wav").toString());
		MediaPlayer player = new MediaPlayer(media);
		player.play();
	}

}
