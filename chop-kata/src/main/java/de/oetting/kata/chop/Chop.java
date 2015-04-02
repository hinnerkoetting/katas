package de.oetting.kata.chop;

import java.util.List;

public class Chop {

	public <S> int find(List<S> list, S element) {
		if (list.isEmpty())
			return -1;
		if (list.get(0) == element)
			return 0;
		return -1;
	}

}
