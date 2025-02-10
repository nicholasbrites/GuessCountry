package model.enums;

public enum Direction {

	NORTH("↑"),
	SOUTH("↓"),
	EAST("→"),
	WEST("←"),
    NORTHEAST("↗"),
    NORTHWEST("↖"),
    SOUTHEAST("↘"),
    SOUTHWEST("↙"),
    CENTER("⦿");

    private final String arrow;

    Direction(String arrow) {
        this.arrow = arrow;
    }

    public String getArrow() {
        return arrow;
    }
	
}
