package tree;

import java.util.Collections;

//O(log N) -- lookup insert delete
public class BinarySearchTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(1);
		tree.insert(5);
		tree.insert(4);
		tree.insert(7);
		tree.insert(3);
		tree.insert(10);
		System.out.println(tree.lookup(17));
		System.out.println(tree.isValidBST(tree.root));
	}

	TreeNode root;

	// O(log n)
	public void insert(int value) {
		TreeNode newNode = new TreeNode(value);

		if (root == null) {
			root = newNode;
		} else {
			TreeNode currentNode = root;
			while (true) {

				if (value < currentNode.val) { // left
					// System.out.println("left");

					if (currentNode.left == null) {
						currentNode.left = newNode;
						break;
					}
					currentNode = currentNode.left;
				} else { // right
					// System.out.println("right");

					if (currentNode.right == null) {
						currentNode.right = newNode;
						break;
					}
					currentNode = currentNode.right;
				}
			}
		}
	}

	// O(log n)
	@SuppressWarnings("null")
	public boolean lookup(int value) {
		if (root == null) {
			return false;
		}

		TreeNode currentNode = root;

		while (currentNode != null) {
			if (value < currentNode.val) {
				currentNode = currentNode.left;
			} else if (value > currentNode.val) {
				currentNode = currentNode.right;
			} else if (value == currentNode.val) {
				return true;
			}
		}

		return false;
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
	}

	public boolean isValidBST(TreeNode root) {
		return validate(root, null, null);
	}

	public boolean validate(TreeNode node, Integer low, Integer high) {
		if (root == null) {
			return true;
		}

		if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
			return false;
		}

		return validate(node.left, low, node.val) && validate(node.right, node.val, high);
	}

}
