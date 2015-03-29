package de.oetting.katas.diamond;

import java.util.regex.Pattern;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class ContainsPattern extends TypeSafeMatcher<String> {

	private final String expectedPattern;

	public ContainsPattern(String expectedString) {
		this.expectedPattern = "\\s*" + expectedString + "\\s*";
	}

	public void describeTo(Description arg0) {
		arg0.appendText(expectedPattern);
	}

	@Override
	protected void describeMismatchSafely(String item, Description mismatchDescription) {
		mismatchDescription.appendText(item);
	}

	@Override
	protected boolean matchesSafely(String arg0) {
		return Pattern.matches(expectedPattern, arg0);
	}
}
