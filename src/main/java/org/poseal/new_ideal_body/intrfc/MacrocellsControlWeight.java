package org.poseal.new_ideal_body.intrfc;

public interface MacrocellsControlWeight {
	
	int waterControl(); 	// норма воды для контроля веса
	
	int proteinControl(); // норма белка для контроля веса
	
	int fatControl(); // норма жира для контроля веса
	
	int carbohydratesControl();  // норма углеводов для контроля веса
	
	int kilocalorieControl(); // норма килокалорий для контроля веса

	char programControlWeight(); //программа контроля веса
}
