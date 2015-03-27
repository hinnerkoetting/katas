package de.oetting.kata.diamond;

public class DiamondPrinter {

	public String print(char character) {
		String upperHalf = createUpperHalf(character);
		String middleLine = createMiddleLine(character);
		String lowerHalf = createLowerHalf(character);
		return upperHalf + middleLine + lowerHalf;
	}

	private String createUpperHalf(char character) {
		String result = "";
		for (int i = 0; i < getNumberOfDifferentCharacters(character) - 1; i++) {
			result += createOutputLine(createNthCharacter(i), getNumberOfDifferentCharacters(character));
			if (character != 'A')
				result += '\n';
		}
		return result;
	}

	private String createMiddleLine(char character) {
		String line = createOutputLine(createNthCharacter(getNumberOfDifferentCharacters(character) - 1),
				getNumberOfDifferentCharacters(character));
		if (getNumberOfDifferentCharacters(character) == 1)
			return line;
		return line + '\n';
	}

	private String createLowerHalf(char character) {
		String result = "";
		for (int i = getNumberOfDifferentCharacters(character) - 2; i >= 0; i--) {
			result += createOutputLine(createNthCharacter(i), getNumberOfDifferentCharacters(character));
			if (createNthCharacter(i) != 'A')
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
		String spacesBefore = createNumberOfSpacesSpaces(numberOfCharacters - (c - 'A') - 1);
		String characterPlusSpacesBetween = c + createNumberOfSpacesSpaces((c - 'A') * 2 - 1) + c;
		return spacesBefore + characterPlusSpacesBetween;
	}

	// This is a special method for A because this will be the only line which
	// only contains one character
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

	private int getNumberOfDifferentCharacters(char character) {
		return character - 'A' + 1;
	}

}
