import java.util.Iterator;
import java.util.Stack;

public class BST <Key extends Comparable<Key>, Value> implements Iterable<Key>, ST<Key, Value> {
  
  private Node root; // root of BST
  int nodes, depth, max;
  
  public class Node {
    private Key key;
    private Value val;
    private Node left, right;
    
    public Node(Key key, Value val) {
      this.key = key;
      this.val = val;
    }

	public Key getKey() {
		return key;
	}

	public BST.Node getLeft() {
		// TODO Auto-generated method stub
		return this.left;
	}

	public Node getRight() {
		return right;
	}
	
  }
  // get the depth of the current node

  
  public void put(Key key, Value val) {
    root = put(root, key, val);
  }
  
  private Node put(Node x, Key key, Value val) {
    if (x == null) return new Node(key, val);
    int cmp = key.compareTo(x.getKey());
    if (cmp == 0) x.val = val;
    else if (cmp < 0) x.left = put(x.left, key, val);
    else x.right = put(x.getRight(), key, val);
    return x;
  }
  
  public Value get(Key key) {
    Node x = root;
    while (x != null) {
      int cmp = key.compareTo(x.getKey());
      if (cmp == 0) return x.val;
      else if (cmp < 0) x = x.left;
      else x = x.getRight();
    }
    return null;
  }
  
  public Iterator<Key> iterator() {
    return new BSTIterator();
  }
  
  private class BSTIterator implements Iterator<Key> {
    
    private Stack<Node> stack = new Stack<>();
    
    private void pushLeft(Node x) {
      while (x != null) {
        stack.push(x);
        x = x.left;
      }
    }
    public BSTIterator() {
      pushLeft(root);
    }
    public boolean hasNext() {
      return !stack.isEmpty();
    }
    public Key next() {
      Node x = stack.pop();
      pushLeft(x.getRight());
      return x.getKey();
    }
  }
    
  public void remove(Key key){
        if(contains(key)){
            put(key, null);
        }
    }
    
  public boolean contains(Key key){
        return get(key) != null;
  }

  private void traversal(Node x, int treeDepth){
      if (x == null) return;
      
      this.depth = this.depth + treeDepth-1;
      nodes = nodes+1;
      
      if(treeDepth > max){
          max = treeDepth;
      }

      traversal(x.left, treeDepth+1);
      traversal(x.getRight(), treeDepth+1);
  }
   
  public int maxTreeDepth(){
      this.nodes = 0;
      this.depth = 0;
      this.max = 0;
      
      traversal(root, max+1);
      
      return max;
  }
  
	/*
	 * public void calcluateDepths(Key key) { //we traverse through our tree in each
	 * node, Node x = root; Integer curDepth = 0; while (x != null) { int cmp =
	 * key.compareTo(x.getKey()); // searches for the key in our tree if (cmp == 0)
	 * // if already available { put(key, (Value) curDepth); // overwrites the value
	 * of the depth in our word BST with the currentDepth // SearchResult result =
	 * new SearchResult(x.value, curDepth); //returns new SearchResult with the
	 * value and the depth // return result; // also possible: // return new
	 * SearchResult(x.value, curDepth); } else if (cmp <= 0) x = x.left; else if
	 * (cmp > 0) x = x.getRight(); ++curDepth; //anyway increase the depth by one ,
	 * because we moved to a child(right or left) }
	 */
 
  

  public double meanTreeDepth(){
      maxTreeDepth();
      return (double)this.depth/this.nodes;
  }
  
  public Node getRoot()
  {
	  return this.root;
  }
  

}