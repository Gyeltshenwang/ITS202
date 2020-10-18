class Linklist {
	Node top;
	Node tail;
	int size;
	//Constructor
	public linklist() {
		top = null;
		tail = null;
		size = 0;
	}
	public void push(int e) {
		Node newest = new Node(e, null);
		if(size == 0) {
			top = newest;
			tail = newest;
			System.out.println("Push " +e);
		}
		else {
			tail.setNext(newest);
			tail = newest;
			System.out.println("Push " +e);
		}
		size = size + 1;
	}
	public int pop() {
		int deletedElement = tail.getElement();
		if(isEmpty()) {
			return 1;
		}
		else {
			top = top.getNext();
			size -= 1;
			System.out.println("Pop : " +tail.getElement());
		}
		return deletedElement;
	}
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	//1. size( ): Returns the number of elements in the list.
	public int size() {
		return size;
	}
}
class Node{
	//Variable declaration
	private int element;
	private Node next;
	//constructor
	public Node(int element, Node next) {
		this.element = element;
		this.next = next;
	}
	//getElement
	public int getElement() {
		return element;
	}
	//getNext
	public Node getNext() {
		return next;
	}
	//setElement
	public void setElement(int e) {
		element = e;
	}
	//setNext
	public void setNext(Node e) {
		next = e;
	}
}
public class StackLinkListDemo {
	public static void main(String[] args) {
		linklist obj = new linklist();
		obj.push(4);
		obj.push(5);
		obj.push(6);
		obj.pop();
		assert(obj.isEmpty() == false);
		assert(obj.size() == 2);
		System.out.println("The size of stack is : " +obj.isEmpty());
		System.out.println("The size of stack is : " +obj.size());
		System.out.println("All are tested correctly");
	}
}