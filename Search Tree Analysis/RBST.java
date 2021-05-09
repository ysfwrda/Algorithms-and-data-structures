import java.util.Iterator;
import java.util.Stack;


public class RBST<Key extends Comparable<Key>, Value> implements ST<Key,Value>,Iterable<Key>
{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    
    class Node{
        Key key;
        Value val;
        Node left, right;
        boolean color;
        Node(Key key, Value val, boolean color)
        {
            this.key = key;
            this.val = val;
            this.color = color;
        }
		public Key getKey() {
			// TODO Auto-generated method stub
			return this.key;
		}
		public RBST.Node getLeft() {
			// TODO Auto-generated method stub
			return this.left;
		}
		public RBST.Node getRight() {
			// TODO Auto-generated method stub
			return this.right;
		}
    }
    /*
    public static void main (String[] args)
    {
    	// Creating a RBST for our word sequence
    RBST<Integer, String> example = new RBST<Integer,String> ();
    //Inserting the word sequence
     example.put(1, "One");
     example.put(2, "more");
     example.put(3, "nice");
     example.put(4, "example");
     // Iterating through the RBST to print it
     Iterator<Integer> exampleIterator = example.iterator(); // Iterator
     
     while(exampleIterator.hasNext()) {
    	 System.out.println(example.get(exampleIterator.next()));
     } //HashSet to Store the Values 
     }
     */
     
    

    public Iterator<Key> iterator() {
        return new RBSTIterator();
    }
      // BST Iterator Class
    private class RBSTIterator implements Iterator<Key> {
    
    private Stack<Node> stack = new Stack<>();
    
    private void pushLeft(Node x) {
      while (x != null) {
        stack.push(x);
        x = x.left;
      }
    }
    public RBSTIterator() {
      pushLeft(root);
    }
    
    public boolean hasNext() {
      return !stack.isEmpty();
    }
    
    public Key next() {
      Node x = stack.pop();
      pushLeft(x.right);
      return x.key;
    }
    }
    
    public void put(Key key, Value val) {
    // TODO Auto-generated method stub
    root = put(root, key, val);
    root.color = BLACK;
    }
    
    private Node put(Node h, Key key, Value val) {
    	if (h == null)
    		return new Node(key, val, RED);
    		if (isRed(h.left))
    		if (isRed(h.left.left))
    		h = splitFourNode(h);
    		int cmp = key.compareTo(h.key);
    		if (cmp == 0) h.val = val;
    		else if (cmp < 0)
    		h.left = put(h.left, key, val);
    		else
    		h.right = put(h.right, key, val);
    		if (isRed(h.right))
    		h = leanLeft(h);
    		return h;
    		}    
    
    private boolean isRed(Node x)
    {
        if (x == null) return false;
        return (x.color == RED);
    }
    
    private Node splitFourNode(Node x)
    {
        Node y = rotateRight(x);
        y.left.color = BLACK;
        return y;
    }

    private Node leanLeft(Node x)
    {
        Node y = rotateLeft(x);
        y.color = y.left.color;
        y.left.color = RED;
        return y;
    }
    
    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    private Node rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }
    

    public Value get(Key key)
    {
        Node x = root;
        while (x != null)
        {
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x.val;
        else if (cmp < 0) x = x.left;
        else if (cmp > 0) x = x.right;
        }
        return null;
    }

    public boolean contains(Key key) {
    // TODO Auto-generated method stub
    return get(key) != null;
    }

    public void remove(Key key) {
    // TODO Auto-generated method stub
  }

	public RBST.Node getRoot() {
		// TODO Auto-generated method stub
		return root;
	}
}


  
