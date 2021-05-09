
public abstract class  Sort {
	protected static int cmp;
	protected static int cpy;
		public Sort() {
			this.cmp = 0;
			this.cpy = 0;
		}
	  public static boolean isSorted(Comparable[] a, int left, int right) { 
		  // Test whether the array entries are in order.
		        for (int i = left+1; i < right+1; i++){
		            if (less(a[i], a[i-1])){
		                return false;
		            }
		        }
		        return true;
		    }
	  
	  protected static boolean isPartitioned(Comparable a[], int left, int border, int right)
	    {
	        boolean leftIsSorted = isSorted(a, left, border-1);
	        boolean rightIsSorted = isSorted(a, border, right);

	        if(leftIsSorted && rightIsSorted){
	            return true;
	        }
	        return false;
	        
	    }
	
	protected static void exch ( Comparable [] a, int i, int j)
	{
	Comparable tmp = a[i];
	a[i] = a[j];
	a[j] = tmp ;

	cpy++;
	}
	
	protected static boolean less ( Comparable v, Comparable w){
		cmp++;
		return (v. compareTo (w) <0); 
	}
	
	
}
