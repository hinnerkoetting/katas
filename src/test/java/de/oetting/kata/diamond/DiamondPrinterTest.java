package de.oetting.kata.diamond;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DiamondPrinterTest {

	private char character;

	@Parameters(name = "testedCharacter = {0}")
	public static Collection<Object[]> getParameters() {
		return Arrays.asList(new Object[][] { { 'A' }, { 'B' }, { 'C' }, { 'D' }, { 'E' } });
	}

	public DiamondPrinterTest(char character) {
		this.character = character;
	}

	@Test
	public void createdExpectedInput() {
		String output = whenCreating(character);
		assertEquals(readSolution(character), output);
	}

	private String readSolution(char character) {
		InputStream stream = getClass().getResourceAsStream("/" + character + "-result");
		InputStreamReader reader = new InputStreamReader(stream);
		return readStream(new BufferedReader(reader));
	}

	private String readStream(BufferedReader reader) {
		try {
			String result = "";
			String nextLine = reader.readLine();
			while (nextLine != null) {
				result += nextLine;
				nextLine = reader.readLine();
				if (nextLine != null)
					result += '\n';
			}
			return result;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String whenCreating(char character) {
		return new DiamondPrinter().print(character);
	}
}
