package chapter2;

public class problem4 {

	public static Node partition(Node node,int n){
		Node lessthan = null;
		Node greater = null;
		
		if(node != null){
			Node next = node.next;
			if(node.data<n){
				node.next = lessthan;
				lessthan = node;
			}
			else{
				node.next = greater;
				greater = node;
			}
			node = node.next;
		}
		if(lessthan == null){
			return greater;
		}
		
		Node current = lessthan;
		while(lessthan.next != null){
			current = current.next;
		}
		lessthan.next = greater;
		return node;
	}
	
	
	public static void main(String[] args) {
		int length = 20;
		Node[] nodes = new Node[length];
		

	}

}
