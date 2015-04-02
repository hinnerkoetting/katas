package de.oetting.kata.chop;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ChopTest {

	private List<Integer> list = new ArrayList<>(); 
	
	@Test
	public void find_emptyList_returnsMinusOne() {
		int position = whenFindingElement(1);
		assertEquals(-1, position);
	}
	
	@Test
	public void find_elementInlistWithOnlyThisElement_returns0() {
		givenListContains(1);
		int position = whenFindingElement(1);
		assertEquals(0, position);
	}
	
	@Test
	public void find_elementInlistWithOnlyAnotherElement_returnsMinusOne() {
		givenListContains(1);
		int position = whenFindingElement(2);
		assertEquals(-1, position);
	}

	private void givenListContains(int i) {
		list.add(i);
	}

	private int whenFindingElement(int i) {
		return new Chop().find(list, i);
	}
}
