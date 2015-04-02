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

	private int whenFindingElement(int i) {
		return new Chop().find(list, i);
	}
}
