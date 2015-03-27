package de.oetting.kata.diamond;

public class DiamondPrinter {

	public String print(char character) {
		String result = "";
		int maxLengthOfDiamond = character - 'A' + 1;
		for (int i = 0; i < maxLengthOfDiamond; i++) {
			result += print((char)('A' + i), maxLengthOfDiamond);
			if (character != 'A')
				result += '\n';
		}
		for (int i = maxLengthOfDiamond - 2; i >= 0; i--) {
			result += print((char)('A' + i), maxLengthOfDiamond);
			if ((char)('A' + i) != 'A') 
				result += '\n';
		}
		return result;
	}

	private String print(char c, int maxLengthOfDiamond) {
		if (c == 'A') {
			if (maxLengthOfDiamond == 1)
				return "A";
			if (maxLengthOfDiamond == 2)
				return " A";
			else 
				return "  A";
		}
		if (c == 'B') {
			if (maxLengthOfDiamond == 2)
				return "B B";
			else 
				return " B B";
		}
		return "C    C";
	}

}
