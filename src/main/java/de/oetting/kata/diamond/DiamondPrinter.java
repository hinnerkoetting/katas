package de.oetting.kata.diamond;

public class DiamondPrinter {

	public String print(char character) {
		int numberOfCharacters = character - 'A' + 1;
		String upperHalf = createLinesUntilWidestPoint(character, numberOfCharacters);
		String lowerHalf = createStringUntilBottom(numberOfCharacters);
		return upperHalf + lowerHalf;
	}

	private String createStringUntilBottom(int maxLengthOfDiamond) {
		String result = "";
		for (int i = maxLengthOfDiamond - 2; i >= 0; i--) {
			result += createOutputLine((char) ('A' + i), maxLengthOfDiamond);
			if ((char) ('A' + i) != 'A')
				result += '\n';
		}
		return result;
	}

	private String createLinesUntilWidestPoint(char character, int numberOfCharacters) {
		String result = "";
		for (int i = 0; i < numberOfCharacters; i++) {
			result += createOutputLine((char) ('A' + i), numberOfCharacters);
			if (character != 'A')
				result += '\n';
		}
		return result;
	}

	private String createOutputLine(char c, int numberOfCharacters) {
		if (c == 'A')
			return createTextForA(numberOfCharacters);
		return createOutputLineForNonA(c, numberOfCharacters);
	}

	private String createOutputLineForNonA(char c, int numberOfCharacters) {
		String spacesBefore = timesSpace(numberOfCharacters - (c- 'A') - 1);
		String characterPlusSpacesBetween = c + timesSpace((c - 'A') * 2 - 1) + c;
		return spacesBefore + characterPlusSpacesBetween;
	}

	private String createTextForC(int numberOfCharacters) {
		return timesSpace(numberOfCharacters - 3) + "C" + timesSpace(3) + "C";
	}

	private String createTextForB(int numberOfCharacters) {
		return timesSpace(numberOfCharacters - 2) + 'B' + timesSpace('B' - 'A') + 'B';
	}

	private String createTextForA(int numberOfCharacters) {
		String spaces = timesSpace(numberOfCharacters - 1);
		return spaces + "A";
	}

	private String timesSpace(int times) {
		String result = "";
		for (int i = 0; i < times; i++)
			result += ' ';
		return result;
	}

}
