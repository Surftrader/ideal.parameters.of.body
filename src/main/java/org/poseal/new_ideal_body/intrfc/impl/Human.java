package org.poseal.new_ideal_body.intrfc.impl;

import org.poseal.new_ideal_body.intrfc.GenericParameters;

public class Human implements GenericParameters {

	private String name;
	private String gender;
	private int age;
	private int height;
	private double weight;
	private String boneStructure;

	public Human(String name, String gender, int age, int height, double weight, String boneStructure) {

		this.name = name;
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.boneStructure = boneStructure;
	}
	
	public Human() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getBoneStructure() {
		return boneStructure;
	}

	public void setBoneStructure(String boneStructure) {
		this.boneStructure = boneStructure;
	}

	public int indexMassBody() {
		return (int) Math.round(10000 * weight / height / height);
	}

	public int[] workingArrayOfTheProteinFactor() {

		while (true) {
			try {
				int[] resultArray = new int[9];
				if (indexMassBody() < 19) {
					for (int i = 0; i < resultArray.length; i++) {
						resultArray[i] = dataOfTheProteinFactor[0][i];
					}
					return resultArray;
				}
				if (indexMassBody() > 45) {
					for (int i = 0; i < resultArray.length; i++) {
						resultArray[i] = dataOfTheProteinFactor[26][i];
					}
					return resultArray;
				}

				for (int i = 0; i < dataOfTheProteinFactor.length; i++) {
					if (dataOfTheProteinFactor[i][0] == indexMassBody()) {
						for (int j = 0; j < resultArray.length; j++) {
							resultArray[j] = dataOfTheProteinFactor[i][j];
						}
						return resultArray;
					}
				}
			} catch (Exception e) {
				//
			}
		}
	}

	public int standardOfTheWaterForReductionInTheWeight() {
		return (int) (indexMassBody() >= 27 ? weight * 30 : weight * 40);
	}

	public int standardOfTheProteinForReductionInTheWeight() {

		while (true) {
			try {
				if (gender.equals("Ж")) {
					if (height > 146 && height < 154) {
						return workingArrayOfTheProteinFactor()[1];
					}
					if (height > 153 && height < 164) {
						return workingArrayOfTheProteinFactor()[2];
					}
					if (height > 163 && height < 174) {
						return workingArrayOfTheProteinFactor()[3];
					}
					if (height > 173 && height < 184) {
						return workingArrayOfTheProteinFactor()[4];
					}
				} else if (gender.equals("М")) {
					if (height > 153 && height < 164) {
						return workingArrayOfTheProteinFactor()[5];
					}
					if (height > 163 && height < 174) {
						return workingArrayOfTheProteinFactor()[6];
					}
					if (height > 173 && height < 184) {
						return workingArrayOfTheProteinFactor()[7];
					}
					if (height > 183 && height < 194) {
						return workingArrayOfTheProteinFactor()[8];
					}
				}
			} catch (Exception e) {
				//
			}
		}
	}

	public int standardOfTheFatForReductionInTheWeight() {
		while (true) {
			try {
				double idealW = idealWeight();

				int result = (int) (idealW - (idealW * 0.25));

				if (result > 34 && result < 51) {
					return result;
				}
				if (result > 50) {
					return 50;
				}
				if (result < 35) {
					return 35;
				}
			} catch (Exception e) {
				//
			}
		}
	}

	public int standardOfTheCarbohydratesForReductionInTheWeight() {

		double kilocalorie = standardOfTheKilocalorieForReductionInTheWeight();
		double fat = standardOfTheFatForReductionInTheWeight();
		double protein = standardOfTheProteinForReductionInTheWeight();

		return (int) ((kilocalorie - (9 * fat) - (4 * protein)) / 4);
	}

	public int standardOfTheKilocalorieForReductionInTheWeight() {
		while (true) {
			try {
				int result = (int) (standardOfTheProteinForReductionInTheWeight() * 13.8);
				if (gender.equals("Ж")) {
					return result < 1200 ? result : 1200;
				}
				if (gender.equals("М")) {
					return result > 1500 ? 1500 : result;
				}
			} catch (Exception e) {
				//
			}
		}
	}

	public char programOfTheControlOfTheWeight() {
		while (true) {
			try {
				int proteinFactor = standardOfTheProteinForReductionInTheWeight();

				if (proteinFactor > 50 && proteinFactor < 76) {
					return 'F';
				}
				if (proteinFactor > 75 && proteinFactor < 101) {
					return 'G';
				}
				if (proteinFactor > 100 && proteinFactor < 126) {
					return 'H';
				}
				if (proteinFactor > 125 && proteinFactor < 151) {
					return 'I';
				}
				if (proteinFactor > 150) {
					return 'J';
				}
			} catch (Exception e) {
				//
			}
		}
	}

	public int standardOfTheWaterForTheControlOfTheWeight() {
		return (int) (indexMassBody() >= 27 ? idealWeight() * 30 : idealWeight() * 40);
	}

	public int standardOfTheProteinForTheControlOfTheWeight() {
		return standardOfTheProteinForReductionInTheWeight();
	}

	public int standardOfTheFatForTheControlOfTheWeight() {
		return (int) idealWeight();
	}

	public int standardOfTheCarbohydratesForTheControlOfTheWeight() {

		double kilocalorie = standardOfTheKilocalorieForTheControlOfTheWeight();
		double fat = standardOfTheFatForTheControlOfTheWeight();
		double protein = standardOfTheProteinForTheControlOfTheWeight();

		return (int) ((kilocalorie - (9 * fat) - (4 * protein)) / 4);
	}

