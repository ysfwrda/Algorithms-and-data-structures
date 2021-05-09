/**
 * class Selection from Sedgewick.
 *
 * @author Wolfgang Renz
 * @version Nov. 3, 2020
 */
public class Selection extends Sort
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++) // i: destination site
        {
            int min = i; // index of minimum candidate
            for (int j = i+1; j < N; j++){
                if (less(a[j], a[min])){
                    min = j; // better minimum candidate found
                }
            }
            // now min is the index of the minimum
            exch(a, i, min);
            
            assert true == isSorted(a,0,i) : "Invariants aren't true";
        }
    }
}
