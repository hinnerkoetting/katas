package de.oetting.kata.chop;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
	
	@Test
	public void find_elementInListWithTwoElements_returnsElementsPosition() {
		givenListContains(1, 2);
		int position = whenFindingElement(2);
		assertEquals(1, position);
	}
	
	@Test
	public void find_topElementInListWithThreeElements_returnsElementsPosition() {
		givenListContains(1, 2, 3);
		int position = whenFindingElement(3);
		assertEquals(2, position);
	}
	
	@Test
	public void find_topElementInListWithFifeElements_returnsElementsPosition() {
		givenListContains(1, 2, 3, 4, 5);
		int position = whenFindingElement(5);
		assertEquals(4, position);
	}
	
	@Test
	public void find_secondHighedElementInListWithFifeElements_returnsElementsPosition() {
		givenListContains(1, 2, 3, 4, 5);
		int position = whenFindingElement(2);
		assertEquals(1, position);
	}

	private void givenListContains(Integer... numbers) {
		list.addAll(Arrays.asList(numbers));
	}

	private int whenFindingElement(int i) {
		Collections.sort(list);
		return new Chop().find(list, i);
	}
}