	public int standardOfTheKilocalorieForTheControlOfTheWeight() {
		return (int) (standardOfTheProteinForReductionInTheWeight() * 13.8);
	}

	public char programOfTheReductionOfTheWeight() {
		while (true) {
			try {
				int proteinFactor = standardOfTheProteinForReductionInTheWeight();

				if (proteinFactor > 50 && proteinFactor < 76) {
					return 'A';
				}
				if (proteinFactor > 75 && proteinFactor < 101) {
					return 'B';
				}
				if (proteinFactor > 100 && proteinFactor < 126) {
					return 'C';
				}
				if (proteinFactor > 125 && proteinFactor < 151) {
					return 'D';
				}
				if (proteinFactor > 150) {
					return 'E';
				}
			} catch (Exception e) {
				//
			}
		}
	}

	public int idealWeight() {
		while (true) {
			try {
				if (gender.equals("Ж") && height > 146 && height < 184) {
					if (boneStructure.equals("К")) {
						return dataOfTheOptimalWeightForWoman[0][height - 147];
					}
					if (boneStructure.equals("С")) {
						return dataOfTheOptimalWeightForWoman[1][height - 147];
					}
					if (boneStructure.equals("М")) {
						return dataOfTheOptimalWeightForWoman[2][height - 147];
					}
				}
				if (gender.equals("М") && height > 156 && height < 194) {
					if (boneStructure.equals("К")) {
						return dataOfTheOptimalWeightForMan[0][height - 157];
					}
					if (boneStructure.equals("С")) {
						return dataOfTheOptimalWeightForMan[1][height - 157];
					}
					if (boneStructure.equals("М")) {
						return dataOfTheOptimalWeightForMan[2][height - 157];
					}
				}
			} catch (Exception e) {
				//
			}
		}
	}

	public double idealFat() {
		while (true) {
			try {
				if (gender.equals("Ж")) {
					if (age > 17 && age < 25) {
						return dataOfTheOptimalFatForWoman[0];
					}
					if (age > 24 && age < 30) {
						return dataOfTheOptimalFatForWoman[1];
					}
					if (age > 29 && age < 35) {
						return dataOfTheOptimalFatForWoman[2];
					}
					if (age > 34 && age < 40) {
						return dataOfTheOptimalFatForWoman[3];
					}
					if (age > 39 && age < 45) {
						return dataOfTheOptimalFatForWoman[4];
					}
					if (age > 44 && age < 50) {
						return dataOfTheOptimalFatForWoman[5];
					}
					if (age > 49 && age < 55) {
						return dataOfTheOptimalFatForWoman[6];
					}
					if (age > 54 && age < 60) {
						return dataOfTheOptimalFatForWoman[7];
					}
					if (age > 59) {
						return dataOfTheOptimalFatForWoman[8];
					}
				}

				if (gender.equals("М")) {
					if (age > 17 && age < 25) {
						return dataOfTheOptimalFatForMan[0];
					}
					if (age > 24 && age < 30) {
						return dataOfTheOptimalFatForMan[1];
					}
					if (age > 29 && age < 35) {
						return dataOfTheOptimalFatForMan[2];
					}
					if (age > 34 && age < 40) {
						return dataOfTheOptimalFatForMan[3];
					}
					if (age > 39 && age < 45) {
						return dataOfTheOptimalFatForMan[4];
					}
					if (age > 44 && age < 50) {
						return dataOfTheOptimalFatForMan[5];
					}
					if (age > 49 && age < 55) {
						return dataOfTheOptimalFatForMan[6];
					}
					if (age > 54 && age < 60) {
						return dataOfTheOptimalFatForMan[7];
					}
					if (age > 59) {
						return dataOfTheOptimalFatForMan[8];
					}
				}
			} catch (Exception e) {
				//
			}
		}
	}

	public String idealInternalFat() {
		String res = "";
		if (age < 35) {
			res = "(1 - 2) ед.";
		}
		if (age > 34 && age < 50) {
			res = "(2 - 4) ед.";
		}
		if (age > 49) {
			res = "(4 - 6) ед.";
		}
		return res;
	}

	public double idealBoneMass() {
		while (true) {
			try {
				double idealW = idealWeight();
				if (gender.equals("Ж")) {
					if (idealW < 51) {
						return 1.95;
					}
					if (idealW > 50 && idealW < 76) {
						return 2.4;
					}
					if (idealW > 75 && idealW < 91) {
						return 3.1;
					}
					if (idealW > 90) {
						return 3.3;
					}
				}
				if (gender.equals("М")) {
					if (idealW < 66) {
						return 2.66;
					}
					if (idealW > 65 && idealW < 96) {
						return 3.29;
					}
					if (idealW > 95 && idealW < 111) {
						return 4.0;
					}
					if (idealW > 110) {
						return 4.3;
					}
				}
			} catch (Exception e) {
				//
			}
		}
	}

	public int idealMuscle() {
		double idealW = idealWeight();
		double idealF = idealFat();
		return (int) (idealW - (idealW * idealF) / 100);
	}

	public String idealLiquidWaterContent() {
		String res = "";
		if (gender.equals("Ж")) {
			res = "50-60 %";
		}
		if (gender.equals("М")) {
			res = "60-70 %";
		}
		return res;
	}

	public int idealBiologicalAge() {
		return (age >= 30 ? (age - 12) : 18);
	}
}
