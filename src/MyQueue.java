import java.util.Scanner;
/**
 * Here is a simple implementation of a queue. May the force always be there for you. :D
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 * @param <T>
 */
public class MyQueue<T>{
	private Node<T> front;
	private Node<T> back;
	public Node<T> getFront() {
		return front;
	}

	public void setFront(Node<T> front) {
		this.front = front;
	}

	public Node<T> getBack() {
		return back;
	}

	public void setBack(Node<T> back) {
		this.back = back;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private int size;
	
	public MyQueue(){
		front = null;
		back = null;
		size = 0;
	}
	
	public MyQueue(T data){
		front = new Node<T>(data);
		back = front;
		size = 1;
	}
	
	public void add(T data){
		size++;
		Node<T> toAdd = new Node<T>(data);
		if(front == null){
			front = toAdd;
			back = toAdd;
		}
		else{
			back.next = toAdd;
			back = toAdd;
		}
	}
	
	public T remove(){
		if(front == null){
			return null;
		}
		else{
			size--;
			T toRemove = front.data;
			front = front.next;
			return toRemove;
		}
	}
	
	public String toString(){
		StringBuffer output = new StringBuffer("");
		Node<T> temp = front;
		while(temp.next != null){
			output.append(temp.data + "<--");
			temp = temp.next;
		}
		
		output.append(temp.data);
		return output.toString();
	}
}

class QueueTester{
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		System.out.println("Enter the number of elements that you want to enter into the queue");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i = 0; i < num; i++){
			System.out.println("Enter element " + (i+1));
			queue.add(scan.nextInt());
		}
		
		System.out.println("The quue size at present is " + queue.getSize());
		System.out.println(queue);
		System.out.println("remove the first element from the queue");
		System.out.println("The element removed is " + queue.remove());
		System.out.println("Now the queue looks like the following");
		System.out.println(queue);
		System.out.println("and the current size of the queue is " + queue.getSize());
	}
}