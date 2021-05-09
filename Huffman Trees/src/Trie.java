import java.util.HashSet;


public class Trie {
	// fields
		private int [] freq;
		private MinPQ<Node> pq;
		private HashSet <Character> charSet;
		private Node root;
		private String output;
		private int bits;
	
	// Inner class Node. Source: Sedgewick Slidesets
	private  class Node implements Comparable<Node>
	{
	 private  char ch; // used only for leaf nodes
	 private  int freq; // used only for compress	
	 private  Node left, right;

	 public Node(char ch, int freq, Node left, Node right)
	 {
	 this.ch = ch;
	 this.freq = freq;
	 this.left = left;
	 this.right = right;
	 }

	 public boolean isLeaf()
	 { return left == null && right == null; }

	 public int compareTo(Node that)
	 { return this.freq - that.freq; }
	}
	
	
	
	public Trie(String input) {
		charSet = new HashSet<Character>();
		tabulateFrequencies(input);
		initializePQ();
		fillCharSet(input);
		printFrequencies(input);
		mergeTrees();
		output ="";
		
	}
	
	//Tabulate the frequencies in the array
	private void tabulateFrequencies(String input) {
			freq = new int[128];
			for (int i = 0; i < input.length(); i++)
			{ freq[input.charAt(i)]++; }
	}
	
	private void fillCharSet(String input) {
		char[] charArray =  input.toCharArray();
		for(char ch: charArray) {
			charSet.add(ch);
		}
	}
	//initialize the priority Queue
	private void initializePQ(){
		pq = new MinPQ<Node>(); 
		for (int i = 0; i < 128; i++)
			if (freq[i] > 0)
			pq.insert(new Node((char) i, freq[i], null, null));
	}
	
	// merge the trees
	private void mergeTrees() {
		while (pq.size() > 1)
		{
		Node x = pq.delMin();
		Node y = pq.delMin();
		Node parent = new Node('*', x.freq + y.freq, x, y);
		pq.insert(parent);
		}
		root = pq.delMin();
	}
	//Print the frequencies
	private void printFrequencies(String input) {
		//get the characters from the character hashset
		for(char ch : charSet) {
			System.out.println("The character is " +  ch + " The frequency is " + freq[ch]);
		}
	}
	public String encode(Node x) {// the method encode to encode the generated Tree T1
		
		if(x.isLeaf())
		{
		output+=(x.ch);
		}
		else
		output += "*";
		if(x.left!=null)
		{
		encode(x.left);
		}
		if(x.right!=null)
		{
		encode(x.right);

		}
		return output;
		}
	
	public static void main (String[] args) {
		String s1 = "she_sells_sea_shells_by_the_seashore";
		String s2 = "selly_sells_her_shorts_by_the_seattle_store";
		Trie trie = new Trie(s1);
		trie.encode(trie.root);
		System.out.println(trie.output);
		Trie trie2 = new Trie(s2);
		trie2.encode(trie2.root);
		System.out.println(trie2.output);
		
	}
}
