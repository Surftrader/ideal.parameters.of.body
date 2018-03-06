package org.poseal.new_ideal_body.intrfc.impl;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IdealBodyView extends Application {

	Label fioLabel;
	Label ageLabel;
	Label genderLabel;
	Label heighLabel;
	Label boneLabel;
	Label weightLabel;
	Label resultLabel;
	Label response;
	TextField fioTf;
	TextField ageTf;
	TextField heighTf;
	TextField weightTf;
	RadioButton manCB;
	RadioButton womanCB;
	RadioButton smallBoneLabel;
	RadioButton averageBoneLabel;
	RadioButton bigBoneLabel;
	Button counting;
	ToggleGroup tgGender;
	ToggleGroup tgBone;
	ScrollPane scrlPane;

	char programReduction;
	char programControl;

	Human human = new Human();
	FlowPane fp;
	GridPane gridPane;
	Scene resultScene;
	Scene gridScene;
	Scene myScene;

	Text reduction = new Text("План снижения веса");
	Text control = new Text("План контроля веса");

	Text nutritionPlan = new Text("	План питания\n");
	Text products = new Text("	Продукты\n");
	Text enjoy = new Text("  Наслаждайтесь\n");
	Text protein = new Text(" Примерное\n содержание\n протеина");
	Text callories = new Text(" Примерное\n содержание\n калорий");

	Text planReduction;
	Text planReductionProducts;
	Text planReductionEnjoy;
	Text planReductionProtein;
	Text planReductionCallories;

	Text planControl;
	Text planControlProducts;
	Text planControlEnjoy;
	Text planControlProtein;
	Text planControlCallories;

	Button btnRecommendation;
	Button btn;

	VBox rootNode;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(final Stage myStage) throws Exception {

		LocalDate dateNow = LocalDate.now();
		LocalDate dateEnd = LocalDate.of(2019, 9, 6);

		if (dateEnd.isBefore(dateNow)) {
			myStage.setTitle("Внимание!");
			VBox rootNode = new VBox(10);
			rootNode.setAlignment(Pos.CENTER);
			myScene = new Scene(rootNode, 300, 100);
			Label response = new Label("Упс! Ничто не вечно на земле!");
			response.setFont(new Font(15));
			Button btn = new Button("Выход");
			rootNode.getChildren().addAll(response, btn);

			btn.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					Platform.exit();
				}
			});			
			myStage.setScene(myScene);
			myStage.show();
		} else {
			myStage.setTitle("Ideal Body");
			rootNode = new VBox(10);
			rootNode.setAlignment(Pos.CENTER);
			myScene = new Scene(rootNode, 300, 550);
			myStage.setScene(myScene);

			fioLabel = new Label("ФИО:");
			ageLabel = new Label("Возраст:");
			genderLabel = new Label("Пол");
			heighLabel = new Label("Рост");
			boneLabel = new Label("Костная система");
			weightLabel = new Label("Вес");
			resultLabel = new Label("");

			fioTf = new TextField();
			ageTf = new TextField();
			heighTf = new TextField();
			weightTf = new TextField();

			fioTf.setPromptText("Поддубка Сергей Александрович");
			ageTf.setPromptText("От 18 до 90");
			heighTf.setPromptText("Муж - (157-193), Жен - (147-183)");
			weightTf.setPromptText("От 45 до 200");

			VBox.setMargin(fioTf, new Insets(10, 10, 10, 10));
			VBox.setMargin(ageTf, new Insets(10, 10, 10, 10));
			VBox.setMargin(heighTf, new Insets(10, 10, 10, 10));
			VBox.setMargin(weightTf, new Insets(10, 10, 10, 10));

			manCB = new RadioButton("М");
			womanCB = new RadioButton("Ж");

			tgGender = new ToggleGroup();
			manCB.setToggleGroup(tgGender);
			womanCB.setToggleGroup(tgGender);

			manCB.setSelected(true);
			human.setGender("М");

			womanCB.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent ae) {
					genderLabel.setText("Пол (женский)");
					human.setGender("Ж");
				}
			});
			manCB.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					genderLabel.setText("Пол (мужской)");
					human.setGender("М");
				}
			});

			smallBoneLabel = new RadioButton("М");
			averageBoneLabel = new RadioButton("С");
			bigBoneLabel = new RadioButton("К");

			smallBoneLabel.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					boneLabel.setText("Костная система (мелкая)");
					human.setBoneStructure("М");
				}
			});

			averageBoneLabel.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					boneLabel.setText("Костная система (средняя)");
					human.setBoneStructure("С");
				}
			});

			bigBoneLabel.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					boneLabel.setText("Костная система (крупная)");
					human.setBoneStructure("К");
				}
			});

			tgBone = new ToggleGroup();
			smallBoneLabel.setToggleGroup(tgBone);
			averageBoneLabel.setToggleGroup(tgBone);
			bigBoneLabel.setToggleGroup(tgBone);

			averageBoneLabel.setSelected(true);
			human.setBoneStructure("С");

			counting = new Button("Расчет");

			counting.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {

					human.setName(fioTf.getText());
					human.setAge(Integer.parseInt(ageTf.getText()));
					human.setHeight(Integer.parseInt(heighTf.getText()));
					human.setWeight(Double.parseDouble(weightTf.getText()));

					boolean[] array = new boolean[3];
					array[0] = readAge();
					array[1] = readHeight(human.getGender());
					array[2] = readWeight();

					if (!checking(array)) {
						myStage.setTitle("Внимание!");
						rootNode = new VBox(10);
						rootNode.setAlignment(Pos.CENTER);
						myScene = new Scene(rootNode, 300, 100);	
						response = new Label("Введите корректные данные");
						btn = new Button("Выход");
						myStage.setScene(myScene);
						rootNode.getChildren().addAll(response, btn);

						btn.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent ae) {
								Platform.exit();
							}
						});

						myStage.centerOnScreen();
						myStage.show();
					} else {
						programReduction = human.programReductionWeight();
						programControl = human.programControlWeight();

						String result = 
						        "ФИО: " + human.getName() + "\n"
						        + "Пол: " + human.getGender() + "\n"
								+ "Возраст: " + human.getAge() + " лет\n" 
						        + "Рост: " + human.getHeight() + " см\n"
								+ "Костная система: " + human.getBoneStructure() + "\n" 
						        + "Вес: " + human.getWeight() + " кг\n" 
								+ "Индекс массы тела: " + human.indexMassBody() + "\n"
								+ "---------------------------\n" 
								+ "Идеальные параметры:\n" 
								+ "Вес: " + human.idealWeight() + " кг\n" 
								+ "Жир: " + human.idealFat() + " %" + "\n"
								+ "Внутренний жир: " + human.idealInternalFat() + "\n" 
								+ "Костная масса: " + human.idealBoneMass() + " кг\n" 
								+ "Биологический возраст: не выше " + human.idealAge() + " лет\n" 
								+ "Мышечная масса: " + human.idealMuscle() + " кг\n" 
								+ "Вода в организме: " + human.idealWater() + "\n"
								+ "---------------------------\n" 
								+ "Нормы для снижения веса\n" 
								+ "Вода: " + human.waterReduction() + " мл\n" 
								+ "Белок: " + human.proteinReduction() + " гр\n"
								+ "Жир: " + human.fatReduction() + " гр\n" 
								+ "Углеводы: " + human.carbohydratesReduction() + " гр\n" 
								+ "Калории: " + human.kilocalorieReduction() + " гр\n"
								+ "---------------------------\n" 
								+ "Нормы для контроля веса\n" 
								+ "Вода: " + human.waterControl() + " мл\n" 
								+ "Белок: " + human.proteinControl() + " гр\n" 
								+ "Жир: " + human.fatControl() + " гр\n" 
								+ "Углеводы: " + human.carbohydratesControl() + " гр\n" 
								+ "Ккалории: " + human.kilocalorieControl() + " гр\n"
								+ "---------------------------\n" 
								+ "Программа для снижения веса: " + programReduction + "\n" 
								+ "Программа для контроля веса: " + programControl + "\n";

						resultLabel.setText(result);

						fp = new FlowPane(10, 10);
						fp.setAlignment(Pos.CENTER);
						resultScene = new Scene(fp, 300, 650);
						btnRecommendation = new Button("Рекомендации");
						btnRecommendation.setOnAction(new EventHandler<ActionEvent>() {

							public void handle(ActionEvent event) {
								programReduction = human.programReductionWeight();
								programControl = human.programControlWeight();

								switch(programReduction) {
								case 'A':
									planReduction = new Text("		A\n");
									planReductionProducts = new Text(
											" Формула 1 и Формула 2\n "
											+ "Продукты Herbalife для оптимизации\n "
											+ "контроля веса\n "
											+ "Здоровый перекус.\n "
											+ "Продукты Herbalife для целевого питания");
									planReductionEnjoy = new Text(
											" 2 коктейля\n "
											+ "1 здоровый перекус\n "
											+ "1 прием пищи\n");
									planReductionProtein = new Text(" < 75 граммов\n");
									planReductionCallories = new Text(" 1200 ккал\n");
									break;
								case 'B':
									planReduction = new Text("		B\n");
									planReductionProducts = new Text(
											" Формула 1, 2 и 3/Протеиновая смесь\n "
											+ "Продукты Herbalife для оптимизации\n "
											+ "контроля веса\n Здоровый перекус.\n "
											+ "Продукты Herbalife для целевого питания");
									planReductionEnjoy = new Text(
											" 2 коктейля\n "
											+ "Рекомендуемое количество\n "
											+ "Формулы 3/Протеиновой смеси\n "
											+ "1 здоровый перекус\n 1 прием пищи\n");
									planReductionProtein = new Text(" 75-100 граммов\n");
									planReductionCallories = new Text(" 1200-1300 ккал\n");
									break;
								case 'C':
									planReduction = new Text("		C\n");
									planReductionProducts = new Text(
											" Формула 1, 2 и 3/Протеиновая смесь\n "
											+ "Продукты Herbalife для оптимизации\n "
											+ "контроля веса\n "
											+ "Здоровый перекус.\n "
											+ "Продукты Herbalife для целевого питания");
									planReductionEnjoy = new Text(
											" 2 коктейля\n Рекомендуемое количество\n "
											+ "Формулы 3/Протеиновой смеси\n "
											+ "2 здоровых перекуса\n "
											+ "1 прием пищи\n");
									planReductionProtein = new Text(" 100-125 граммов\n");
									planReductionCallories = new Text(" 1300-1500 ккал\n");
									break;
								case 'D':
									planReduction = new Text("		D\n");
									planReductionProducts = new Text(
											" Формула 1, 2 и 3/Протеиновая смесь\n "
											+ "Продукты Herbalife для оптимизации\n "
											+ "контроля веса\n Здоровый перекус.\n "
											+ "Продукты Herbalife для целевого питания");
									planReductionEnjoy = new Text(
											" 2 коктейля\n "
											+ "Рекомендуемое количество\n "
											+ "Формулы 3/Протеиновой смеси\n "
											+ "3 здоровых перекуса\n "
											+ "1 прием пищи\n");
									planReductionProtein = new Text(" 125-150 граммов\n");
									planReductionCallories = new Text(" 1500-1700 ккал\n");
									break;
								case 'E':
									planReduction = new Text("		E\n");
									planReductionProducts = new Text(
											" Формула 1, 2 и 3/Протеиновая смесь\n "
											+ "Продукты Herbalife для оптимизации\n "
											+ "контроля веса\n Здоровый перекус.\n "
											+ "Продукты Herbalife для целевого питания");
									planReductionEnjoy = new Text(
											" 2 коктейля\n "
											+ "Рекомендуемое количество\n "
											+ "Формулы 3/Протеиновой смеси\n "
											+ "4 здоровых перекуса\n "
											+ "1 прием пищи\n");
									planReductionProtein = new Text(" < 150 граммов\n");
									planReductionCallories = new Text(" 1700-2000 ккал\n");
								}
								
								switch(programControl) {
								case 'F':
									planControl = new Text("		F\n");
									planControlProducts = new Text(
											" Формула 1 и Формула 2\n "
											+ "Продукты Herbalife для оптимизации\n "
											+ "контроля веса\n "
											+ "Продукты Herbalife для целевого питания\n");
									planControlEnjoy = new Text("1 коктейль\n"
									        + "2 приема пищи\n");
									planControlProtein = new Text(" < 75 граммов\n");
									planControlCallories = new Text(" 1300-1400 ккал\n");
									break;
								case 'G':
									planControl = new Text("		G\n");
									planControlProducts = new Text(
											" Формула 1, 2 и 3/Протеиновая смесь\n "
											+ "Продукты Herbalife для оптимизации\n "
											+ "контроля веса\n "
											+ "Здоровый перекус.\n "
											+ "Продукты Herbalife для целевого питания");
									planControlEnjoy = new Text(
											" 1 коктейль\n "
											+ "Рекомендуемое количество\n "
											+ "Формулы 3/Протеиновой смеси\n "
											+ "1 здоровый перекус\n "
											+ "2 приема пищи\n");
									planControlProtein = new Text(" 75-100 граммов\n");
									planControlCallories = new Text(" 1400-1600 ккал\n");
									break;
								case 'H':
									planControl = new Text("		H\n");
									planControlProducts = new Text(
											" Формула 1, 2 и 3/Протеиновая смесь\n "
											+ "Продукты Herbalife для оптимизации\n "
											+ "контроля веса\n Здоровый перекус.\n "
											+ "Продукты Herbalife для целевого питания");
									planControlEnjoy = new Text(
											" 1 коктейль\n "
											+ "Рекомендуемое количество\n "
											+ "Формулы 3/Протеиновой смеси\n "
											+ "2 здоровых перекуса\n 2 приема пищи\n");
									planControlProtein = new Text(" 100-125 граммов\n");
									planControlCallories = new Text(" 1600-1800 ккал\n");
									break;
								case 'I':
									planControl = new Text("		I\n");
									planControlProducts = new Text(
											" Формула 1, 2 и 3/Протеиновая смесь\n "
											+ "Продукты Herbalife для оптимизации\n "
											+ "контроля веса\n "
											+ "Здоровый перекус.\n "
											+ "Продукты Herbalife для целевого питания");
									planControlEnjoy = new Text(
											" 1 коктейль\n "
											+ "Рекомендуемое количество\n "
											+ "Формулы 3/Протеиновой смеси\n "
											+ "3 здоровых перекуса\n "
											+ "2 приема пищи\n");
									planControlProtein = new Text(" 125-150 граммов\n");
									planControlCallories = new Text(" 1800-2000 ккал\n");
									break;
								case 'J':
									planControl = new Text("		J\n");
									planControlProducts = new Text(
											" Формула 1, 2 и 3/Протеиновая смесь\n "
											+ "Продукты Herbalife для оптимизации\n "
											+ "контроля веса\n "
											+ "Здоровый перекус.\n "
											+ "Продукты Herbalife для целевого питания");
									planControlEnjoy = new Text(
											" 1 коктейль\n "
											+ "Рекомендуемое количество\n "
											+ "Формулы 3/Протеиновой смеси\n "
											+ "4 здоровых перекуса\n "
											+ "2 приема пищи\n");
									planControlProtein = new Text(" < 150 граммов\n");
									planControlCallories = new Text(" 2000-2200 ккал\n");
									break;
								}
								
								gridPane = new GridPane();
								gridPane.autosize();
								gridPane.setPadding(new Insets(10));

								gridPane.setVgap(10);
								gridPane.setHgap(10);

								gridPane.setAlignment(Pos.CENTER);

								reduction.setFont(new Font(15));
								control.setFont(new Font(15));

								gridPane.add(reduction, 0, 0);
								gridPane.add(nutritionPlan, 0, 1);
								gridPane.add(planReduction, 0, 2);
								gridPane.add(control, 0, 3);
								gridPane.add(planControl, 0, 4);
								gridPane.add(products, 1, 1);
								gridPane.add(planReductionProducts, 1, 2);
								gridPane.add(planControlProducts, 1, 4);
								gridPane.add(enjoy, 2, 1);
								gridPane.add(planReductionEnjoy, 2, 2);
								gridPane.add(planControlEnjoy, 2, 4);
								gridPane.add(protein, 3, 1);
								gridPane.add(planReductionProtein, 3, 2);
								gridPane.add(planControlProtein, 3, 4);
								gridPane.add(callories, 4, 1);
								gridPane.add(planReductionCallories, 4, 2);
								gridPane.add(planControlCallories, 4, 4);

								gridScene = new Scene(gridPane);
								myStage.setTitle("Рекомендации");
								myStage.setScene(gridScene);
								myStage.centerOnScreen();
								myStage.show();
							}
						});

						myStage.setScene(resultScene);
						fp.getChildren().addAll(resultLabel, btnRecommendation);
						myStage.centerOnScreen();
						myStage.show();
					}
				}
			});

			HBox genderHBox = new HBox(10);
			genderHBox.setAlignment(Pos.CENTER);
			genderHBox.getChildren().addAll(manCB, womanCB);

			HBox boneHBox = new HBox(10);
			boneHBox.setAlignment(Pos.CENTER);
			boneHBox.getChildren().addAll(smallBoneLabel, averageBoneLabel, bigBoneLabel);

			rootNode.getChildren().addAll(fioLabel, fioTf, genderLabel, genderHBox, ageLabel, ageTf, heighLabel,
					heighTf, boneLabel, boneHBox, weightLabel, weightTf, new Separator(), counting);
			myStage.centerOnScreen();
			myStage.show();
		}
	}

	public boolean readAge() {
		String input = ageTf.getText();
		try {
			int age = Integer.parseInt(input);
			if (age >= 18 && age <= 90) {
				human.setAge(Integer.parseInt(ageTf.getText()));
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			e.getMessage();
		}
		return true;
	}

	public boolean readHeight(String gender) {
		gender = human.getGender();
		String input = heighTf.getText();
		try {
			if (gender.equals("М")) {
				int heightMan = Integer.parseInt(input);
				if (heightMan >= 157 && heightMan <= 193) {
					human.setHeight(Integer.parseInt(heighTf.getText()));
				} else {
					return false;
				}
			}
			if (gender.equals("Ж")) {
				int heightWomen = Integer.parseInt(input);
				if (heightWomen >= 147 && heightWomen <= 183) {
					human.setHeight(Integer.parseInt(heighTf.getText()));
				} else {
					return false;
				}
			}
		} catch (NumberFormatException e) {
			e.getMessage();
		}
		return true;
	}

	public boolean readWeight() {
		String input = weightTf.getText();
		try {
			double weight = Double.parseDouble(input);
			if (weight >= 45 && weight <= 200) {
				human.setWeight(Double.parseDouble(weightTf.getText()));
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			e.getMessage();
		}
		return true;
	}

	public boolean checking(boolean[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == false)
				count++;
		}
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}
} 
