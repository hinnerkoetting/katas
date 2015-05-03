package de.oetting.katas;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class HappyPathTest {

	@Test
	public void createPath_forEndElement_containsOnlyInput() {
		List<Integer> happyPath = createPath(1);
		assertThat(happyPath, contains(1));
	}
	
	@Test
	public void createPath_forDescendingElement_containsInputAndAllNextElements() {
		List<Integer> happyPath = createPath(31);
		assertThat(happyPath, contains(31, 4));
	}
	
	@Test
	public void createPath_forDescendingElementWithTwoFollowingElements_containsInputAndAllNextElements() {
		List<Integer> happyPath = createPath(38);
		assertThat(happyPath, contains(38, 11, 2));
	}

	private List<Integer> createPath(int i) {
		return new HappyPath().generatePath(i);
	}
}
