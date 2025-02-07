package model.entities;

import model.enums.Continent;

public class Country {

	private String name;
	private Continent continent;
	private Double pib;
	private Double population;
	private String capital;
	private Coordinate coordinate;
	private FlagColor flagColor;
	
	public Country() {
		
	}

	public Country(String name, Continent continent, Double pib, Double population, String capital, 
			Coordinate coordinate, FlagColor flagColor) {
		this.name = name;
		this.continent = continent;
		this.pib = pib;
		this.population = population;
		this.capital = capital;
		this.coordinate = coordinate;
		this.flagColor = flagColor;
	}

	public String getName() {
		return name;
	}

	public Continent getContinent() {
		return continent;
	}

	public Double getPib() {
		return pib;
	}

	public Double getPopulation() {
		return population;
	}

	public String getCapital() {
		return capital;
	}

	public FlagColor getFlagColor() {
		return flagColor;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	@Override
	public String toString() {
		return getName();
	}
	
}
