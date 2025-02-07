package model.services;

import model.entities.Country;

public class Messages {

	public static String textRed(String message) {
		return "\033[31m" + message + "\033[0m";
	}
	
	public static String textGreen(String message) {
		return "\033[32m" + message + "\033[0m";
	}
	
	public static String textOrange(String message) {
		return "\033[38;5;214m" + message + "\033[0m";
	}
	
	public static String textYellow(String message) {
		return "\033[33m" + message + "\033[0m";
	}
	
	public static String textBlue(String message) {
		return "\033[36m" + message + "\033[0m";
	}
	
	public static String modelCompare(Country guess, Country answer) {
		return textBlue("||| \n"
				+ "||| ") + CountryService.compareName(guess, answer) + textBlue("\n"
				+ "||| ") + CountryService.compareContinent(guess, answer) + textBlue("\n"
				+ "||| ") + CountryService.comparePopulation(guess, answer) + textBlue("\n"
				+ "||| ") + CountryService.comparePib(guess, answer) + textBlue("\n"
				+ "||| ") + CountryService.compareCapitalLetter(guess, answer) + textBlue("\n"
				+ "||| ") + CountryService.compareCoordinate(guess, answer) + textBlue("\n"
				+ "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
	}
}
