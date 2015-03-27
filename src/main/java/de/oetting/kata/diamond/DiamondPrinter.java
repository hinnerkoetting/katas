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
			result += print((char) ('A' + i), maxLengthOfDiamond);
			if ((char) ('A' + i) != 'A')
				result += '\n';
		}
		return result;
	}

	private String createLinesUntilWidestPoint(char character, int numberOfCharacters) {
		String result = "";
		for (int i = 0; i < numberOfCharacters; i++) {
			result += print((char) ('A' + i), numberOfCharacters);
			if (character != 'A')
				result += '\n';
		}
		return result;
	}

	private String print(char c, int numberOfCharacters) {
		if (c == 'A') {
			return createTextForA(numberOfCharacters);
		}
		if (c == 'B') {
			return createTextForB(numberOfCharacters);
		}
		return "C   C";
	}

	private String createTextForB(int numberOfCharacters) {
		return timesSpace(numberOfCharacters - 2) + "B B";
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
