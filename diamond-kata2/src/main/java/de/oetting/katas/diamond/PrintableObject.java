package de.oetting.katas.diamond;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintableObject {

	private List<Line> lines = new ArrayList<Line>();

	public List<Line> getLines() {
		return Collections.unmodifiableList(lines);
	}

	public void addLine(String line) {
		lines.add(new Line(line));
	}

	public int getNumberOfLines() {
		return lines.size();
	}
	
	public String createString() {
		String result = "";
		for (Line line: lines) {
			result += line.getText() + "\n";
		}
		return result.substring(0, result.length() - 1);
	}
	
}
