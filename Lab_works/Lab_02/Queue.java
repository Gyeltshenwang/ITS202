public class QueueDemo {
	int front = 0;
	int max = 5;
	int rear = 0;
	int size = 0;
	int queue[] = new int [max];
	public void enQueue(int e) {
		if(rear > max) {
			System.out.println("QueueOverFlowError");
		}
		else{
		queue[rear] = e;
		rear++;
		size++;
		System.out.println("Elements : " + e);
		}
	}
	public int deQueue() {
		if(rear > max) {
			System.out.println("QueueUnderFlowError");
		}
		else {
			int e;
			e = queue[front];
			front++;
			size--;
			return e;
		}
		return front;
	}
	public int printFirstElement() {
		if(isEmpty()) {
			return 1;
		}
		else {
		int e;
		e = queue[front];
		return e;
		}
	}
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	public int len() {
		if(isEmpty()) {
			return 1;
		}
		return size;
	}
	public static void main(String[] args) {
		Queue obj = new Queue();
		obj.enQueue(1);
		obj.enQueue(8);
		obj.enQueue(4);
		obj.enQueue(3);
		assert(obj.isEmpty() == false);
		assert(obj.printFirstElement() == 5);
		assert(obj.len() == 4);
		//System.out.println("Element remove is " +obj.deQueue());
		//System.out.println("The first element in the queue is : " + obj.printFirstElement());
		//System.out.println("There is no queue elements : " + obj.isEmpty());
		//System.out.println("The size of a queue elements is : " + obj.len());
		System.out.println("Allare tested correctly");
	}
}