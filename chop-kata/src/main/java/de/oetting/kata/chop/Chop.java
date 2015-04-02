package de.oetting.kata.chop;

import java.util.List;

public class Chop {

	public <S extends Comparable<S>> int find(List<S> list, S element) {
		return find(list, element, 0, list.size() - 1);
	}

	private <S extends Comparable<S>> int find(List<S> list, S element, int minIndex, int maxIndex) {
		int pivotElement = (maxIndex + minIndex) / 2;
		if (pivotElement < minIndex)
			return -1;
		if (pivotElement > maxIndex)
			return -1;
		int comparison = list.get(pivotElement).compareTo(element);
		if (comparison == 0)
			return pivotElement;
		if (comparison < 0)
			return find(list, element, pivotElement + 1, maxIndex);
		return find(list, element, minIndex, pivotElement - 1);
	}
}
