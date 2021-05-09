import java.util.HashSet;
import java.util.Iterator;

public class DepthCounter {
	//our word Binary Search Tree
	 
	//Binary Search Tree for the counts and their depths
	 private BST<Integer, Integer> counts;

	 //Constructor
	public DepthCounter() {
		counts = new BST<>();
	}
	
	// Methods
	//Method addDepths to construct the histogram of depths 
	 public void addDepths(HashSet<Integer> input)
	    {
	        for(int depth : input) {
	            addDepth(depth);
	        }
	    }

	    /**
	     * Method addDepth and update the counts frequency of all depths
	     *
	     * @param depth A depth to be added
	     */
	    public void addDepth(Integer depth)
	    {
	     Integer counter   = counts.get(depth);
	        
	        if(counter == null){
	            counts.put(depth, 1);
	        }else{
	        counts.put(depth, counter + 1);
	        } 
	    }
	    

	    public void calcluateDepths(String key, RBST<String, Integer> tree)
	    {
		 //we traverse through our tree in each node, 
	        //BST.Node x = tree.getRoot();
		      RBST.Node x = tree.getRoot();
	        int curDepth = 0;
	        while (x != null)
	        {
	            int cmp = key.compareTo((String)x.getKey()); // searches for the key in our tree
	            if (cmp == 0) // if already available
	            {
	            	tree.put(key, curDepth);
	            	return;
	            	// overwrites the value of the depth in our word BST with the currentDepth
	               // SearchResult result = new SearchResult(x.value, curDepth); //returns new SearchResult with the value and the depth
	           //     return result;
	                // also possible:
	                // return new SearchResult(x.value, curDepth);
	            }
	            else if (cmp < 0)
	                x = 
	                x.getLeft();
	            else if (cmp > 0)
	                x = x.getRight();
	            ++curDepth; //anyway increase the depth by one , because we moved to a child(right or left)
	        }
	   
	    }

		public HashSet<Integer>getDepths(){
	    	HashSet<Integer> depths = new HashSet<Integer>();
	    	Iterator<Integer> iterator = counts.iterator();
	    	while(iterator.hasNext()) {
	    		depths.add(iterator.next());
	    	}
	    		
			return depths;
	    }
	    
	    public void print()
	    {
	        //tringBuilder s1 = new StringBuilder();
	        
	       // StringBuilder s2 = new StringBuilder();
	        //Iterating through our key HashSet to get our keys(depths)
	        Iterator<Integer> iterator = getDepths().iterator();
	        while(iterator.hasNext())
	        {
	        	Integer current = iterator.next();
	        	System.out.println("Depth:"+ current +" Frequency" + counts.get(current));
	        //s1.append("["+current+"=" + counts.get(current)+"]");
	        }
	        /*
	        for(String word: getWords()){
	            s1.append("["+word+"=" + counts.get(word)+"] ");
	        }
	         */       
	     
	       
	 //       System.out.println(s2.toString());
	        
	        System.out.println(counts.maxTreeDepth());
	        System.out.println(counts.meanTreeDepth());
	    }
}
