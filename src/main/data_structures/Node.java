package main.data_structures;

public class Node<T> {
	private Node<T> prev;
	private Node<T> next;
	private T data;
	
	// Constructors
	
	public Node() {
		prev = null;
		next = null;
		data = null;
	}
	
	public Node(T data) {
		prev = null;
		next = null;
		this.data = data;
	}
	
	public Node(T data, Node<T> prev, Node<T> next) {
		this.prev = prev;
		this.next = next;
		this.data = data;
	}
	
	// Getter methods
	
	public Node<T> getPrevNode() {
		return prev;
	}
	
	public Node<T> getNextNode() {
		return next;
	}
	
	public T getData() {
		return data;
	}
	
	// Setter methods
	
	public void setPrevNode(Node<T> prev) {
		this.prev = prev;
	}
	
	public void setNextNode(Node<T> next) {
		this.next = next;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}
