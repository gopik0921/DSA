package LinkedList;

import java.util.ArrayList;
import java.util.List;

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
		//list.removeByIndex(2);
	//	list.insert(2,2);
		list.removeAdjacentDuplicatates();
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
		// System.out.println(head);
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
		} else {
			Node node = new Node(value);
			Node leader = getNodeByIndex(index - 1);
            node.next=leader.next;
            leader.next=node;
		}
		length++;

	}

	public void removeByIndex(int index) {
		if (index > length) {
			return;
		}
		Node leader = getNodeByIndex(index - 1);
		Node unWantedNode = leader.next;
		leader.next = unWantedNode.next;
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
//		System.out.println(temp);
		return temp;
	}
	
	public void removeAdjacentDuplicatates() { // 0 0 1 1 2 3 3   ----> 0 1 2 3
		
		Node temp=head;
		int counter=0;
		while(temp!=null) {
			if(temp.value==temp.next.value) {
				removeByIndex(counter+1);
			}
			counter++;
			temp=temp.next;
		}
		
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
