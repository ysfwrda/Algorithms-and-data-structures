public class SelectionCase extends UseCase
{
    public SelectionCase(InputCase inputCase, int size)
    {
        super(inputCase, size);
    }

    @Override
    public String toString()
    {
        return "Sorting method, " + super.toString();
    }

    /**
     * Sorts and counts comparison and copy operations
     */
    public void sortAndCount()
    {
        Selection.sort(numberArray);
        comp = Selection.cmp;
        copy = Selection.cpy;
    }
}
