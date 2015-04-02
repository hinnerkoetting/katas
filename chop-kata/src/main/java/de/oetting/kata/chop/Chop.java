package de.oetting.kata.chop;

import java.util.List;

public class Chop {

	public <S extends Comparable<S>> int find(List<S> list, S element) {
		if (list.isEmpty())
			return -1;
		int middle = list.size() / 2;
		int comparison = list.get(middle).compareTo(element);
		if (comparison == 0)
			return middle;
		if (comparison < 0)
			return findInBiggerHalf(list, element, middle);
		if (list.get(0) == element)
			return 0;
		return -1;
	}

	private <S extends Comparable<S>> int findInBiggerHalf(List<S> list, S element, int pivot) {
		if (list.size() <= pivot + 1) {
			return -1;
		}
		int newPivot = (list.size() + pivot) / 2;
		int comparison = list.get(newPivot).compareTo(element);
		if (comparison == 0)
			return newPivot;
		if (comparison < 0) {
			return findInBiggerHalf(list, element, newPivot);
		}
		return -1;

	}
}
