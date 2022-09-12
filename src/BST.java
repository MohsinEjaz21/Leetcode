
public class BST {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void inorder(Node root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static Node insert(Node root, int data) {
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

	public static boolean search(Node root, int data) {
		if (root == null) {
			return false;
		}
		if (root.data == data) {
			return true;
		}
		if (data < root.data) {
			return search(root.left, data);
		} else {
			return search(root.right, data);
		}
	}

	public static boolean searchIterative(Node root, int data) {

		if (root == null) {
			return false;
		}
		Node curr = root;
		Node parent = null;
		if (curr.data == data) {
			return true;
		}

		while (curr != null && curr.data != data) {
			parent = curr;
			if (data < curr.data) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		if(curr == null) {
			return false;
		}
		return true;
		
	}

	public static Node insertNodeIterative(Node root, int data) {
		
		if(root == null) {
			return new Node(data);
		}
		Node curr = root;
		Node parent = root;
		
		// traverse and find the right parent
		while(curr != null) {
			parent = curr;
			// if the given value is less than go left sub tree
			if(data < curr.data) {
				curr = curr.left;
			}else {
				curr = curr.right;
			}
		}
		
		if(data < parent.data) {
			parent.left = new Node(data);
		}else {
			parent.right = new Node(data);
		}
		
		return root;
	}
	
	
	public static Node findClosestIterative(Node root,int target) {
		
		int min = Math.abs(root.data - target);
		Node closestNode = root;
		Node curr = root;
		
		while(curr != null) {
			int tempMin = Math.abs(curr.data- target);
			if(tempMin < min) {
				min = tempMin;
				closestNode = curr;
			}
			if(target < curr.data) {
				curr = curr.left;
			}else {
				curr = curr.right;
			}
		}
		
		return closestNode;
		
	}
	
//	public static Node findClosest(Node root, int target, int minimum) {
//		Node closestNode = null;
//		if (root == null) {
//			return new Node(target);
//		}
//		if (minimum == -1) {
//			minimum = Math.abs(root.data - target);
//		}
//		if (root.data == target) {
//			return root;
//		}
//		int tempMin = Math.abs(root.data - target);
//		if (tempMin < minimum) {
//			minimum = tempMin;
//		}
//		System.out.println("gap :: " + minimum);
//		System.out.println("closestNode :: " + root.data);
//
//		if (target < root.data) {
//			return findClosest(root.left, target, minimum);
//		} else {
//			return findClosest(root.right, target, minimum);
//		}
//	}

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

		System.out.println("closest :: " + findClosestIterative(root, 17).data);
		inorder(root);

	}
}