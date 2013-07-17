import java.util.Scanner;

public class Fibonacci{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter n ");
		int nth = input.nextInt();
		int fiboResult = fibonacci(nth);
		System.out.println(fiboResult);

	
	}

	public static int fibonacci(int n){
		if ((n==0) || (n==1))
			return n;
		else return (fibonacci(n-1) + fibonacci(n-2));
	}
}
