package org.poseal.new_ideal_body.intrfc;

public interface MacrocellsReductionWeight {
	
	int waterReduction();// норма воды для снижения веса	 
	
	int proteinReduction(); // норма белка для снижения веса

	int fatReduction();	// норма жира для снижения веса

	int carbohydratesReduction();	// норма углеводов для снижения веса

	int kilocalorieReduction();	// норма килокалорий для снижения веса
	
	char programReductionWeight(); //программа снижения веса
}
