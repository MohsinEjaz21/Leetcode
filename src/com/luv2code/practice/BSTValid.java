package com.luv2code.practice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BSTValid {

	static Node prev = null;
	static List<Node> inorderTravList;
	static int leftHeight =0;
	static int rightHeight = 0;
	static int leftSize=0;
	static int rightSize=0;
	static boolean isLeftCanSplit;
	static boolean isRightCanSplit;

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	static boolean inorder(Node root) {
		if (root == null) {
			return true;
		}

		if (inorderTravList == null) {
			inorderTravList = new ArrayList<>();
		}
		inorder(root.left);
		if (inorderTravList.size() > 1) {
			inorderTravList.remove(0);
			inorderTravList.add(root);
			if (inorderTravList.get(0).data >= inorderTravList.get(1).data) {
				return false;
			}
		} else {
			inorderTravList.add(root);
		}
		inorderTravList.forEach(e -> System.out.print(e.data + " "));
		System.out.println();
		inorder(root.right);
		return true;
	}
	
	static int heightOfTree(Node root) {
		if(root == null) {
			return 0;
		}
		
		leftHeight = heightOfTree(root.left);
		rightHeight = heightOfTree(root.right);

		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	
	static int sizeOfBST(Node root) {
		if(root == null) {
			return 0;
		}
		leftSize = sizeOfBST(root.left);
		rightSize = sizeOfBST(root.right);
		
		return 1+ leftSize + rightSize;
	}
	
	static boolean checkBSTIsSplitableToTwo(Node root, int treeSize) {
		if(root == null) {
			return false;
		}
		// At any stage if treeSize size of any root equals n/2 then
		// all good
		
		if( sizeOfBST(root) == treeSize/2 ) {
			return true;
		}
		
		isLeftCanSplit=  checkBSTIsSplitableToTwo(root.left,treeSize);
		isRightCanSplit = checkBSTIsSplitableToTwo(root.right,treeSize);
		
		
		return isLeftCanSplit || isRightCanSplit;
	}

	static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}

		if (data < root.data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}

	public static Node constructBST(int[] nodes) {
		Node root = null;
		for (int data : nodes) {
			root = insert(root, data);
		}
		return root;
	}

	public static void main(String[] args) {

		int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
		Node root = constructBST(keys);
		System.out.println(heightOfTree(root));
//		System.out.println("closest :: " + findClosestIterative(root, 17).data);
//		System.out.println(inorder(root));
//		rs.stream().forEach(e -> System.out.print(e + " "));
//		System.out.println("isBST : "+isBST(rs));

	}
}