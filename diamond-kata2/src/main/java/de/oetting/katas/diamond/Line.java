package de.oetting.katas.diamond;

public class Line {

	private final String text;

	public Line(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public int getLength() {
		return text.length();
	}
	
	
}
