package de.oetting.katas;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HappyPathTest {

	private int number;

	@Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 }, { 8 }, { 9 } });
	}

	public HappyPathTest(int number) {
		this.number = number;
	}

	@Test
	public void nextNumber_singleDigit_isInput() {
		int nextNumber = nextNumberOf(number);
		assertEquals(number, nextNumber);
	}

	private int nextNumberOf(int i) {
		return new HappyPath().nextNumber(i);
	}
}
