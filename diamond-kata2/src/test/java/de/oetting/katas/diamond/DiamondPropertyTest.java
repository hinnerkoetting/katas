package de.oetting.katas.diamond;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DiamondPropertyTest {

	@Parameters(name = "character = {0}")
	public static Collection<Object[]> createParameters() {
		return Arrays.asList(createAllCharacters());
	}

	private static Object[][] createAllCharacters() {
		Object[][] allCharacters = new Object[26][];
		for (int i = 0; i < 26; i++) {
			allCharacters[i] = new Object[] { (char) ('A' + i) };
		}
		return allCharacters;
	}

	private char character;

	public DiamondPropertyTest(char character) {
		this.character = character;
	}

	@Test
	public void hasAtLeastOneLine() {
		PrintableObject diamond = whenCreatingDiamond();
		assertThat(diamond.getLines(), hasSize(greaterThan(0)));
	}

	// One line for 'A'
	// Three lines for 'B'
	// Fife lines for 'C'...
	@Test
	public void hasCorrectNumberOfLines() {
		PrintableObject diamond = whenCreatingDiamond();
		assertThat(diamond.getNumberOfLines(), is(equalTo(getNumberOfExpectedLines())));
	}

	@Test
	public void eachLineLengthIsEqualToNumberOfRows() {
		PrintableObject diamond = whenCreatingDiamond();
		for (Line line : diamond.getLines())
			assertEquals(getNumberOfExpectedLines(), line.getLength());
	}

	@Test
	public void eachLineContainsAtLeastOneCharacter() {
		PrintableObject diamond = whenCreatingDiamond();
		for (Line line : diamond.getLines())
			assertThat(line.getText(), new ContainsPattern(".*[A-Z]+.*"));
	}

	@Test
	public void eachLineExpectedFirstAndLastContainsTwoCharacters() {
		PrintableObject diamond = whenCreatingDiamond();
		for (int i = 1; i < diamond.getNumberOfLines() - 1; i++) {
			Line line = diamond.getLines().get(i);
			assertThat(line.getText(), new ContainsPattern("[A-Z]\\s*[A-Z]"));
		}
	}

	@Test
	public void firstAndLastLineOnlyHaveOneCharacter() {
		PrintableObject diamond = whenCreatingDiamond();
		Line firstLine = getFirstLine(diamond);
		assertThat(firstLine.getText(), new ContainsPattern("[A-Z]"));
		Line lastLine = diamond.getLines().get(diamond.getNumberOfLines() - 1);
		assertThat(lastLine.getText(), new ContainsPattern("[A-Z]"));
	}

	@Test
	public void firstAndLastLineHaveCharacterAInTheCenterOfTheLine() {
		PrintableObject diamond = whenCreatingDiamond();
		Line firstLine = getFirstLine(diamond);
		assertThat(firstLine, new HasCharacterInCenter('A'));
		Line lastLine = diamond.getLines().get(diamond.getNumberOfLines() - 1);
		assertThat(lastLine, new HasCharacterInCenter('A'));
	}

	// B has distance 1 to center
	// C has distance 2 to center...
	@Test
	public void allCharactersInLinesExceptFirstAndLastHaveRightDistanceToCenter() {
		PrintableObject diamond = whenCreatingDiamond();
		for (int i = 1; i < diamond.getNumberOfLines() - 1; i++) {
			Line line = diamond.getLines().get(i);
			int center = line.getLength() / 2;
			int distanceToCenter = i <= diamond.getNumberOfLines() / 2 ? i : diamond.getNumberOfLines() - i - 1;
			assertThat(line, new NumberMatcher(center - distanceToCenter));
			assertThat(line, new NumberMatcher(center + distanceToCenter));
		}
	}

	// First line a
	// Second line b
	// Third line c
	@Test
	public void eachLineHasHigherOrLowerCharacterThanLastLine() {
		PrintableObject diamond = whenCreatingDiamond();
		char lastCharacter = 'A';
		for (int i = 1; i < diamond.getNumberOfLines() / 2 + 1; i++) {
			Line line = diamond.getLines().get(i);
			if (line.getText().contains(createrHigherCharacter(lastCharacter))) 
				lastCharacter = createrHigherCharacter(lastCharacter).charAt(0);
			else
				fail("Line must have higher character than last " + lastCharacter + ". But it was " + line);
		}
		for (int i = diamond.getNumberOfLines() / 2 + 1 ; i < diamond.getNumberOfLines(); i++) {
			Line line = diamond.getLines().get(i);
			if (line.getText().contains(createLowerCharacter(lastCharacter))) 
				lastCharacter = createLowerCharacter(lastCharacter).charAt(0);
			else
				fail("Line must have lower character than last " + lastCharacter + ". But it was " + line);
		}
	}

	private String createLowerCharacter(char lastCharacter) {
		return new Character((char) (lastCharacter - 1)).toString();
	}

	private String createrHigherCharacter(char lastCharacter) {
		return new Character((char) (lastCharacter + 1)).toString();
	}

	private Line getFirstLine(PrintableObject diamond) {
		return diamond.getLines().get(0);
	}

	private int getNumberOfExpectedLines() {
		int characterIndex = character - 'A';
		return characterIndex * 2 + 1;
	}

	private PrintableObject whenCreatingDiamond() {
		return new Diamond().create(character);
	}
}
