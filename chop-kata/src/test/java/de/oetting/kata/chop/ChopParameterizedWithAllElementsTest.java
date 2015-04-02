package de.oetting.kata.chop;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ChopParameterizedWithAllElementsTest {


	@Parameters(name = "List with {0} elements")
	public static Collection<Object[]> createParams() {
		List<Object[]> parametersForOneRun = new ArrayList<>();
		for (int numberOfElements = 0; numberOfElements < 100; numberOfElements++) {
			parametersForOneRun.add(createParametersWithElements(numberOfElements));
		}
		 return parametersForOneRun;
	}

	private static Object[] createParametersWithElements(int numberOfElements) {
		Object[] array = new Object[1];
		array[0] = numberOfElements;
		return array;
	}

	private int numberOfElements;
	private List<Integer> list;
	
	public ChopParameterizedWithAllElementsTest(int numberOfElements) {
		this.numberOfElements = numberOfElements;
		list = new ArrayList<>();
		for (int i = 0; i < numberOfElements; i++ ){
			list.add(i);
		}
	}
	
	@Test
	public void eachElementIsAtPositionOfItsValue(){
		for (int i = 0; i < numberOfElements; i++) {
			int position = findElement(i);
			assertEquals("Element " + i + " should be at position " + i, i, position);
		}
	}

	private int findElement(int i) {
		return new Chop().find(list, i);
	}
}
