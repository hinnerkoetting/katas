package de.oetting.katas.diamond;

public class Diamond {

	public PrintableObject create(char character) {
		PrintableObject object = new PrintableObject();
		for (char currentCharacter = 'A'; currentCharacter <= character; currentCharacter++) 
			object.addLine(createRow(character)  );
		if (character != 'A')
			for (char currentCharacter = (char)(character - 1); currentCharacter >= 'A'; currentCharacter--) 
				object.addLine(createRow(character)  );
		return object;
	}

	private String createRow(char character) {
		return "A" +  createSpaces((character - 'A') * 2);
	}
	
	private String createSpaces(int number) {
		String spaces = "";
		for (int i = 0; i < number; i++)
			spaces += " ";
		return spaces;
	}

}
