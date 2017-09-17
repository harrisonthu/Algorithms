package chapter2;

public class problem2 {

	
	public static Node nthToLast(Node head, int k){
		Node p1 = head;
		Node p2 = head;
		if(k<= 0){
			return null;
		}
		for(int i=0;i<k;i++){
			if(p2 == null){
				return null;
			}
			p2 = p2.next;
		}
		if(p2 == null){
			return null;
		}
		if(p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
		
	}
	
	public static void main(String[] args) {
		
		Node five = new Node(6,null);
		Node fourth = new Node(4,five);
		Node third = new Node(5,fourth);
		Node second = new Node(3,third);
		Node head = new Node(2,second);
		Node temp = head;
//		while(temp!= null){
//			System.out.println(temp.toString());
//			temp = temp.next;
//		}
		
		Node result = nthToLast(temp, 4);
		System.out.println(result);
//		while (node.next != null) {
//		    System.out.println(node.toString());
//		    node = node.next;
//		}

	}

}
