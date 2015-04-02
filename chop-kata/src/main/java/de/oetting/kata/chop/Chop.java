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
		if (elementWasFound(comparison))
			return pivotElement;
		if (searchedElementIsBiggerThanPivotElement(comparison))
			return findBetweenPivotAndMax(list, element, maxIndex, pivotElement);
		return findBetweenMinAndPivot(list, element, minIndex, pivotElement);
	}

	private <S extends Comparable<S>> int findBetweenMinAndPivot(List<S> list, S element, int minIndex, int pivotElement) {
		return find(list, element, minIndex, pivotElement - 1);
	}

	private <S extends Comparable<S>> int findBetweenPivotAndMax(List<S> list, S element, int maxIndex, int pivotElement) {
		return find(list, element, pivotElement + 1, maxIndex);
	}

	private boolean searchedElementIsBiggerThanPivotElement(int comparison) {
		return comparison < 0;
	}

	private boolean elementWasFound(int comparison) {
		return comparison == 0;
	}
}
