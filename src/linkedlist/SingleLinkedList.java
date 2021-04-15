package linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleLinkedList {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.prepend(0);
		list.prepend(0);
		list.reverseList();
		// list.removeAdjacentDuplicatates();
		list.printList();
	}

	Node head = null;
	Node tail = null;
	int length = 0;

	public void add(int n) {
		Node node = new Node(n);
		if (head == null && tail == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		length++;
	}

	public void prepend(int n) {
		Node node = new Node(n);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
		length++;

	}

	public void insert(int value, int index) {
		if (index > length) {
			add(value);
		} else if (index == 0) {
			prepend(value);
		} else {
			Node node = new Node(value);
			Node leader = getNodeByIndex(index - 1);
			node.next = leader.next;
			leader.next = node;
		}
		length++;

	}

	public void removeByIndex(int index) {
		if (index > length) {
			return;
		}
		if (index == 0) {
			head = head.next;
		} else {
			Node leader = getNodeByIndex(index - 1);
			Node unWantedNode = leader.next;
			leader.next = unWantedNode.next;
		}
		length--;
	}

	public void printList() {
		List<Integer> list = new ArrayList<>();
		Node temp = head;
		while (temp != null) {
			list.add(temp.value);
			temp = temp.next;
		}
		System.out.println(list);
	}

	public Node getNodeByIndex(int index) {
		int in = 0;
		Node temp = head;
		while (in != index) {
			temp = temp.next;
			in++;
		}
		return temp;
	}

	public void removeAdjacentDuplicatates() { // 0 0 1 1 2 3 3 ----> 0 1 2 3

		Node temp = head;
		int counter = 0;
		while (temp != null) {
			if (temp.value == temp.next.value) {
				removeByIndex(counter + 1);
			}
			counter++;
			temp = temp.next;
		}

	}

	// delete node from node i.e 4->5->1->3 given node 5 to remove then 4->1->3
	public void deleteNode(Node node) {
		node.value = node.next.value;
		node.next = node.next.next;
	}

	public Node removeNthFromEnd(int n) {
		Node dummy = new Node(0);
		dummy.next = head;
		int length = 0;
		Node first = head;
		while (first != null) {
			length++;
			first = first.next;
		}
		length -= n;
		first = dummy;
		while (length > 0) {
			length--;
			first = first.next;
		}
		first.next = first.next.next;
		return dummy.next;
	}

	public Node reverseList() {
		Node rev = null;
		Node curr = head;
		while (curr != null) {
			Node temp = curr.next;
			curr.next = rev;
			rev = curr;
			curr = temp;
		}
		return rev;
	}

	// 1 3 4 && 1 2 5 ---> 1 1 2 3 4 5
	public Node mergeTwoListsRecursive(Node l1, Node l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		if (l1.value < l2.value) {
			l1.next = mergeTwoListsRecursive(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoListsRecursive(l1, l2.next);
			return l2;
		}
	}

	// 1 2 3 4
	public Node mergeTwoLists(Node l1, Node l2) {

		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		Node dummy = new Node(0);

		Node n1 = l1, n2 = l2, curr = dummy;

		while (n1 != null && n2 != null) {

			if (n1.value > n2.value) {
				curr.next = n2;
				n2 = n2.next;

			} else {
				curr.next = n1;
				n1 = n1.next;
			}
			curr = curr.next;
		}

		if (n1 != null) {
			curr.next = n1;
		} else if (n2 != null) {
			curr.next = n2;
		}

		return dummy.next;
	}

	public boolean isPalindrome(Node head) {
		List<Integer> list = new ArrayList<>();
		Node temp = head;
		while (temp != null) {
			list.add(temp.value);
			temp = temp.next;
		}
		int start = 0, end = list.size() - 1;
		while (start < end) {
			if (list.get(start++) != list.get(end--)) {
				return false;
			}
		}
		return true;

	}

	public boolean hasCycle(Node head) {
		Set<Node> nodesSeen = new HashSet<>();
		while (head != null) {
			if (nodesSeen.contains(head)) {
				return true;
			}
			nodesSeen.add(head);
			head = head.next;
		}
		return false;
	}

	// Floyd's Cycle Finding Algorithm
	public boolean hasCycle1(Node head) {
		if (head == null) {
			return false;
		}

		Node slow = head;
		Node fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

	class Node {
		int value;
		Node next;

		public Node(int n) {
			this.value = n;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", next=" + next + "]";
		}
	}

}
