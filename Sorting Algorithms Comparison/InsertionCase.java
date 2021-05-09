
public class InsertionCase extends UseCase {
	Insertion is;

	public InsertionCase(InputCase inputCase, int size) {
		super(inputCase, size);
		 is = new Insertion(); 
		// TODO Auto-generated constructor stub
	}
	
    @Override
    public String toString()
    {
        return "Sorting method, " + super.toString();
    }
    
	public void sortAndCount()
    {
        Insertion.sort(numberArray);
        comp = is.cmp;
        copy = is.cpy;
    }

	
}
