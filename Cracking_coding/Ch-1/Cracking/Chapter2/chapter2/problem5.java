package chapter2;

import java.util.LinkedList;

public class problem5 {

	public static int length(Node head){
		if(head == null){
			return 0;
		}
		else{
			return 1+ length(head.next);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		/*
		 * http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
		 * 
		 * 
	    LinkedList list = new LinkedList();
        // creating first list
        list.head1 = new Node(7);
        list.head1.next = new Node(5);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        list.printList(head1);
        */ 
 
		
	}

}
