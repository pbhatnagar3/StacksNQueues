import java.util.Scanner;

import javax.management.RuntimeErrorException;

/**
 * Implementation which allows us to make N stacks all living in one array. There is one limitation
 * with this system. The number of elements per stacks remains the same so a stack will be reported full
 * even when its brother stacks might have some space. So that is a scope of improvement. 
 * 
 * NOTE 1: I wrote this program just for fun and for testing purposes as a proof of concept in limited time.
 * Also, while writing the program, I first thought that I would make a pair class that would hold the starting
 * and the ending indexes of all the stack but I ended up doing index calculation on the go since it was more 
 * challenging and fun. But I have left the code commented out just in case. 
 * 
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 */

public class StackBackedWArray{
	enum Mode{
		ADD(1), REMOVE(2);
		int value;
	    Mode(int value){
			this.value = value;
		}
	    int getValue(){
	    	return value;
	    }
	    
	    public static Mode getMode(int i){
	    	for(Mode val : values()){
	    		if(val.value == i)
	    			return val;
	    	}
	    	return null;
	    }
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	
		System.out.println("Enter how big you want the array to be");
		int[] backendArray = new int[scan.nextInt()];
		letsMakeStacks(backendArray);
		scan.close();
	}

	private static void letsMakeStacks(int[] backendArray) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("how many stacks are we making");
		int numOfStacks = scan.nextInt();
		int eachStackLength = backendArray.length/numOfStacks;
		int[] currentPositions = new int[numOfStacks];
		for(int i = 0; i < currentPositions.length; i++){
			currentPositions[i] = i * eachStackLength;
		}
//		Pair[] stackIndexer = new Pair[numOfStacks]; 
//		int limiter = 0;
//		for(int i = 0; i < stackIndexer.length; i++){
//			stackIndexer[i] = new Pair(limiter, limiter + eachStackLength - 1);
//			limiter += eachStackLength; 
//		}
//		System.out.println();

		while(true){
			System.out.println("what stack are we dealing with");
			int currentStackNumber = scan.nextInt() - 1;
			if(currentStackNumber > numOfStacks){
				System.out.println("enter the correct stack number ");
				continue;
			}
			System.out.println("Enter 1 if you want to add elements and 2 to remove elements");
			Mode currentMode = Mode.getMode(scan.nextInt());
			if(currentMode == Mode.ADD){
				if(currentPositions[currentStackNumber] >= (currentStackNumber+1) * eachStackLength){
					System.out.println("The stack is full...delete some elements");
					System.out.println();
				}
				else{
					System.out.println("please enter the element");
					backendArray[currentPositions[currentStackNumber]++] = scan.nextInt();
				}
				
			}
			else if(currentMode == Mode.REMOVE){
				if(currentPositions[currentStackNumber] > (currentStackNumber) * eachStackLength){
					System.out.println("The element being removed is " + backendArray[--currentPositions[currentStackNumber]]);
				}
				else{
					System.out.println("There is nothing to be removed");
					System.out.println();
				}
			}
		}
	}

}
class Pair{
	private int start;
	private int end;

	public Pair(int start, int end){
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}


}