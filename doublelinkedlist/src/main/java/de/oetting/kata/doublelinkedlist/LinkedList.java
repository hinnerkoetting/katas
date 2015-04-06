package de.oetting.kata.doublelinkedlist;

public class LinkedList {

	private int size = 0;
	private Node firstNode;
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void add(String value) {
		size++;
		Node node = new Node();
		node.setValue(value);
		if (firstNode == null) {
			firstNode = node;
			firstNode.setPrevious(firstNode);
			firstNode.setNext(firstNode);
		} else {
			Node lastNode = findLastNode();
			lastNode.setNext(node);
			node.setPrevious(lastNode);
			firstNode.setPrevious(node);
		}
	}

	private Node findLastNode() {
		return firstNode.getPrevious();
	}

	public void remove(int index) {
		size--;
	}

	public String get(int index) {
		Node pointer = firstNode;
		for (int i = 0; i < index; i++)
			pointer = pointer.getNext();
		return pointer.getValue();
	}
	

	public int size() {
		return size;
	}

}
