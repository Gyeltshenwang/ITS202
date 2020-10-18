class linklist {
	Node front;
	Node tail;
	int size;
	//Constructor
	public linklist() {
		front = null;
		tail = null;
		size = 0;
	}
	public void enQueue(int e) {
		Node newest = new Node(e, null);
		if(size == 0) {
			front = newest;
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
	public int deQueue() {
		int deletedElement = front.getElement();
		if(isEmpty()) {
			return 1;
		}
		else {
			front = front.getNext();
			size -= 1;
			System.out.println("Pop : " +deletedElement);
		}
		return deletedElement;
	}
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	public int printFrontElement() {
		int frontElement = front.getElement();
		if(size == 0) {
			System.out.println("StackUnderFlowError");
		}
		else {
			return frontElement;
		}
		return printFrontElement();
	}
	public int len() {
		if(isEmpty()) {
			return 1;
		}
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
public class QueueLinkListDemo {

	public static void main(String[] args) {
		linklist obj = new linklist();
		obj.enQueue(8);
		obj.enQueue(2);
		obj.enQueue(1);
		obj.enQueue(8);
		obj.deQueue();
		assert(obj.isEmpty() == false);
		assert(obj.printFrontElement() == 4);
		assert(obj.len() == 3);
		//System.out.println("The size of stack is : " +obj.isEmpty());
		System.out.println("The first Element of stack is : " +obj.printFrontElement());
		System.out.println("All are tested correctly");
	}
}

    