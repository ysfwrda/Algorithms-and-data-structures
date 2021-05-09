
public class QuickCase extends UseCase {
	QuickSort qs;
	protected QuickCase(InputCase inputCase, int size) {
		
		super(inputCase, size);
		qs = new QuickSort();
		// TODO Auto-generated constructor stub
	}
	
    @Override
    public String toString()
    {
        return "Sorting method, " + super.toString();
    }


    
	public void sortAndCount()
    {
		
        qs.sort(numberArray);
        comp =Sort.cmp;
        copy = Sort.cpy;
    }
}
