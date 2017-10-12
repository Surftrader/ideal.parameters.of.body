package org.poseal.new_ideal_body.intrfc;

public interface IdealParameters {
	
	int idealWeight(); // идеальный вес(кг)
	
	double idealFat(); // идеальный общий жир (%)
	
	String idealInternalFat(); // идеальный внутренний жир (относительная величина)
	
	double idealBoneMass(); // идеальная костная масса (кг)
	
	int idealMuscle(); // идеальная мышечная масса(кг)
	
	String idealWater(); // идеальный % воды в огранизме
	
	int idealAge(); // идеальный биологический возраст
}
