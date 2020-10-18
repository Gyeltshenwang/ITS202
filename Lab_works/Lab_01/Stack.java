public class Stack{
	int max = 10;
	int top = -1;
	int size = 0;
	int array[] = new int[max];
	public void push(int e) {
		if(top > max) {
		System.out.println("StackOverFlowError");
		}
		else {
			array[++top] = e;
			//System.out.println("Push " + e);
		}
		size = size + 1;
	}
	public void pop(int e) {
		if(top > max) {
			System.out.println("StackUnderFlowError");
		}
		else {
			array[--top] = e;
			//System.out.println("Pop " + e);
		}
		size = size - 1;
	}
	public int top() {
		if(isEmpty()) {
			return 1;
		}
		else {
			int e;
			e = array[top];
			array[top] = 0;
			return e;
		}
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Stack obj = new Stack();
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.pop(5);
		obj.pop(3);
		assert(obj.size() == 1);
		assert(obj.isEmpty() == false);
		assert(obj.top() == 3);
		System.out.println("All are tested Correct");
		//System.out.println("The size of array is " +obj.size());
		//System.out.println("The size is " +obj.isEmpty());
		//System.out.println("Top value of Array is :" +obj.top());
	}
}