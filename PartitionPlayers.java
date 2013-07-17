//The Grinch is given the job of partitioning 2n players into two teams of n 
//players each. Each player has a numerical rating that measures how good 
//he/she is at the game. He seeks to divide the players as unfairly as possible,
//so as to create the biggest possible talent imbalance between team A and 
//team B. Show how the Grinch can do the job in O(n log n) time.
import java.util.Random;
public class PartitionPlayers{
	public static void shuffle(Comparable[] array){
		int size = array.length;
		Random random = new Random();
		for (int i =0; i<size; i++){
			int rand = i+random.nextInt(size-i);
			Comparable temp = array[rand];
			array[rand] = array[i];
			array[i] = temp;
		}
	}
	public static void sort(Comparable[] a){
		shuffle(a);
		int n = a.length/2;
		sort(a,0,a.length-1,n-1);
	}
	private static void sort(Comparable[] a, int lo, int hi, int n){
		if (hi<=lo) return ;
		int j = partition(a,lo,hi);
		if (j>n){
			hi = j-1;
			sort(a,lo,hi,n);
		}
		else if (j<n){
			lo = j+1;
			sort(a,lo,hi,n);
		}
		else return ;
	}
	private static int partition(Comparable[] a, int lo, int hi){
		int i = lo, j = hi+1;
		Comparable v = a[lo];
		while(true){
			while(less (a[++i],v)) if (i == hi) break;
			while(less (v,a[--j])) if (j == lo) break;
			if (i >= j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	private static void exch(Comparable[] a, int one, int two){
		Comparable temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
	private static boolean less(Comparable v, Comparable w){
		return (v.compareTo(w)<0);
	}

	public static void main(String[] args){
		Integer[] team = {1,9,8,7,6,4,2,3,5,0};
		for (int i = 0;i<team.length; i++)
			System.out.print(team[i] + " ");
		System.out.println(" ");
		sort(team);
		for (int i = 0;i<team.length; i++)
			System.out.print(team[i] + " ");
		System.out.println(" ");
	}

}
