package model.services;

import java.util.HashSet;
import java.util.Set;

import model.entities.Country;
import model.enums.Color;

public class CountryService {
	
	public static String compareName(Country guess, Country answer) {
		return guess.getName().equals(answer.getName()) 
				? Messages.textGreen(guess.getName() + " is correct guess!") 
		        : Messages.textRed(guess.getName() + " is incorrect guess.");
	}
	
	public static String comparePib(Country guess, Country answer){
		return switch (Double.compare(guess.getPib(), answer.getPib())) {
		        case 1  -> Messages.textRed("$" + guess.getPib() + "B - PIB is lower!");
		        case -1 -> Messages.textRed("$" + guess.getPib() + "B - PIB is higher!");
		        default -> Messages.textGreen("$" + guess.getPib() + "B - PIB is correct!");
		};
	}
	
	public static String comparePopulation(Country guess, Country answer){
		return switch (Double.compare(guess.getPopulation(), answer.getPopulation())) {
	        	case 1  -> Messages.textRed(guess.getPopulation() + "M - population is lower!");
		        case -1 -> Messages.textRed(guess.getPopulation() + "M - population is higher!");
		        default -> Messages.textGreen(guess.getPopulation() + "M - population is correct!");
		};
	}
	
	public static String compareContinent(Country guess, Country answer) {
		return guess.getContinent().equals(answer.getContinent()) 
				? Messages.textGreen(guess.getContinent().getDisplayName() + " is answer's continent!") 
		        : Messages.textRed(guess.getContinent().getDisplayName() + " is not answer's continent!");
	}
	
	public static String compareCapitalLetter(Country guess, Country answer) {
		return guess.getCapital().charAt(0) == answer.getCapital().charAt(0)
				? Messages.textGreen(guess.getCapital().charAt(0) + " is the capital's firts letter!") 
				: Messages.textRed(guess.getCapital().charAt(0) + " is not capital's firts letter!");
	}
	
	private double differenceLatitude(Country guess, Country answer) {
		return Math.abs(guess.getCoordinate().getLatitude() - answer.getCoordinate().getLatitude());
	}	
	private double differenceLongitutde(Country guess, Country answer) {
		return Math.abs(guess.getCoordinate().getLongitude() - answer.getCoordinate().getLongitude());
	}
	
	public static String compareCoordinate(Country guess, Country answer) {
		if (guess.getName().equals(answer.getName())) {
	        return Messages.textGreen("Direction: ⦿");
	    }

	    String latitudeArrow = guess.getCoordinate().getLatitude() > answer.getCoordinate().getLatitude() ? "↓" : "↑";
	    String longitudeArrow = guess.getCoordinate().getLongitude() > answer.getCoordinate().getLongitude() ? "←" : "→";
	    return Messages.textYellow("Direction: " + latitudeArrow + longitudeArrow);
	}
	
	public static String compareFlagColor(Country guess, Country answer) {
	    Set<Color> answerColors = new HashSet<>(answer.getFlagColor().getColors());
	    String colors = "";

	    for (Color guessColor : guess.getFlagColor().getColors()) {
	        if (answerColors.contains(guessColor)) {
	            colors += Messages.textYellow(" - ") + Messages.textGreen(guessColor.getDisplayName());
	        } else {
	            colors += Messages.textYellow(" - ") + Messages.textRed(guessColor.getDisplayName());
	        }
	    }

	    return guess.getName().equals(answer.getName())
	    		? Messages.textGreen("Contains colors on flag") + colors
                : Messages.textYellow("Contains colors on flag") + colors;
	}
	
}
