import java.util.Scanner;
/**
 * Simple stack implementation :D
 * PS: have to admit, I was like I have to implement push, pull and peek and then realized that the function should be called
 * pull and should be called pop. :P :)
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 * @param <T>
 */

public class Stack<T> {

	private Node<T> top;

	public Node<T> getTop() {
		return top;
	}

	public void setTop(Node<T> top) {
		this.top = top;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	private int size;

	public Stack(){
		top = null;
		size = 0;
	}

	public Stack(T data){
		top = new Node<T>(data);
		size = 0;
	}

	//TODO: have push

	public void push(T data){
		size++;
		Node<T> newNode = new Node<T>(data);
		newNode.next = top;
		top = newNode;
	}

	//TODO: have pop
	public T pop(){
		if(top == null)
			return null;
		size--;
		Node<T> toRemove = top;
		top = top.next;
		return toRemove.data;
	}
	//TODO: have peek
	public T peek(){
		//we will not make any changes to the original structure
		if(top == null)
			return null;
		return top.data;
	}

	public String toString(){
		StringBuffer output = new StringBuffer("");
		Node<T> temp = top;
		while(temp.next != null){
			output.append(temp.data + " --> ");
			temp = temp.next;
		}
		output.append(temp.data);
		return output.toString();

	}

}

class Node<T>{
	T data;
	Node<T> next;
	Node<T> previous;

	public Node(){
		next = null;
		previous = null;
	}

	public Node(T data){
		this.data = data;
		next = null;
		previous = null;
	}
}

class Tester{
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println("Enter the number of elements that you want to enter");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i = 0; i < num; i++){
			System.out.println("Enter element " + (i+1));
			stack.push(scan.nextInt());
		}
		
		System.out.println("The size of the stack is " + stack.getSize());
		System.out.println(stack);
		System.out.println("Lets remove something. :D");
		System.out.println("Element removed " + stack.pop());
		System.out.println("The new size of the stack is "+  stack.getSize());
		System.out.println(stack);
	}
}
