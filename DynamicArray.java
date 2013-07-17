import java.util.Scanner;
public class DynamicArray{
	public static void main(String[] args){
		int capacity = 10, ptr = 0;
		Integer[] array = new Integer[capacity];
		Scanner inputInsertDelete = new Scanner(System.in);
		Scanner inputNumber = new Scanner(System.in);
		
		while(true){
			System.out.println("Do you want to insert or delete?");
			String insertOrDelete = inputInsertDelete.next();
			if (insertOrDelete.equals("insert")){
				System.out.println("Enter the number");
				int inNumber = inputNumber.nextInt();
				array[ptr] = inNumber;
				ptr++;
				if (ptr == capacity){
					System.out.println("Going to resize");
					resizeArray(array, 2*capacity);
					capacity += capacity;
					System.out.println("size = " + capacity);
				}
			}
			else if (insertOrDelete.equals("delete")){
				System.out.println("You chose delete");
				if (ptr > 0){
					System.out.println("i'm at " + ptr + " " + array[ptr-1]);
					array[ptr] = null;
					ptr--;
					if (ptr==capacity/4){
						System.out.println("Going to resize");
						resizeArray(array, capacity/2);
						capacity -= capacity;
						System.out.println("size = " + capacity);
					}

				}
				else{
					System.out.println("Out of bounds array");
				}
			}
			else break;
		}
			
	}
	private static void resizeArray(Integer[] array, int capacity){
		Integer[] newArray = new Integer[capacity];
		for(int i = 0;i < capacity; i++){
			newArray[i] = 0;
		}
		for (int i = 0; i< array.length; i++){
			newArray[i] = array[i];
		}
	}

}
