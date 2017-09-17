package chapter2;

import java.util.HashSet;
import java.util.LinkedList;

public class problem1 {
	
	public static Node Remove_duplicates(Node head){
		if(head == null){
			return null;
		}
		
		Node current = head;
		while(current != null){
			Node runner = current;
			while(runner.next != null){
				if(runner.next.data == current.data){
					runner.next = runner.next.next;
				}
				else{
					runner = runner.next;
				}
			}
			current = current.next;
		}
		return head;
	}

	public static void main(String[] args) {
		
		Node fourth = new Node(5,null);
		Node third = new Node(3,fourth);
		Node second = new Node(4,third);
		Node head = new Node(3,second);
		Node temp = head;
		Node node = Remove_duplicates(temp);
		
		while (node.next != null) {
		    System.out.println(node.toString());
		    node = node.next;
		}
		
	}

}
