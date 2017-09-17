package chapter2;

public class problem6 {
	
	public Node findLoop(Node head){
		Node fastRunner = head;
		Node slowRunner = head;
		
		while(fastRunner != null || fastRunner.next != null){
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			if(slowRunner == fastRunner){
				break;
			}
		}
		
		// ERROR check: Check whether there is any loop.
		if(fastRunner != null || fastRunner.next != null){
			return null;
		}
		
		slowRunner = head;
		while(slowRunner != fastRunner){
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next;
		}
		return fastRunner;
	}
	
	
	
	public static void main(String[] args) {
		
	}

}
