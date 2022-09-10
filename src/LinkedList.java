
public class LinkedList {
	Node head;
	Node tail;
	
	public LinkedList(int data) {
		Node node = new Node(10);
		node.next = null;
		head = tail = node;
	}

	
	@Override
	public String toString() {
		return "LinkedList [head=" + head + ", tail=" + tail + "]";
	}
	
	private void addFront(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	
	private void addEnd(int data) {
     Node node = new Node(data);
     node.next =null;
     tail.next = node;
     tail = node;
	}
	
	public int remove() {
		return 0;
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList(10);
		ll.addFront(12);
		ll.addFront(13);
		ll.addEnd(14);
		ll.addEnd(16);

		System.out.println(ll.toString());
	}
	
}

class Node{
	Node next;
	Integer data;
	
	public Node(Integer data) {
		this.data= data;
	}

	@Override
	public String toString() {
		return "[ data "+data+ "=>>" + next+ "]";
	}
	
	
}