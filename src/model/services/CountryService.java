package model.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.entities.Country;
import model.enums.Color;
import model.enums.Direction;

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
	
	public static String compareCoordinate(Country guess, Country answer) {
		final double limit = 1;

	    double latDiff = guess.getCoordinate().getLatitude() - answer.getCoordinate().getLatitude();
	    double lonDiff = guess.getCoordinate().getLongitude() - answer.getCoordinate().getLongitude();

	    if (guess.getName().equals(answer.getName())) {
	        return Messages.textGreen("Direction: " + Direction.CENTER.getArrow());
	    }

	    boolean ignoreLat = Math.abs(latDiff) < limit;
	    boolean ignoreLon = Math.abs(lonDiff) < limit;

	    Map<String, Direction> directions = new HashMap<>();
	    directions.put("N", Direction.NORTH);
	    directions.put("S", Direction.SOUTH);
	    directions.put("E", Direction.EAST);
	    directions.put("W", Direction.WEST);
	    directions.put("NE", Direction.NORTHEAST);
	    directions.put("NW", Direction.NORTHWEST);
	    directions.put("SE", Direction.SOUTHEAST);
	    directions.put("SW", Direction.SOUTHWEST);
	    
	    String key = "";
	    if (!ignoreLat) key += (latDiff > 0) ? "S" : "N";
	    if (!ignoreLon) key += (lonDiff > 0) ? "W" : "E";
	    return Messages.textYellow("Direction: " + directions.getOrDefault(key, Direction.CENTER).getArrow());
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
