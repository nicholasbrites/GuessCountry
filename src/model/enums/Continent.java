package model.enums;

public enum Continent {

	AFRICA("Africa"),
	ASIA("Asia"),
	EUROPE("Europe"),
	NORTH_AMERICA("North America"),
	OCEANIA("Oceania"),
	SOUTH_AMERICA("South America");

	private final String displayName;

    Continent(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
	
}
