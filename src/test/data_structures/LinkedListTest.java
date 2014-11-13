package test.data_structures;

import java.util.NoSuchElementException;

import main.data_structures.LinkedList;
import student.TestCase;

public class LinkedListTest extends TestCase {
	
	LinkedList<Integer> list;

	public void setUp() {
		list = new LinkedList<Integer>();
	}
	
	public void testEmpty() {
		boolean thrown = false;
		try {
			list.getCurrentElement();
		} catch (NoSuchElementException e) {
			thrown = true;
		}
		
		assertTrue(thrown);
	}
	
	public void testSingleInsertion() {
		list.insertAtEnd(1);
		assertEquals(1, list.getSize());
	}
	
	public void testMultipleInsertion() {
		list.insertAtEnd(1);
		assertEquals(1, list.getSize());
		assertEquals(1, list.getCurrentElement().intValue());
		
		list.insertAtEnd(2);
		assertEquals(2, list.getSize());
		assertEquals(1, list.getCurrentElement().intValue());
		
		list.insertAtBeginning(3);
		assertEquals(3, list.getSize());
		assertEquals(3, list.getCurrentElement().intValue());
		
		list.insertAtEnd(4);
		assertEquals(4, list.getSize());
		assertEquals(3, list.getCurrentElement().intValue());
	}
	
	public void testNext() {
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		
		list.next();
		
		assertEquals(2, list.getCurrentElement().intValue());
	}
	
	public void testPrevious() {
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		
		list.previous();
		
		assertEquals(2, list.getCurrentElement().intValue());
	}
	
	public void testClear() {
		list.insertAtEnd(1);
		assertEquals(1, list.getSize());
		
		list.clearList();
		assertEquals(0, list.getSize());
	}
}
