import java.util.*;
import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl<T> {
	private ListNode<T> head;
	private ListNode<T> tail;
	private String name;
	
	
	public StringStackImpl() {
		this("Stack");
	}
	
	public StringStackImpl(String name) {
		this.name = name;
		head = null;
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public void push(T item) {
		ListNode<T> new_node = new ListNode<T>(item);
		if (isEmpty()) {
			head = tail = new_node;
		} else {
			new_node.next = head;
			head = new_node;
		}
	}
	
	public T pop() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException(name);
		}
		T data = head.getItem();
	
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.next;
		}
		return data;
	}
	
	public T peek() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("My List");
		}
		T data = head.getItem();
		return data;
	}
	
	public void printStack(PrintStream stream) {
		if (isEmpty()) {
			stream.printf( "Empty %s\n", name );
			return;
		}
		
		stream.printf( "The %s is: ", name );
		ListNode<T> current = head;
		
		while (current != null) {
			stream.printf( "%s ", current.item);
			current = current.next;
		}
		
		stream.println( "\n");
	}
	
	public int size() {
		ListNode<T> current = head;
		int i = 0;
		while ( current != null) {
			i++;
			current = current.next;
		}
		return i;
	}
}