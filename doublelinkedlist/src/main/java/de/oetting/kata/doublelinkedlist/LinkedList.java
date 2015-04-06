package de.oetting.kata.doublelinkedlist;

public class LinkedList {

	private int size = 0;
	private String value;
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void add(String value) {
		size++;
		this.value = value; 
	}

	public void remove(int index) {
		size--;
	}

	public String get(int index) {
		return value;
	}

}
