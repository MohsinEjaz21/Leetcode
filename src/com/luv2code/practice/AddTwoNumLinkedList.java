package com.luv2code.practice;

public class AddTwoNumLinkedList {

	class ListNode {
		int val;
		ListNode next;

		ListNode() {}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		int carry = 0;
		int x = 0;
		int y = 0;
		int sum = 0;

		while (l1 != null || l2 != null || carry != 0) {
			if (l1 != null) {
				x = l1.val;
			}
			if (l2 != null) {
				y = l2.val;
			}
			sum = x + y + carry;
			carry = sum / 10;

			curr.next = new ListNode(sum % 10);
			curr = curr.next;

			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}

		}

		return head.next;

	}
	
	public static void main(String[] args) {
		
	}

}
