package com.assignment.linkedList;


public class MainMethodForLikedListAssignment {

	public static void main(String arg[]) {

		LinkedListOperation list = new LinkedListOperation();

		list.addFirst(13);
		list.addFirst(3);
		list.addFirst(4);
		list.addFirst(5);
		list.addFirst(6);
		list.addFirst(7);
		list.insertLast(99);
		list.addData(100, 3);
		list.addFirst(101);
		list.display();
		
		list.searchByValue(101);
		list.searchByValue(5);
		
		// Best-case time complexity 0(1) - when element is present at head 
		// Avg-case and worst-case time complexity o(n) -  as we need to traverse throughout the list or it is present in middle of list
		
	}

}
