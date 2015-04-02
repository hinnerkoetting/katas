package de.oetting.kata.chop;

import java.util.List;

public class Chop {

	public <S extends Comparable<S>> int find(List<S> list, S element) {
		return find(list, element, 0, list.size() - 1);
	}

	private <S extends Comparable<S>> int find(List<S> list, S element, int min, int max) {
		int newPivot = (max + min) / 2;
		if (newPivot < min)
			return -1;
		if (newPivot > max)
			return -1;
		int comparison = list.get(newPivot).compareTo(element);
		if (comparison == 0)
			return newPivot;
		if (comparison < 0)
			return find(list, element, newPivot + 1, max);
		return find(list, element, min, newPivot - 1);
	}
}
