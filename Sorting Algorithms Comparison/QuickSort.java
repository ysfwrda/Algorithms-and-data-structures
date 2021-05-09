import java.util.Random;

public class QuickSort extends Sort {

	public QuickSort() {
		super();
		// TODO Auto-generated constructor stub
	}



	public static void sort ( Comparable [] a)
	{
	shuffle (a);
	sort (a ,0,a. length -1);
	}
	protected static void shuffle ( Comparable a[])
	{
	Random rnd = new Random ();
	for ( int i =0; i<a. length ; i++)
	exch (a,i, rnd. nextInt (a. length ));
	}
	protected static void sort ( Comparable a[], int L, int R)
	{
	if (R-L <=0) return ; // less than 2 elements
	int m = partition (a,L,R);
	sort (a,L,m -1);
	sort (a,m+1,R);
	}
	
	protected static int partition ( Comparable a[], int L, int R )
			{
			int i = L -1;
			int j = R;
			while ( true )
			{
			while ( less (a [++i],a[R ])) // find item on left
			if ( i==R ) break ; // to swap
			while ( less (a[R],a[--j])) // find item on right
			if ( j==L ) break ; // to swap
			if ( i >=j ) break ; // do pointers cross ?
			exch (a,i,j); // otherwise do swap
			}
			exch (a,i,R); // final swap
			return i; // return index of cross point
			}
}