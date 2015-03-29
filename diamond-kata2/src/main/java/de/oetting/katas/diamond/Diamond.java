package de.oetting.katas.diamond;

public class Diamond {

	public PrintableObject create(char character) {
		PrintableObject object = new PrintableObject();
		for (char currentCharacter = 'A'; currentCharacter <= character; currentCharacter++) 
			object.addLine("");
		if (character != 'A')
			for (char currentCharacter = (char)(character - 1); currentCharacter >= 'A'; currentCharacter--) 
				object.addLine("");
		return object;
	}

}
