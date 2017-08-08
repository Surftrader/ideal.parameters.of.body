package org.poseal.new_ideal_body.intrfc;

public interface IdealParametersOfTheBody {
	
	int idealWeight(); // идеальный вес(кг)
	
	double idealFat(); // идеальный общий жир (%)
	
	String idealInternalFat(); // идеальный внутренний жир (относительная величина)
	
	double idealBoneMass(); // идеальная костная масса (кг)
	
	int idealMuscle(); // идеальная мышечная масса(кг)
	
	String idealLiquidWaterContent(); // идеальный % воды в огранизме
	
	int idealBiologicalAge(); // идеальный биологический возраст
}
