public class removeAfter{
    public static void main(String[] args){
        
    }

    private class Node {
		Item item;
		Node next;
	}
	
	private int size;
	private Node first;

    public void removeAfter(Node node) {
        if (first == null || node == null ) { //check your conditions YOUR CODE HERE
			return;
		}
		
		Node current;
		
		for(current = first; current != null; current = current.next) {
			if (current == node) { //check your condition YOUR CODE HERE
				if (current.next != null) {
                    current.next = current.next.next;
                    size--;
                    //delete the node YOUR CODE HERE
                    //decrease the size YOUR CODE HERE
				}
				break;
			}
		}
	}
}