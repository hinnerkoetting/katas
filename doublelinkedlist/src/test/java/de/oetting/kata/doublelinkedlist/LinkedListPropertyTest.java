package de.oetting.kata.doublelinkedlist;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LinkedListPropertyTest {

	@Parameters
	public static Collection<Object[]> createParameters() {
		Object[][] parameters = new Object[20][];
		for (int i = 0; i < parameters.length; i++) {
			parameters[i] = createParameters(i);
		}
		return Arrays.asList(parameters);
	}

	private static Object[] createParameters(int numberOfParameters) {
		List<String> parameters = new ArrayList<>(numberOfParameters);
		for (int i = 0; i < numberOfParameters; i++) {
			parameters.add(String.valueOf('A' + i));
		}
		return new Object[] { parameters };
	}

	private List<String> parameters;

	public LinkedListPropertyTest(List<String> parameters) {
		this.parameters = parameters;
	}

	@Test
	public void addEachItem_listHasSizeOfNumberOfItems() {
		LinkedList classUnderTest = new LinkedList();
		addAll(classUnderTest);
		assertEquals(parameters.size(), classUnderTest.size());
	}

	@Test
	public void getValue_equalsValuesFromParameters() {
		LinkedList classUnderTest = new LinkedList();
		addAll(classUnderTest);
		for (int i = 0; i < classUnderTest.size(); i++) {
			assertEquals("Parameter at index " + i + " must be equal", parameters.get(i), classUnderTest.get(i));
		}
	}

	@Test
	public void deleteFirstElement_allOtherElementsAreMovedByOne() {
		if (parameters.size() < 1)
			return;
		LinkedList classUnderTest = new LinkedList();
		addAll(classUnderTest);
		classUnderTest.remove(0);
		for (int i = 0; i < classUnderTest.size(); i++) {
			assertEquals("Parameter at index " + i + " must be equal", parameters.get(i + 1), classUnderTest.get(i));
		}
	}

	@Test
	public void deleteSecondElement_allLaterElementsAreMovedByOne() {
		if (parameters.size() < 2)
			return;
		LinkedList classUnderTest = new LinkedList();
		addAll(classUnderTest);
		classUnderTest.remove(1);
		for (int i = 1; i < classUnderTest.size(); i++) {
			assertEquals("Parameter at index " + i + " must be equal", parameters.get(i + 1), classUnderTest.get(i));
		}
		assertEquals(parameters.get(0), classUnderTest.get(0));
	}
	

	private void addAll(LinkedList classUnderTest) {
		for (String parameter : parameters) {
			classUnderTest.add(parameter);
		}
	}
}
