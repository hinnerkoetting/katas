package de.oetting.kata.diamond;

public class DiamondPrinter {

	public String print(char character) {
		String diamond = createDiamond(character);
		return removeLastNewLineCharacter(diamond);
	}

	private String createDiamond(char character) {
		String result = "";
		for (char currentCharacter : new CharactersForEachLine(character)) {
			result += createOutputLine(currentCharacter, character) + '\n';
		}
		return result;
	}

	private String createOutputLine(char character, char inputCharacter) {
		if (character == 'A')
			return createTextForA(getNumberOfDifferentCharacters(inputCharacter));
		return createOutputLineForNonA(character, getNumberOfDifferentCharacters(inputCharacter));
	}

	private String createOutputLineForNonA(char character, int numberOfCharacters) {
		String spacesBefore = createNumberOfSpaces(numberOfCharacters - (character - 'A') - 1);
		String characterPlusSpacesBetween = character + createNumberOfSpaces((character - 'A') * 2 - 1) + character;
		return spacesBefore + characterPlusSpacesBetween;
	}

	// This is a special method for A because this will be the only line which
	// only contains one character
	private String createTextForA(int numberOfDifferentCharacters) {
		String spaces = createNumberOfSpaces(numberOfDifferentCharacters - 1);
		return spaces + "A";
	}

	private String createNumberOfSpaces(int times) {
		String result = "";
		for (int i = 0; i < times; i++)
			result += ' ';
		return result;
	}

	private int getNumberOfDifferentCharacters(char character) {
		return character - 'A' + 1;
	}

	private String removeLastNewLineCharacter(String upperHalf) {
		return upperHalf.substring(0, upperHalf.length() - 1);
	}
}
