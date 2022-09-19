package com.luv2code.practice;

public class LinkedList {
	Node head;
	Node tail;

	static final LinkedList ll = new LinkedList(10);

	public LinkedList(int data) {
		Node node = new Node(10);
		node.next = null;
		head = tail = node;
	}

	@Override
	public String toString() {
		return "LinkedList [head=" + head + ", tail=" + tail + "]";
	}

	private void reverseList() {
		Node curr = head.next;
		head.next = null;
		while (curr != null) {
			curr.next = head;
			head = curr;
			curr = curr.next;
		}

	}

    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        Node curr=head;
        Node prev=null;
        
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
//      			System.out.println(curr);
        }
        return prev;
    }

	private void addFront(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}

	private void addEnd(int data) {
		Node node = new Node(data);
		node.next = null;
		tail.next = node;
		tail = node;
	}

	public int remove() {
		return 0;
	}

	public static void main(String[] args) {
		ll.addFront(12);
		ll.addFront(13);
		ll.addFront(14);
		ll.addFront(15);

//		ll.addEnd(14);
//		ll.addEnd(16);

		ll.reverseList(ll.head);

		System.out.println(ll);
	}

}

class Node {
	Node next;
	Integer data;

	public Node(Integer data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.format("Node [next=%s, data=%s]", next, data);
	}

	

}