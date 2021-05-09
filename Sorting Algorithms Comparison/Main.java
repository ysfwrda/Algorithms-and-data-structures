
public class Main {
// Problem 8 

	public static void main (String [] args){
		//8.1. Testing the invariant of Insertion Sort : subarray 0 to i-1 is always sorted
		
		//8.2. Testing The QuickSort
		Double [] a = {3.4, 5.8,2.1,1.6,3.5,7.7,0.1};
		QuickSort sort = new QuickSort();
		sort.sort(a, 0, 6);
		System.out.println(sort.isSorted(a,0,a.length-1));
		System.out.println("Comparisons: " + sort.cmp);
		System.out.println("Copy: " + sort.cpy);
		
		// Testing the counters with Selection sort for N = 4
		Double [] b = {3.4, 5.8,2.1,1.6};
		Selection ss = new Selection();
		ss.sort(b);
		System.out.println(ss.isSorted(b,0,b.length-1));
		System.out.println("Comparisons Selction:"+ ss.cmp);
		System.out.println("Copy Selction:"+ ss.cpy);
		
		// Testing the counters with Insertion sort for N = 4
		Double [] c = {3.4, 5.8,2.1,1.6};
		Insertion insertion = new Insertion();
		insertion.sort(c);
		System.out.println(insertion.isSorted(c,0,c.length-1));
		System.out.println("Comparisons insertion:"+ insertion.cmp);
		System.out.println("Copy insertion:"+ insertion.cpy);
		

		
	}
}
