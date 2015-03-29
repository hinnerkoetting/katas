package de.oetting.katas.diamond;

import java.util.regex.Pattern;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class ContainsPattern extends TypeSafeDiagnosingMatcher<String> {

	private final String expectedPattern;

	public ContainsPattern(String expectedString) {
		this.expectedPattern = "\\s*" + expectedString + "\\s*";
	}

	public void describeTo(Description arg0) {
		arg0.appendText(expectedPattern);
	}

	@Override
	protected boolean matchesSafely(String arg0, Description arg1) {
		return Pattern.matches(expectedPattern, arg0);
	}

}
