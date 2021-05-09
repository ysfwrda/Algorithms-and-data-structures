import java.util.Random;

/**
 *  This class UseCase is for demonstration only!
 *  It shows how to use enum in switch/case, loop over it's values and it's name printing.
 *
 * @author Wolfgang Renz, Reeza Ahamed, Youssef Abouwarda
 * @version Nov. 23, 2020
 */
public abstract class UseCase
{
    public static final int kmax= 13;
    //public static final int Nmax= (int) Math.round(Math.pow(2, kmax));
    public static final int M= 20;  // sample size

    // instance variables:
    private final InputCase inputCase;
    private final int size;
    //private int iterations; // for averaging a sample
    protected int comp, copy; // results to be written by sub-class
    protected Comparable[] numberArray;
    protected static Random randomGenerator = new Random(2502748);

    abstract void sortAndCount();

    protected UseCase(InputCase inputCase, int size)
    {
        // Initialise instance variables
        this.size = size;
        this.inputCase = inputCase;
        /*if (inputCase == InputCase.AVG){
            iterations = M;
        } else{
            iterations= 1;
        }*/

        switch(inputCase){
            case SORTED:
                initAscending();
                sortAndCount();
                break;
            case REVERSE:
                initDescending();
                sortAndCount();
                break;
            case RANDOM:
                initRandom();
                sortAndCount();
                break;
            case AVG:
            default:
                int totalCmp = 0;
                int totalCpy = 0;
                for(int i = 1; i <= M; i++) {
                    initRandom();
                    sortAndCount();
                    totalCmp += comp;
                    totalCpy += copy;
                }
                comp = totalCmp/M;
                copy = totalCpy/M;
                break;
        }
    }

    private void initAscending()
    {
        numberArray = new Comparable[size];
        for(int i=0; i<size; i++) {
            numberArray[i] = randomGenerator.nextDouble() + i;
        }
    }

    private void initDescending()
    {
        numberArray = new Comparable[size];
        for(int i=0; i<size; i++) {
            numberArray[i] = randomGenerator.nextDouble() - i;
        }
    }

    private void initRandom()
    {
        numberArray = new Comparable[size];
        for(int i=0; i<size; i++) {
            numberArray[i] = randomGenerator.nextDouble();
        }
    }

    @Override
    public String toString()
    {
        return inputCase + " case for size " + size + ":";
    }

    String getResults()
    {
        //sortAndCount();
        String results;
        results = String.format("   %10d      %8d",comp,copy);
        return results;
    }

    public void writeResults()
    {
        System.out.printf(String.format("%4d",size));
        System.out.println(getResults());
    }

    public static void makeTable(String sortCase)
    {
        if(sortCase.equals("SelectionCase")) {
            System.out.println("---------------------------------");
            System.out.printf("          Selection Sort\n");
            System.out.println("---------------------------------");
        }
        if(sortCase.equals("MergeCase")) {
            System.out.println("---------------------------------");
            System.out.printf("          Merge Sort\n");
            System.out.println("---------------------------------");
        }
        
         if(sortCase.equals("InsertionCase")) {
            System.out.println("---------------------------------");
            System.out.printf("          Insertion Sort\n");
            System.out.println("---------------------------------");
         }
         
         if(sortCase.equals("QuickCase")) {
             System.out.println("---------------------------------");
             System.out.printf("          Quick Sort\n");
             System.out.println("---------------------------------");
          }
        for (InputCase tableCase: InputCase.values()){
            int N=1;

            System.out.printf("* " + tableCase + " Case *\n");
            System.out.printf("   N          #cmp          #cpy\n");
            System.out.println();

            for(int k = 1; k <= kmax; k++){
                N *= 2;
                UseCase usecase = null;

                 if (sortCase.equals("InsertionCase")){
                    usecase= new InsertionCase(tableCase, N);
                }
				
                else if (sortCase.equals("QuickCase")){
                	usecase= new QuickCase(tableCase, N);
				  }
				 
                assert usecase != null;
                usecase.writeResults();
            }
            System.out.println("---------------------------------");
        }
        System.out.println();
        System.out.println("**************End***************");
        System.out.println();
    }

    public static void main(String[] arg)
    {
        makeTable("InsertionCase");
        makeTable("QuickCase");
    }
}

