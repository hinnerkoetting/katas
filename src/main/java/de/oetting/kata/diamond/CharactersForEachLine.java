package de.oetting.kata.diamond;

import java.util.Iterator;

/**
 * This class will provide different Characters beginning from A until
 * <character> and then going back down to A.<br>
 * <ul>
 * <li>
 * for A this will return [A].</li>
 * <li>
 * for B this will return [A, B, A].</li>
 * <li>
 * for C this will return [A, B, C, B, A].</li>
 * <li>...</li>
 * </ul>
 */
public class CharactersForEachLine implements Iterable<Character> {

	private final char character;
	private int currentIndex;
	
	public CharactersForEachLine(char character) {
		this.character = character;
	}

	public Iterator<Character> iterator() {
		return new Iterator<Character>() {

			public boolean hasNext() {
				return currentIndex < numberOfDifferentCharacters() * 2 + 1;
			}

			public Character next() {
				currentIndex++;
				if (isInUpperHalf())
					return createNthCharacter();
				
				return createDescendingCharacterFromTarget() ;
			}

			private char createDescendingCharacterFromTarget() {
				return (char)(2 * character - 'A' - currentIndex  + 1);
			}

			private char createNthCharacter() {
				return (char)('A' + currentIndex - 1);
			}

			private int numberOfDifferentCharacters() {
				return character - 'A';
			}

			private boolean isInUpperHalf() {
				return currentIndex <=  numberOfDifferentCharacters() + 1;
			}
		};
	}

}
