
public class DoublyLinkedList {

	Node head;
	Node tail;
	
	
	
	class Node{
		Node next;
		Node prev;
		Integer data;
		
		public Node(Integer data) {
			this.data= data;
		}
	
		@Override
		public String toString() {
			return  "[ "+(prev != null ? prev:"")+ "<<="+data+ "=>>" + (next != null ? next:"")+ "]";
		}
	}
	
	
	long size() {
		Node currNode = head;
		int count=0;
		while(currNode !=null) {
			currNode= currNode.next;
			count++;
		}
		return count;
	}
	
	void RemoveMid() {
		int temp =0;
		Node currNode = head;
		System.out.println("size ::"+size());
		while(temp < (size()/2) && currNode != null) {
			currNode=currNode.next;
			temp++;
		}
		if(size()%2 == 0) {
			currNode=currNode.prev;
		}
		currNode=currNode.prev;
		System.out.println("data::"+currNode.data);

		currNode.next = currNode.next.next;
		currNode.next.prev = currNode;
	}
//A<-B->C


	void addFront(int data) {
		if(head==null) {
			head= tail =new Node(data);
			head.prev=null;
			tail.next=null;
			return;
		}
		Node node = new Node(data);
		head.prev = node;
		node.next = head;
		head = node;
	}
	
	void addEnd(int data) {
		if(head==null) {
			head= tail =new Node(data);
			head.prev=null;
			tail.next=null;
			return;
		}
		Node node = new Node(data);
		tail.next = node;
		node.prev = tail;
		tail = node;
	}
	
	void removeFront(int data) {
		
	}
	
	void removeEnd(int data) {
		
	}
	
	void remove(int data) {
		
	}
	
 void printIt(DoublyLinkedList ll) {
		Node curr = head;
		while(curr !=null) {
			System.out.println(curr.data);
			curr =curr.next;
		}
	}
	
	
	public static void main(String[] args) {
		DoublyLinkedList linkedList = new DoublyLinkedList();
//		linkedList.addFront(6);
//		linkedList.addFront(5);
//		linkedList.addFront(4);
//		linkedList.addFront(3);
//		linkedList.addFront(2);
//		linkedList.addFront(1);

		linkedList.addEnd(1);
		linkedList.addEnd(2);
		linkedList.addEnd(3);
		linkedList.addEnd(4);
		linkedList.addEnd(5);
		linkedList.addEnd(6);
//		linkedList.addEnd(7);

		linkedList.RemoveMid();
		linkedList.printIt(linkedList);
	}
}
