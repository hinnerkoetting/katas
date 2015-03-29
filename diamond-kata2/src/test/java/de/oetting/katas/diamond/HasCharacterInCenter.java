package de.oetting.katas.diamond;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class HasCharacterInCenter extends TypeSafeMatcher<Line>{

	private final char expectedCharacter;

	public HasCharacterInCenter(char expectedCharacter) {
		this.expectedCharacter = expectedCharacter;
	}

	public void describeTo(Description arg0) {
		arg0.appendText("Has character in center: " + expectedCharacter);
	}

	@Override
	protected boolean matchesSafely(Line arg0) {
		return arg0.getText().charAt(arg0.getLength() / 2) == expectedCharacter;
	}
	
	
	
}
