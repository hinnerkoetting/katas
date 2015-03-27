package de.oetting.kata.diamond;

public class DiamondPrinter {

	public String print(char character) {
		int numberOfDiffferentCharacters = character - 'A' + 1;
		String upperHalf = createLinesUntilWidestPoint(character, numberOfDiffferentCharacters);
		String lowerHalf = createStringUntilBottom(numberOfDiffferentCharacters);
		return upperHalf + lowerHalf;
	}

	private String createStringUntilBottom(int maxLengthOfDiamond) {
		String result = "";
		for (int i = maxLengthOfDiamond - 2; i >= 0; i--) {
			result += createOutputLine(createNthCharacter(i), maxLengthOfDiamond);
			if (createNthCharacter(i) != 'A')
				result += '\n';
		}
		return result;
	}

	private String createLinesUntilWidestPoint(char character, int numberOfCharacters) {
		String result = "";
		for (int i = 0; i < numberOfCharacters; i++) {
			result += createOutputLine(createNthCharacter(i), numberOfCharacters);
			if (character != 'A')
				result += '\n';
		}
		return result;
	}

	private char createNthCharacter(int i) {
		return (char) ('A' + i);
	}

	private String createOutputLine(char c, int numberOfCharacters) {
		if (c == 'A')
			return createTextForA(numberOfCharacters);
		return createOutputLineForNonA(c, numberOfCharacters);
	}

	private String createOutputLineForNonA(char c, int numberOfCharacters) {
		String spacesBefore = createNumberOfSpacesSpaces(numberOfCharacters - (c- 'A') - 1);
		String characterPlusSpacesBetween = c + createNumberOfSpacesSpaces((c - 'A') * 2 - 1) + c;
		return spacesBefore + characterPlusSpacesBetween;
	}

	//This is a special method for A because this will be the only line which only contains one character
	private String createTextForA(int numberOfCharacters) {
		String spaces = createNumberOfSpacesSpaces(numberOfCharacters - 1);
		return spaces + "A";
	}

	private String createNumberOfSpacesSpaces(int times) {
		String result = "";
		for (int i = 0; i < times; i++)
			result += ' ';
		return result;
	}

}
