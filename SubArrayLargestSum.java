public class SubArrayLargestSum{


public static void main(String[] args){

	int[] intArray = {9, 2, -2, 3, -5, 1, 4 , -9};
	int max = Integer.MIN_VALUE;
	int minIndex=0, maxIndex=0;
	for (int i = 0; i< intArray.length; i++){
		int sum = 0;
		for (int j = i; j>= 0; j--){
			sum += intArray[j];
			if (sum>max){
				max = sum;
				minIndex = j; maxIndex = i;
			}
		}	
	}
	System.out.println("Max sum is "+ max + " and sub array is " + minIndex + " "+ maxIndex);
	for (int i = minIndex; i<=maxIndex; i++){
		System.out.print(intArray[i] + " ");}

}
}
