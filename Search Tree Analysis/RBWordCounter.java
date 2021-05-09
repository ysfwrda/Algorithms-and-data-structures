import java.util.HashSet;
import java.util.Iterator;

public class RBWordCounter {
	   // Associate each word with a count.
    private RBST<String, Integer> counts;
    private RBST<Integer, HashSet<String> > inverted;
    // will contain the histogramm with the interger over the words

    /**
     * Create a WordCounter
     */
    public RBWordCounter()
    {
        counts = new RBST<>();
        updateInverted(); //instance variable
    }

    /**
     * Update the usage count of all words in input.
     * @param input A set of words entered by the user.
     */
    public void addWords(HashSet<String> input)
    {
        for(String word : input) {
            addWord(word);
        }
    }

    /**
     * Method addWord and update the counts of all words
     *
     * @param word A word to be added
     */
    public void addWord(String word)
    {
        Integer counter = counts.get(word);
        
        if(counter == null){
            counts.put(word, 1);
        }else{
        counts.put(word, counter + 1);
        }
        updateInverted();
    }
    
    /**
     * get all words
     *
     * @return the set of all words
     */
    public HashSet<String> getWords()
    {
        Iterator<String> iterator = counts.iterator();
        HashSet<String> set= new HashSet<String>();
        
        while(iterator.hasNext()){
            set.add(iterator.next());
        }
        return set;
    }

    private void updateInverted() // allways to be called after changing counts!!
    // in order to keep inverted consistent!!!
    {
        inverted = new RBST<Integer, HashSet<String> >();
        // counts.keySet() returns all the words in the HashMap keys
        for (String word: getWords()){
            int counter= counts.get(word); // returns the number of occurencies of the word
            // i.e. the y-values in the histogram !
            HashSet<String> tmp= inverted.get(counts.get(word));// returns the hashSet of words 
            // in inverted for the y-value 
            // or null if that integer is not in the keys of inverted
            if(tmp == null) tmp= new HashSet<String>();
            // inverted.getOrDefault(counter, new HashSet<String>());
            tmp.add(word);
            inverted.put(counter, tmp);
        }
    }
    
    public HashSet<Integer> getInverted()
    {
        Iterator<Integer> iterator = inverted.iterator();
        HashSet<Integer> set= new HashSet<Integer>();
        
        while(iterator.hasNext()){
            set.add(iterator.next());
        }
        return set;
    }

    /**
     * Method calculateInverted 
     * to demonstrate the implementation of problems 8,9 in Lab 3
     * contains redundant code taken from method private updateInverted
     * Think the HashMap in terms of Histogram and inverted Histogram (sketch in the lecture)
     *
     * @return The return value
     */
    public RBST<Integer, HashSet<String> > calculateInverted()
    {
        RBST<Integer, HashSet<String> > inverted = new RBST<>();
        // counts.keySet() returns all the words in the HashMap keys
        for (String word: getWords()){
            int counter= counts.get(word); // returns the number of occurencies of the word
            // i.e. the y-values in the histogram !
            HashSet<String> tmp= inverted.get(counts.get(word));// returns the hashSet of words 
            // in inverted for the y-value 
            // or null if that integer is not in the keys of inverted
            if(tmp == null) tmp= new HashSet<String>();
            // inverted.getOrDefault(counter, new HashSet<String>()); // replaces the last 2 lines
            tmp.add(word);
            inverted.put(counter, tmp);
        }
        return inverted;
    }
    
    

    /**
     * print the HashMap containing the counted words
     *
     */
    public void print()
    {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        
        for(String word: getWords()){
            s1.append("["+word+"=" + counts.get(word)+"] ");
        }
                
        for(Integer inv: getInverted()){
            s1.append(inv+"=" +inverted.get(inv)+" ");
        }
        
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        
     
    }
}