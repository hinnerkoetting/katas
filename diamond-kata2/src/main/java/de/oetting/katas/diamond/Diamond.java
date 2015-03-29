package de.oetting.katas.diamond;

public class Diamond {

	public PrintableObject create(char character) {
		PrintableObject object = new PrintableObject();
		for (char currentCharacter = 'A'; currentCharacter <= character; currentCharacter++) 
			object.addLine(createRow(currentCharacter, character)  );
		if (character != 'A')
			for (char currentCharacter = (char)(character - 1); currentCharacter >= 'A'; currentCharacter--) 
				object.addLine(createRow(currentCharacter, character)  );
		return object;
	}

	private String createRow(char currentCharacter, char targetCharacter) {
		if (currentCharacter == 'A') 
			return "A" + createSpaces((targetCharacter - 'A') * 2);
		return "AA" +  createSpaces((targetCharacter - 'A') * 2 - 1);
	}
	
	private String createSpaces(int number) {
		String spaces = "";
		for (int i = 0; i < number; i++)
			spaces += " ";
		return spaces;
	}

}
