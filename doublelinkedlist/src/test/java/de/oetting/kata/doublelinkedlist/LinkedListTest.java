package de.oetting.kata.doublelinkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedListTest {

	private LinkedList classUnderTest;

	@Test
	public void create_thenListIsEmpty() {
		classUnderTest = new LinkedList();
		assertTrue(classUnderTest.isEmpty());
	}

	@Test
	public void add_listIsEmpty_thenIsNotEmpty() {
		classUnderTest = new LinkedList();
		whenAdding("a");
		assertFalse(classUnderTest.isEmpty());
	}

	@Test
	public void remove_listHadOneElement_listIsEmpty() {
		classUnderTest = new LinkedList();
		whenAdding("a");
		whenRemoving(0);
		assertTrue(classUnderTest.isEmpty());
	}
	
	@Test
	public void add_canGetPreviousValue() {
		classUnderTest = new LinkedList();
		whenAdding("a");
		String value = whenGettingValue(0);
		assertEquals("a", value);
	}
	
	private String whenGettingValue(int index) {
		return classUnderTest.get(index);
	}

	private void whenAdding(String value) {
		classUnderTest.add(value);
	}

	private void whenRemoving(int index) {
		classUnderTest.remove(index);
	}
}
