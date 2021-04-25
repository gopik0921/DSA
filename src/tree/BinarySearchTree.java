package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *  Root is the topmost node of the tree
    Edge is the link between two nodes
    Child is a node that has a parent node
    Parent is a node that has an edge to a child node
    Leaf is a node that does not have a child node in the tree
    Height is the length of the longest path to a leaf
    Depth is the length of the path to its root
 * 
 */

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
		// 9 4 20 1 6 15 25
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(4);
		tree.insert(2);
		tree.insert(7);
		tree.insert(1);
		tree.insert(3);
		tree.insert(6);
		tree.insert(9);

//		System.out.println(tree.lookup(17));
//		System.out.println(tree.isValidBST(tree.root));
//		tree.breadthFirstSearch();
//		tree.DFSInOrder();
//		tree.DFSPreOrder();
//		tree.DFSPostOrder();
//		tree.leftView();
		tree.invertTree(tree.root);

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

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		int left = 1 + minDepth(root.left);
		int right = 1 + minDepth(root.right);

		if (left == 1)
			return right;
		if (right == 1)
			return left;
		else if (left > right)
			return right;
		else
			return left;
	}

	public boolean isValidBST(TreeNode root) {
		return validate(root, null, null);
	}

	public boolean validate(TreeNode node, Integer low, Integer high) {
		if (node == null) {
			return true;
		}

		if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
			return false;
		}

		return validate(node.left, low, node.val) && validate(node.right, node.val, high);
	}

	public boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}

	public boolean isMirror(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 == null || t2 == null) {
			return false;
		}

		return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);

	}

	public boolean isSame(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 == null || t2 == null) {
			return false;
		}
		return (t1.val == t2.val) && isSame(t1.right, t2.right) && isSame(t1.left, t2.left);
	}

//	Input: root = [3,9,20,null,null,15,7]
//	Output: [[3],[9,20],[15,7]]
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> output = new ArrayList<>();

		if (root == null) {
			return output;
		}

		Queue<TreeNode> q = new LinkedList<>();

		q.offer(root);

		while (!q.isEmpty()) {
			int level = q.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < level; i++) {
				TreeNode temp = q.poll();
				if (temp.left != null) {
					q.offer(temp.left);
				}
				if (temp.right != null) {
					q.offer(temp.right);
				}
				list.add(temp.val);
			}
			output.add(list);
		}

		return output;

	}

	// A height-balanced binary tree is a binary tree in which the depth of the two
	// subtrees of every node never differs by more than one.
//	Input: nums = [-10,-3,0,5,9]
//	Output: [0,-3,9,-10,null,5]
//	Explanation: [0,-10,5,null,-3,null,9] is also accepted

	public TreeNode sortedArrayToBST(int[] nums) {
		return insertToSortedArrayBST(nums, 0, nums.length - 1);
	}

	public TreeNode insertToSortedArrayBST(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = insertToSortedArrayBST(nums, start, mid - 1);
		root.right = insertToSortedArrayBST(nums, mid + 1, end);

		return root;
	}

	/*
	 * 9 4 20 1 6 15 25
	 * 
	 * BFS = [9,4,20,1,6,15,25] level order traversal
	 * 
	 * DFS(InOrder) = [1 ,4 ,6 ,9 , 15 ,20 ,25]
	 *
	 * DFS(PreOder) = [9, 4 , 1 ,6 ,20 , 15, 25] -- easy to recreate tree
	 *
	 * DFS(PostOder) = [1, 6 , 4, 15 , 25, 20 ,9]
	 * 
	 * 
	 */

	public void breadthFirstSearch() {
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode currentNode = root;
		q.offer(currentNode);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			list.add(temp.val);
			if (temp.left != null) {
				q.offer(temp.left);
			}
			if (temp.right != null) {
				q.offer(temp.right);
			}
		}
		System.out.println(list);
	}

	private void DFSInOrder() {
		var list = new ArrayList<Integer>();
		traverseInOrder(root, list);
		System.out.println(list);
	}

	private void DFSPreOrder() {
		var list = new ArrayList<Integer>();
		traversePreOrder(root, list);
		System.out.println(list);
	}

	private void DFSPostOrder() {
		var list = new ArrayList<Integer>();
		traversePostOrder(root, list);
		System.out.println(list);
	}

	public void traverseInOrder(TreeNode node, List<Integer> list) {
		if (node.left != null) {
			traverseInOrder(node.left, list);
		}
		list.add(node.val);
		if (node.right != null) {
			traverseInOrder(node.right, list);
		}
	}

	public void traversePreOrder(TreeNode node, List<Integer> list) {
		list.add(node.val);
		if (node.left != null) {
			traversePreOrder(node.left, list);
		}
		if (node.right != null) {
			traversePreOrder(node.right, list);
		}
	}

	public void traversePostOrder(TreeNode node, List<Integer> list) {
		if (node.left != null) {
			traversePostOrder(node.left, list);
		}

		if (node.right != null) {
			traversePostOrder(node.right, list);
		}
		list.add(node.val);

	}

	public void leftView() {
		var list = new ArrayList<Integer>();

		leftViewUtil(root, 1, list);

		System.out.println("left view  " + list);

	}

	int maxLevel = 0;

	private void leftViewUtil(TreeNode node, int level, ArrayList<Integer> list) {
		if (node == null) {
			return;
		}

		if (maxLevel < level) {
			list.add(node.val);
			maxLevel = level;
		}

		leftViewUtil(node.left, level + 1, list);
		leftViewUtil(node.right, level + 1, list);

		// for rightview interchane above recursive calls
	}

	Integer flag = null;

	public boolean isValidBSTInorder(TreeNode root) {
		if (root == null)
			return true;

		if (!isValidBSTInorder(root.left)) {
			return false;
		}
		if (flag != null && root.val <= flag) { // must and should be <=
			return false;
		}
		flag = root.val;

		return isValidBSTInorder(root.right);
	}

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		int sum = 0;
		if (root.left != null && root.left.left == null && root.left.right == null)
			sum += root.left.val;
		return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode right = invertTree(root.right);
		TreeNode left = invertTree(root.left);
		root.left = right;
		root.right = left;
		return root;
	}

	public TreeNode invertTree1(TreeNode root) {
		if (root == null)
			return null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			TreeNode temp = current.left;
			current.left = current.right;
			current.right = temp;
			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
		}
		return root;
	}

	public void flatten(TreeNode root) {
		root = helperflatten(root);
	}

	TreeNode helperflatten(TreeNode root) {

		if (root == null) {
			return null;
		}

		TreeNode rightNodes = root.right;

		root.right = helperflatten(root.left);
		root.left = null;

		TreeNode current = root;

		while (current.right != null) {
			current = current.right;
		}

		current.right = helperflatten(rightNodes);

		return root;
	}
}
