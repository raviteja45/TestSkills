package slash.practice;

public class Stack {

	private Node1 first;
	
	Stack(){
		first = null;
	}
	
	public void insertFirst(int data) {
		Node1 n = new Node1();
		n.data = data;
		n.next = first;
		first = n;
	}
	
	public void deleteFirst() {
		if(first==null) {
			System.out.println("No data");
		}
		first = first.next;
		
	}
	
	public void display() {
		Node1 temp = first;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public void push(int data) {
		insertFirst(data);
	}
	
	public void pop() {
		deleteFirst();
	}
	
	
	
	public static void main(String[] args) {
		Stack s = new Stack();
		System.out.println("Before pop up");
		s.push(10);
		s.push(20);
		s.push(30);
		s.display();
		s.pop();
		System.out.println("After pop up");
		s.display();

	}
	
	
	

}

class Node1{
	int data;
	Node1 next;
}
