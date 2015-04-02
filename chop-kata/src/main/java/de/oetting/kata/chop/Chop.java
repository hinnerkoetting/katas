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
			return findInBiggerHalf(list, element, middle + 1, middle + 1, list.size() - 1);
		return findInLowerHalf(list, element, middle, 0, middle - 1);
	}
	private <S extends Comparable<S>> int findInBiggerHalf(List<S> list, S element, int pivot, int min, int max) {
		if (max < pivot) {
			return -1;
		}
		int newPivot = (max + pivot) / 2;
		int comparison = list.get(newPivot).compareTo(element);
		if (comparison == 0)
			return newPivot;
		if (comparison < 0)
			return findInBiggerHalf(list, element, newPivot + 1, newPivot + 1, max);
		return findInLowerHalf(list, element, newPivot - 1, min, newPivot - 1);
	}
	
	private <S extends Comparable<S>> int findInLowerHalf(List<S> list, S element, int pivot, int min, int max) {
		if (pivot < min)
			return -1;
		int newPivot = pivot / 2;
		int comparison = list.get(newPivot).compareTo(element);
		if (comparison == 0)
			return newPivot;
		if (comparison < 0)
			return findInBiggerHalf(list, element, newPivot + 1, newPivot + 1, max );
		return findInLowerHalf(list, element, newPivot - 1, min, newPivot - 1);
	}
}
