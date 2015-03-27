package de.oetting.kata.diamond;

public class DiamondPrinter {

	public String print(Character character) {
		String result = "";
		int maxLengthOfDiamond = character - 'A' + 1;
		if (character.equals('A')) {
			result += print('A', 1);
		} else {
			result += print('A', maxLengthOfDiamond) + '\n';
			result += print('B', maxLengthOfDiamond) + '\n';
			result += print('A', maxLengthOfDiamond);
		}
		return result;
	}

	private String print(char c, int maxLengthOfDiamond) {
		if (c == 'A') {
			if (maxLengthOfDiamond == 1)
				return "A";
			else
				return " A";
		} else {
			return "B B";
		}
	}

}
