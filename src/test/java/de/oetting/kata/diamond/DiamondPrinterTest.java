package de.oetting.kata.diamond;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiamondPrinterTest {

	@Test
	public void create_characterA_returnsA() {
		String output = whenCreating("A");
		assertEquals("A", output);
	}

	private String whenCreating(String string) {
		return new DiamondPrinter().print(string);
	}
}
