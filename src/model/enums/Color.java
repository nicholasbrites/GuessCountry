package model.enums;

public enum Color {

	BLACK("Black"),
	BLUE("Blue"),
	BROWN("Brown"),
	GREEN("Green"),
	PINK("Pink"),
	PURPLE("Purple"),
	ORANGE("Orange"),
	RED("Red"),
	WHITE("White"),
	YELLOW("Yellow");
	
	private final String displayName;

    Color(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
	
}
