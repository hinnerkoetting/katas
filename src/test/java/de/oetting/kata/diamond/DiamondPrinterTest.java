package de.oetting.kata.diamond;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiamondPrinterTest {

	@Test
	public void create_characterA_returnsA() {
		String output = whenCreating('A');
		assertEquals("A", output);
	}
	
	@Test
	public void create_characterB_returnsDiamongWithB() {
		String output = whenCreating('B');
		assertEquals(" A\nB B\n A", output);
	}

	private String whenCreating(char character) {
		return new DiamondPrinter().print(character);
	}
}
