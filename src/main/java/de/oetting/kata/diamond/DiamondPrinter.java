package de.oetting.kata.diamond;

public class DiamondPrinter {

	public String print(char character) {
		int numberOfDiffferentCharacters = character - 'A' + 1;
		String upperHalf = createUpperHalf(character, numberOfDiffferentCharacters);
		String middleLine = createMiddleLine(numberOfDiffferentCharacters);
		String lowerHalf = createLowerHalf(numberOfDiffferentCharacters);
		return upperHalf + middleLine + lowerHalf;
	}

	private String createMiddleLine(int numberOfDiffferentCharacters) {
		String line = createOutputLine(createNthCharacter(numberOfDiffferentCharacters - 1), numberOfDiffferentCharacters);
		if (numberOfDiffferentCharacters == 1) 
			return line;
		return line + '\n';
	}

	private String createLowerHalf(int maxLengthOfDiamond) {
		String result = "";
		for (int i = maxLengthOfDiamond - 2; i >= 0; i--) {
			result += createOutputLine(createNthCharacter(i), maxLengthOfDiamond);
			if (createNthCharacter(i) != 'A')
				result += '\n';
		}
		return result;
	}

	private String createUpperHalf(char character, int numberOfCharacters) {
		String result = "";
		for (int i = 0; i < numberOfCharacters - 1; i++) {
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
