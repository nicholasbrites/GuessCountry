package model.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.entities.Coordinate;
import model.entities.Country;
import model.entities.FlagColor;
import model.enums.Color;
import model.enums.Continent;

public class CountryList {
	
	public List<Country> countries(){
		List<Country> countries = new ArrayList<>();
		
		// COUNTRY: NAME, CONTINENT, PIB, POPULATION, INITIALCAPITAL, COORDINATE, FLAGCOLOR
		countries.add(new Country("Afghanistan", Continent.AFRICA, 20.136, 38.928, "Kabul", new Coordinate(38.4833, 70.9833), new FlagColor(Arrays.asList(Color.BLACK, Color.RED, Color.GREEN, Color.WHITE))));
		countries.add(new Country("Albania", Continent.EUROPE, 18.256, 2.877, "Tirana", new Coordinate(42.6666, 19.7333), new FlagColor(Arrays.asList(Color.RED, Color.BLACK))));
		countries.add(new Country("Algeria", Continent.AFRICA, 187.155, 43.851, "Alger", new Coordinate(37.0833, 7.2166), new FlagColor(Arrays.asList(Color.GREEN, Color.WHITE, Color.RED))));
		countries.add(new Country("Andorra", Continent.EUROPE, 3.302, 79.034, "Andorra-la-Vella", new Coordinate(42.6500, 1.5500), new FlagColor(Arrays.asList(Color.BLUE, Color.YELLOW, Color.RED))));
		countries.add(new Country("Angola", Continent.AFRICA, 124.794, 36.996, "Luanda", new Coordinate(-4.3666, 12.7500), new FlagColor(Arrays.asList(Color.RED, Color.BLACK, Color.YELLOW))));
		countries.add(new Country("Antigua and Barbuda", Continent.NORTH_AMERICA, 1.471, 0.093, "St. John's", new Coordinate(17.7333, -61.8500), new FlagColor(Arrays.asList(Color.RED, Color.BLACK, Color.BLUE, Color.WHITE, Color.YELLOW))));
		countries.add(new Country("Argentina", Continent.SOUTH_AMERICA, 630.698, 45.195, "Buenos Aires", new Coordinate(-21.8000, -66.2166), new FlagColor(Arrays.asList(Color.BLUE, Color.WHITE, Color.YELLOW))));
		countries.add(new Country("Armenia", Continent.ASIA, 17.693, 2.963, "Yerevan", new Coordinate(41.3000, 45.0000), new FlagColor(Arrays.asList(Color.RED, Color.BLUE, Color.YELLOW))));
		countries.add(new Country("Australia", Continent.OCEANIA, 1790.348, 25.499, "Canberra", new Coordinate(-9.1500, 143.8833), new FlagColor(Arrays.asList(Color.BLUE, Color.WHITE, Color.RED))));
		countries.add(new Country("Austria", Continent.EUROPE, 468.046, 9.006, "Wien", new Coordinate(47.3333, 13.3333), new FlagColor(Arrays.asList(Color.RED, Color.WHITE))));
		//countries.add(new Country("", Continent., 0, 0, "", new Coordinate(0, 0), new FlagColor(Arrays.asList(Color.))));
		
		return countries;
	}
	
}
