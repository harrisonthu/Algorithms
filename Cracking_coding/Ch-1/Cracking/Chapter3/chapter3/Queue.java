package chapter3;

public class Queue {
	Node first,last;
	
	void enqueue(int item){
		Node newNode = new Node(item, null);
		if(first == null){
			last = newNode;
			first = last;
		}else{
			last.next = newNode;
			last = last.next;
		}
	}
	
	Object dequeue(){
		if(first != null){
			int temp = first.data;
			first = first.next;
			if(first == null){
				last = null;
			}
			return temp;
		}
		return null;
	}
}
