public class BitOperations{
	public static boolean oppositeSigns(int num1, int num2){
		return ((num1^num2)<0);
	}


	public static void main(String[] args){
		System.out.println(oppositeSigns(-1,2));
	}
}
