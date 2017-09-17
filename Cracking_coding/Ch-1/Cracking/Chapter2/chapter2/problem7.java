package chapter2;

import java.util.Stack;

public class problem7 {

	public static boolean isPalindrome(Node head){
		Node slowRunner = head;
		Node fastRunner = head;
		Stack<Integer> mystack = new Stack<Integer>();
		
		while(fastRunner != null || fastRunner.next != null){
			mystack.push(slowRunner.data);
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
		}
		
		//check odd number situation. If so skip the middle one
		if(fastRunner != null){
			slowRunner = slowRunner.next;
		}
		
		while(slowRunner != null){
			int top = mystack.pop().intValue();
			if(top != slowRunner.data){
				return false;
			}
			slowRunner = slowRunner.next;
		}
		return true;
		
	}
	
	
	public static void main(String[] args) {

	}

}
