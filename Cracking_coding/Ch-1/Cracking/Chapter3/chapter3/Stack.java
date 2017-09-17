package chapter3;

public class Stack {
	Node top;
	
	Object pop(){
		if(top != null){
			Object temp = top.data;
			top = top.next;
			return temp;
		}
		return null;
	}
	
	void push(int data){
		Node newNode = new Node(data, null);
		newNode.next = top;
		top = newNode;	
	}
	
	Object peek(){
		return top.data;
	}
	

}
