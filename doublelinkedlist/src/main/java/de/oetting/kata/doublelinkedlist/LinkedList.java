package de.oetting.kata.doublelinkedlist;

public class LinkedList {

	private int size = 0;
	private Node firstNode;

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(String value) {
		size++;
		Node node = createNode(value);
		if (noNodeExists()) {
			createFirstNode(node);
		} else {
			appendNodeAtTheEnd(node);
		}
	}

	private Node createNode(String value) {
		Node node = new Node();
		node.setValue(value);
		return node;
	}

	private void createFirstNode(Node node) {
		firstNode = node;
		firstNode.setPrevious(firstNode);
		firstNode.setNext(firstNode);
	}

	private void appendNodeAtTheEnd(Node node) {
		Node lastNode = findLastNode();
		lastNode.setNext(node);
		node.setPrevious(lastNode);
		firstNode.setPrevious(node);
		node.setNext(firstNode);
	}

	private boolean noNodeExists() {
		return firstNode == null;
	}

	private Node findLastNode() {
		return firstNode.getPrevious();
	}

	public void remove(int index) {
		if (size <= index)
			throw new IllegalArgumentException("Index is out of range " + index + ". Size is " + size);
		size--;
		changePointersAroundDeletedNode(index);
		if (index == 0)
			firstNode = firstNode.getNext();
	}

	private void changePointersAroundDeletedNode(int index) {
		Node node = getNodeAtIndex(index);
		Node previous = node.getPrevious();
		Node next = node.getNext();
		previous.setNext(next);
		next.setPrevious(previous);
	}

	public String get(int index) {
		return getNodeAtIndex(index).getValue();
	}

	private Node getNodeAtIndex(int index) {
		Node pointer = firstNode;
		for (int i = 0; i < index; i++)
			pointer = pointer.getNext();
		return pointer;
	}

	public int size() {
		return size;
	}

	public boolean contains(String value) {
		Node pointer = firstNode;
		for (int i = 0; i < size(); i++) {
			if (pointer.getValue().equals(value))
				return true;
			pointer = pointer.getNext();
		}
		return false;
	}

}
