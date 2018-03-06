package org.poseal.new_ideal_body.intrfc.impl;

import org.poseal.new_ideal_body.intrfc.GenericParameters;

public class Human implements GenericParameters {

    private String name;
    private String gender;
    private int age;
    private int height;
    private double weight;
    private String bone;

    public Human(String name, String gender, int age, int height, double weight, String boneStructure) {

        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bone = boneStructure;
    }
    
    public Human() {
        
    }

    public int indexMassBody() {
        return (int) Math.round(10000 * weight / height / height);
    }

    public int[] realProteinData() {

        while (true) {
            try {
                int[] resultArray = new int[9];
                if (indexMassBody() < 19) {
                    for (int i = 0; i < resultArray.length; i++) {
                        resultArray[i] = PROTEIN_DATA[0][i];
                    }
                    return resultArray;
                }
                if (indexMassBody() > 45) {
                    for (int i = 0; i < resultArray.length; i++) {
                        resultArray[i] = PROTEIN_DATA[26][i];
                    }
                    return resultArray;
                }
                for (int i = 0; i < PROTEIN_DATA.length; i++) {
                    if (PROTEIN_DATA[i][0] == indexMassBody()) {
                        for (int j = 0; j < resultArray.length; j++) {
                            resultArray[j] = PROTEIN_DATA[i][j];
                        }
                        return resultArray;
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public int waterReduction() {
        return (int) (indexMassBody() >= 27 ? weight * 30 : weight * 40);
    }

    public int proteinReduction() {
        while (true) {
            try {
                if (gender.equals("Ж")) {
                    if (height > 146 && height < 154) return realProteinData()[1];                   
                    if (height > 153 && height < 164) return realProteinData()[2];
                    if (height > 163 && height < 174) return realProteinData()[3];
                    if (height > 173 && height < 184) return realProteinData()[4];                    
                } else if (gender.equals("М")) {
                    if (height > 153 && height < 164) return realProteinData()[5];                   
                    if (height > 163 && height < 174) return realProteinData()[6];                   
                    if (height > 173 && height < 184) return realProteinData()[7];                   
                    if (height > 183 && height < 194) return realProteinData()[8];                    
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public int fatReduction() {
        while (true) {
            try {
                double idealW = idealWeight();
                int result = (int) (idealW - (idealW * 0.25));
                if (result > 34 && result < 51) return result;
                if (result > 50) return 50;
                if (result < 35) return 35;
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public int carbohydratesReduction() {
        double kilocalorie = kilocalorieReduction();
        double fat = fatReduction();
        double protein = proteinReduction();

        return (int) ((kilocalorie - (9 * fat) - (4 * protein)) / 4);
    }

    public int kilocalorieReduction() {
        while (true) {
            try {
                int result = (int) (proteinReduction() * 13.8);
                if (gender.equals("Ж")) {
                    return result < 1200 ? result : 1200;
                }
                if (gender.equals("М")) {
                    return result > 1500 ? 1500 : result;
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public char programControlWeight() {
        while (true) {
            try {
                int proteinFactor = proteinReduction();

                if (proteinFactor > 50 && proteinFactor < 76) return 'F';
                if (proteinFactor > 75 && proteinFactor < 101) return 'G';
                if (proteinFactor > 100 && proteinFactor < 126) return 'H';
                if (proteinFactor > 125 && proteinFactor < 151) return 'I';
                if (proteinFactor > 150) return 'J';
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public int waterControl() {
        return (int) (indexMassBody() >= 27 ? idealWeight() * 30 : idealWeight() * 40);
    }

    public int proteinControl() {
        return proteinReduction();
    }

    public int fatControl() {
        return (int) idealWeight();
    }

    public int carbohydratesControl() {
        double kilocalorie = kilocalorieControl();
        double fat = fatControl();
        double protein = proteinControl();

        return (int) ((kilocalorie - (9 * fat) - (4 * protein)) / 4);
    }

    public int kilocalorieControl() {
        return (int) (proteinReduction() * 13.8);
    }

    public char programReductionWeight() {
        while (true) {
            try {
                int proteinFactor = proteinReduction();

                if (proteinFactor > 50 && proteinFactor < 76) return 'A';
                if (proteinFactor > 100 && proteinFactor < 126) return 'C';
                if (proteinFactor > 125 && proteinFactor < 151) return 'D';
                if (proteinFactor > 150) return 'E';
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public int idealWeight() {
        while (true) {
            try {
                if (gender.equals("Ж") && height > 146 && height < 184) {
                    if (bone.equals("К")) return WEIGHT_WOMAN_DATA[0][height - 147];
                    if (bone.equals("С")) return WEIGHT_WOMAN_DATA[1][height - 147];
                    if (bone.equals("М")) return WEIGHT_WOMAN_DATA[2][height - 147];
                }
                if (gender.equals("М") && height > 156 && height < 194) {
                    if (bone.equals("К")) return WEIGHT_MAN_DATA[0][height - 157];
                    if (bone.equals("С")) return WEIGHT_MAN_DATA[1][height - 157];
                    if (bone.equals("М")) return WEIGHT_MAN_DATA[2][height - 157];
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
 
    public double idealFat() {
        while (true) {
            try {
                if (gender.equals("Ж")) {
                    if (age > 17 && age < 25) return FAT_WOMAN_DATA[0];
                    if (age > 24 && age < 30) return FAT_WOMAN_DATA[1];
                    if (age > 29 && age < 35) return FAT_WOMAN_DATA[2];
                    if (age > 34 && age < 40) return FAT_WOMAN_DATA[3];
                    if (age > 39 && age < 45) return FAT_WOMAN_DATA[4];
                    if (age > 44 && age < 50) return FAT_WOMAN_DATA[5];
                    if (age > 49 && age < 55) return FAT_WOMAN_DATA[6];
                    if (age > 54 && age < 60) return FAT_WOMAN_DATA[7];
                    if (age > 59) return FAT_WOMAN_DATA[8];
                }
                if (gender.equals("М")) {
                    if (age > 17 && age < 25) return FAT_MAN_DATA[0];
                    if (age > 24 && age < 30) return FAT_MAN_DATA[1];
                    if (age > 29 && age < 35) return FAT_MAN_DATA[2];
                    if (age > 34 && age < 40) return FAT_MAN_DATA[3];
                    if (age > 39 && age < 45) return FAT_MAN_DATA[4];
                    if (age > 44 && age < 50) return FAT_MAN_DATA[5];
                    if (age > 49 && age < 55) return FAT_MAN_DATA[6];
                    if (age > 54 && age < 60) return FAT_MAN_DATA[7];
                    if (age > 59) return FAT_MAN_DATA[8];
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public String idealInternalFat() {
        String res = "";
        if (age < 35) res = "(1 - 2) ед.";
        if (age > 34 && age < 50) res = "(2 - 4) ед.";
        if (age > 49) res = "(4 - 6) ед.";
        
        return res;
    }

    public double idealBoneMass() {
        while (true) {
            try {
                double idealW = idealWeight();
                if (gender.equals("Ж")) {
                    if (idealW < 51) return 1.95;
                    if (idealW > 50 && idealW < 76) return 2.4;
                    if (idealW > 75 && idealW < 91) return 3.1;
                    if (idealW > 90) return 3.3;
                }
                if (gender.equals("М")) {
                    if (idealW < 66) return 2.66;
                    if (idealW > 65 && idealW < 96) return 3.29;
                    if (idealW > 95 && idealW < 111) return 4.0;
                    if (idealW > 110) return 4.3;
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public int idealMuscle() {
        double idealW = idealWeight();
        double idealF = idealFat();
        return (int) (idealW - (idealW * idealF) / 100);
    }

    public String idealWater() {
        String res = "";
        if (gender.equals("Ж")) {
            res = "50-60 %";
        }
        if (gender.equals("М")) {
            res = "60-70 %";
        }
        return res;
    }

    public int idealAge() {
        return (age >= 30 ? (age - 12) : 18);
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
        return bone;
    }

    public void setBoneStructure(String boneStructure) {
        this.bone = boneStructure;
    }
}
