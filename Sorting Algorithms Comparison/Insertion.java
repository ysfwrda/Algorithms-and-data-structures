/**
 * class Insertion from Sedgewick.
 *
 * @author Wolfgang Renz
 * @version Nov. 3, 2020
 */
public class Insertion extends Sort
{
	
    public Insertion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 1; i < N; i++){
            for (int j = i; j > 0; j--){
                if (less(a[j], a[j-1])){
                    exch(a, j, j-1);
                }
                else{
                    break; // input dependent
                }
                
            }
            assert true == isSorted(a,0,i-1);
        }
    }
	//8.1. Testing the invariant of Insertion Sort : subarray 0 to i-1 is always sorted
    
}
