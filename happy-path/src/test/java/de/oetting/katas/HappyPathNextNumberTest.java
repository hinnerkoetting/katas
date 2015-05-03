package de.oetting.katas;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HappyPathNextNumberTest {

	private int input;
	private int expectedOutput;

	@Parameters(name="In = {0}, result = {1}")
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] { 
				{ 11, 2 },
				{ 12, 3 },
				{ 21, 3 },
				{ 100, 1 },
				{ 123, 6 },
				{ 418, 13 },
				{ 1234, 10 },
				{ 9152, 17 },
		});
	}

	public HappyPathNextNumberTest(int input, int output) {
		this.input = input;
		this.expectedOutput = output;
	}

	@Test
	public void nextNumber_multiDigitNumber_isSumOfEachCharacter() {
		int output = nextNumberOf(input);
		assertEquals(expectedOutput, output);
	}

	private int nextNumberOf(int i) {
		return new HappyPath().nextNumber(i);
	}
}
