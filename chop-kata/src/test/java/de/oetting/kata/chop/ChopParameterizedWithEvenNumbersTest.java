package de.oetting.kata.chop;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ChopParameterizedWithEvenNumbersTest {

	@Parameters(name = "List with {0} elements")
	public static Collection<Object[]> createParams() {
		List<Object[]> parametersForOneRun = new ArrayList<>();
		for (int maxValue = 0; maxValue < 100; maxValue += 2) {
			parametersForOneRun.add(createParametersWithEvenValuesUntil(maxValue));
		}
		return parametersForOneRun;
	}

	private static Object[] createParametersWithEvenValuesUntil(int numberOfElements) {
		Object[] array = new Object[1];
		array[0] = numberOfElements;
		return array;
	}

	private int maxValue;
	private List<Integer> list;

	public ChopParameterizedWithEvenNumbersTest(int maxValue) {
		this.maxValue = maxValue;
		list = new ArrayList<>();
		for (int i = 0; i < maxValue; i += 2) {
			list.add(i);
		}
	}

	@Test
	public void find_forEachEvenValue_isAtPositionOfItsValueDividedBy2() {
		for (int i = 0; i < maxValue; i += 2) {
			int position = findValue(i);
			assertEquals(i / 2, position);
		}
	}

	@Test
	public void find_forEachUnevenValue_isNotFound() {
		for (int i = -1; i < maxValue + 2; i += 2) {
			int position = findValue(i);
			assertEquals("Element " + i + " must not be found", -1, position);
		}
	}

	private int findValue(int i) {
		return new Chop().find(list, i);
	}
}
