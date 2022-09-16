import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class TreeHeight {
	Node root;
	final static TreeHeight instance = new TreeHeight(); 
	
	static class Node {
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
		}
		@Override
		public String toString() {
			return String.format("Node [data=%s, left=%s, right=%s]", data, left, right);
		}
		
	}
	
  int findDepth(Node root) {
  	if(root == null) {
  		return 0;
  	}
  	return 1 + Math.max(findDepth(root.left), findDepth(root.right));
  }
  
  int findDepthIterative(Node root) {
  	int heightLeft =0;
  	int heightRight=0;
  	int height =0;
  	if(root == null) {
  		return 0;
  	}
  	Node leftNodeRef=  root.left;
  	Node rightNodeRef=  root.right;
  	
  	while(leftNodeRef !=null) {
  		leftNodeRef = leftNodeRef.left;
  		heightLeft++;
  	}

  	while(rightNodeRef !=null) {
  		rightNodeRef = rightNodeRef.left;
  		heightRight++;
  	}
  	
  	if(heightLeft < heightRight) {
  		height = heightRight;
  	}else {
  		height = heightLeft;
  	}
  	return height;
  }
  
	
	Node insertNode(Node root, int data) {
		if(root == null) {
		  return new Node(data);
		}
	  if(data < root.data) {
			root.left = insertNode(root.left, data);
		}else {
			root.right = insertNode(root.right,data);
		}
		return root;
	}
	
	Node insertNode(int[] nodes) {
	  root = null;
		for(int data : nodes) {
			root = insertNode(root, data);
		}
		return root;
	}
	
	public static void main(String[] args) {
		int[] nodes = { 15, 10, 20, 8, 12, 16, 25 , 30};
		Node root = instance.insertNode(nodes);
		System.out.println("depth : "+instance.findDepthIterative(root));
		System.out.print(root);
	}
}
