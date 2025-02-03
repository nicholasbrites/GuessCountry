package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.enums.Color;

public class FlagColor {

	private List<Color> colors = new ArrayList<>();

	public FlagColor(List<Color> colors) {
		this.colors = colors;
	}

	public List<Color> getColors() {
		return colors;
	}
	
}
