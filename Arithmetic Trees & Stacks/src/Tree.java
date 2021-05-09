import java.util.StringTokenizer;

public class Tree {
	private BiNode root;
	
	 // Inner Class BiNode
	private static class BiNode {
		public String item;
		public BiNode left;
		public BiNode right;
		
		BiNode (String item){ // leaf constructor
			this(item,null,null);
		}
		
		BiNode (String item , BiNode left, BiNode right)
		{
			this.item = item;
			this.left = left;
			this.right = right;
		}
		
		
	}
	 // main Constructor
	public Tree (BiNode root) {
		this.root = root;
	}
	// postfix Constructor
	Tree(String postfix) {
		this.root = construct(postfix);
	 }
	
	// Construct method to construct the tree from the postfix expression
	BiNode construct (String postfix){
		BiNode root;
	    StringTokenizer tokenized = new StringTokenizer(postfix);

        StackLL <BiNode> stack = new StackLL<BiNode>();

        while(tokenized.hasMoreTokens())
        {
            String s = tokenized.nextToken();

            try{
                Double d = Double.parseDouble(s);
                BiNode node = new BiNode (s);
                stack.push(node);

            }
            catch(Exception e)
            {
                BiNode N  = stack.pop();
                if(s.equals("+")| s.equals("-") || s.equals("*") || s.equals("/")|| s.equals("sqrt") || s.equals("^")){
                		
                	stack.push(new BiNode(s,stack.pop(),N));
                }
                else if (s.equals("sqrt") || s.equals("sin") || s.equals("exp") || s.equals("pi"))
                {
                	stack.push(new BiNode(s,null,N));
                }
                else {
                	System.out.println("Error : Not convertable to operator");
                return null; }

            }
        }
        if(stack.isEmpty())  {
        	System.out.println("Error: Empty Stack");
        return null;
        }
        else
        	return stack.pop();
        }	

	
        // My code of problem 4 - Postoder Traversal
	
		// Recursive private method 
		private void postOrderTraversal(BiNode n){
			System.out.println("Traverse Node" + n.item);
			if (n.left!=null) postOrderTraversal(n.left);
			if (n.right != null) postOrderTraversal(n.right);
			System.out.println(n.item + " ");
		}
		
		// public Method PostOrderTraversal
		public void postOrderTraversal()
		{
			if(root != null)
			postOrderTraversal(root);
			else
				System.out.println("Invalid Expression");
		}
	 // Code of my partner , traversal methods 

    private void inorderTraversal(BiNode node){
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        System.out.println(node.item + " ");
        inorderTraversal(node.right);

    }

    public void inorderTraversal()
    {
        if (root == null)
        {
            System.out.println("Invalid Expression");
            return;
        }

        inorderTraversal(root);
        System.out.println();
    }
    
    private String infixGenerator(BiNode node) {
        if (node == null) {
            return "";
        }

        if(node.item.equals("^") || node.item.equals("*") || node.item.equals("/") || node.item.equals("+") || node.item.equals("-")){
            return "( " + infixGenerator(node.left) + node.item + " " + infixGenerator(node.right) + ") ";
        }
        if(node.item.equals("sqrt") || node.item.equals("sin") || node.item.equals("exp")){
            return "( " + node.item + " " + infixGenerator(node.right) + ") ";
        }

        return node.item + " ";
    }

    public String infixGenerator(){
       if (root == null){
           return ("Invalid Expression");
       }

       return infixGenerator(root);
    }
	
	public static void main (String [] args)
	{
		Tree.BiNode three = new Tree.BiNode("3");
		BiNode four = new BiNode ("4");
		BiNode five = new BiNode ("5");
		BiNode plus = new BiNode ("+",four,three);
		BiNode root = new BiNode ("*",five,plus);
		Tree tree = new Tree (root);
		String example = "5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *";
		Tree postFixTree = new Tree(example);
		postFixTree.postOrderTraversal();
		// Testing the Tree constructor with example of lab 1 
		
	}
}
