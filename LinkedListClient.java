import java.util.Scanner;
public class LinkedListClient{
	public static void main(String[] args){
		LinkedList<Integer> list = new LinkedList<Integer>();
		Scanner input = new Scanner(System.in);
		int score=Integer.MAX_VALUE;
		while(score!=0){
			System.out.println("Enter next one ");
			score = input.nextInt();
			list.insert(score);
		}
		//while(!list.isEmpty())
		//	System.out.println(list.remove());
		
		//System.out.println("Reverse");
		//list.reverseList();
		//while(!list.isEmpty())
		//	System.out.println(list.remove());
		
		list.printMiddleNode();
	}

}
