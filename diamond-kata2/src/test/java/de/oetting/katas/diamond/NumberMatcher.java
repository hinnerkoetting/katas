package de.oetting.katas.diamond;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class NumberMatcher extends TypeSafeMatcher<Line> {

	private int position;

	public NumberMatcher(int position) {
		this.position = position;
	}

	@Override
	protected boolean matchesSafely(Line arg0) {
		Matcher<Character> matcher = allOf(is(greaterThanOrEqualTo('A')), is(lessThanOrEqualTo('Z')));
		return matcher.matches(arg0.getText().charAt(position));
	}

	public void describeTo(Description arg0) {
		arg0.appendText("Has character at position " + position);
	}
	
}