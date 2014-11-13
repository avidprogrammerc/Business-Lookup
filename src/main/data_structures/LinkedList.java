package main.data_structures;

import java.util.NoSuchElementException;

public class LinkedList<T> {
	private Node<T> head;
	
	public int getSize() {
		int count = 0;
		if (head == null) {
			return count;
		} else {
			Node<T> temp = head;
			do {
				temp = temp.getNextNode();
				count++;
			} while (temp != head);
		}
		return count;
	}
	
	public void traverse() {
		if (head == null) {
			System.out.println("List is empty!");
		} else {
			Node<T> temp = head;
			do {
				System.out.println(temp.getData());
				temp = temp.getNextNode();
			} while (temp != head);
		}
	}
	
	public void insertAtBeginning(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			newNode.setNextNode(newNode);
			newNode.setPrevNode(newNode);
			head = newNode;
		} else {
			Node<T> temp = head.getPrevNode();
			temp.setNextNode(newNode);
			newNode.setPrevNode(temp);
			newNode.setNextNode(head);
			head.setPrevNode(newNode);
			head = newNode;
		}
	}
	
	public void insertAtEnd(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			newNode.setNextNode(newNode);
			newNode.setPrevNode(newNode);
			head = newNode;
		} else {
			Node<T> temp = head.getPrevNode();
            temp.setNextNode(newNode);
            newNode.setNextNode(head);
            head.setPrevNode(newNode);
            newNode.setPrevNode(temp);
		}
	}
	
	public void clearList() {
		head = null;
	}
	
	public T getCurrentElement() {
		if (getSize() > 0) {
			return head.getData();
		} else {
			throw new NoSuchElementException("No element found!");
		}
	}
	
	public void next() {
		if (getSize() > 0) {
			head = head.getNextNode();
		}
	}
	
	public void previous() {
		if (getSize() > 0) {
			head = head.getPrevNode();
		}
	}
}
