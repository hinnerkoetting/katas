package de.oetting.katas.diamond;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

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
			allCharacters[i] = new Object[] { (char)('A' + i) };
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

	private PrintableObject whenCreatingDiamond() {
		return new Diamond().create(character);
	}
}
