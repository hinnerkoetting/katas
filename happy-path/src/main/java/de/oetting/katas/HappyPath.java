package de.oetting.katas;

import java.util.ArrayList;
import java.util.List;

public class HappyPath {

	public int nextNumber(int i) {
		return getDigits(i);
	}

	private int getDigits(int i) {
		if (i < 10)
			return i % 10;
		return getDigits(i % 10) + getDigits(i / 10);
	}

	public List<Integer> generatePath(int i) {
		List<Integer> list = new ArrayList<Integer>();
		generatePath(i, list);
		return list;
	}

	public void generatePath(int i, List<Integer> list) {
		list.add(i);
		if (i != nextNumber(i)) {
			generatePath(nextNumber(i), list);
		}
	}

}
