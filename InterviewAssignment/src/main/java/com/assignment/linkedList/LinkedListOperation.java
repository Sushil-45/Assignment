package com.assignment.linkedList;

public class LinkedListOperation {

	private Node head; // Head is first node of linkedlist
	private Node tail; // Tail is last node of linkedlist
	private int size;

	public LinkedListOperation() {
		this.size = 0; // size will be zero at the start.
	}

	// Method to insert value at first
	public void addFirst(int val) {

		Node node = new Node(val); /// new node is created with value

		node.next = head;
		head = node; // head always points to first node and node is newly established

		if (tail == null) { // this means that this first item that is added
			tail = head;
		}
		size += 1;
	}

	// Method to insert data into Last
	public void insertLast(int val) {

		if (tail == null) {
			addFirst(val);
			return;
		}
		Node node = new Node(val);
		tail.next = node;
		tail = node;
		size++;
	}

	public void display() {

		Node temp = head; // We will use one tempNode as we will re-assing the node we don't need to change the
							// actual head of the node

		while (temp != null) {
			System.out.print(temp.value + " => ");
			temp = temp.next; // this will make sure that it will reference to another pointer of node
		}
		System.out.println("End");
	}

	// insert value into particular index
	public void addData(int val, int index) {

		if (index == 0) {
			addFirst(val);
			return;
		}
		if (index == size) {
			insertLast(val);
			return;
		}

		Node temp = head;

		for (int i = 1; i < index; i++) { // Not starting from zero as above temp itself is zero
			temp = temp.next;
		}

		Node node = new Node(val, temp.next);
		temp.next = node;
		size++;
	}

	// Method to deleteFirst element
	public int deleteFirst() {

		int value = head.value;
		head = head.next;

		if (head == null) {
			tail = null;
		}
		size--;
		return value;
	}

	// Method to deleteLast element complexity is o(n)
	public int deleteLast() {

		if (size <= 1) {
			return deleteFirst();
		}

		Node secondLastElement = get(size - 2); // It will give data of secondLast element of Node
		int value = tail.value;
		tail = secondLastElement;
		tail.next = null;

		return value;
	}

	// method to delete based on index
	public int deleteByIndex(int index) {

		if (index == 0) {
			deleteFirst();
		}
		if (index == size - 1) {
			deleteLast();
		}

		Node previous = get(index - 1);

		int value = previous.next.value;
		previous = previous.next.next;  
		return value;

	}

	// Method to get Node of second lastElement
	public Node get(int index) {

		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}

		return node;
	}

	// method to search a particular node
	public Node searchByValue(int value) {

		Node node = head;
		while (node != null) {
			if (node.value == value) {
				System.out.println("Found the value : " +node.value);
				return node;
			}
			node = node.next;
		}

		return null;
	}

	// Class represent the linkedList
	private class Node {

		private int value;
		private Node next;

		// to initalize the node with the data and next pointer
		public Node(int value) {
			this.value = value;
			this.next = null;
		}

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

	}

}