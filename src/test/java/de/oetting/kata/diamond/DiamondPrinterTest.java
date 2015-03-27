package de.oetting.kata.diamond;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Ignore;
import org.junit.Test;

public class DiamondPrinterTest {

	@Test
	public void create_characterA_returnsA() {
		String output = whenCreating('A');
		assertEquals(readFile('a'), output);
	}

	@Test
	public void create_characterB_returnsDiamongWithB() {
		String output = whenCreating('B');
		assertEquals(readFile('b'), output);
	}

	@Test
	public void create_characterC_returnsDiamongWithC() {
		String output = whenCreating('C');
		assertEquals(readFile('c'), output);
	}

	@Ignore
	@Test
	public void create_characterD_returnsDiamongWithD() {
		String output = whenCreating('D');
		assertEquals(readFile('d'), output);
	}

	private String readFile(char character) {
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
