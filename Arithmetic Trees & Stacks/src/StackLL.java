public class StackLL <T> {
    private Node head;
    private int size;

    private class Node {
        T data;
        Node next;

        //constructors for Node class
        public Node() {
            data = null;
            next = null;
        }

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    public StackLL(){
        head = new Node();
        size = 0;
    }

    public boolean isEmpty(){
        return (head.next == null);
    }

    public void push(T data){
        size += 1;
        Node newNode = new Node(data);  //creating new node with given data
        newNode.next = this.head.next;
        this.head.next = newNode;
    }

    public T pop() {
        T data = null;
        if (!isEmpty()) {
            size -= 1;
            T x = null;
            Node temp = this.head.next;
            if(temp != null){
                x = temp.data;
                this.head.next = temp.next;
                //System.out.println("Element popped!");
            }
            return x;

        } else {
            System.out.println("Stack underflow ");
        }
        return data;
    }

    public T peek(){
        // check for empty stack
        if (!isEmpty()) {
            return head.next.data;
        }
        else {
            //System.out.println("Stack is empty");
            return null;
        }
    }

    public void printStack(){
        if(this.head.next == null){
            System.out.println("Stack is empty");
        } else {
            Node currentNode = this.head.next;
            System.out.print("Linked List : ");

            while(currentNode != null){
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }

            System.out.println();
        }
    }

    public int getSize(){
        return this.size;
    }

}

