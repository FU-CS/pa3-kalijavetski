
package pa3;

/**
 * A queue of nodes.
 */
public class Queue {
    Node[] queue;
    int i;
    /** 
     * Constructs an empty queue.
     */
    public Queue() {
       this.queue = new Node[20];
       i = 0;

    }

    /**
     * Adds a node to the queue.
     * @param node
     */
    public void enqueue(Node node) {
        this.queue[i] = node;
        i += 1;
    }

    /**
     * Removes and returns the node at the front of the queue.
     * @return the node at the front of the queue.
     */
    public Node dequeue() {
        if (isEmpty()){
            return null;
        }
        Node firstval= this.queue[0];
        i -= 1;
        for (int j = 0; j <= i; j++){
            this.queue[j] = this.queue[j+1];
        }
        return firstval;
        
    }

    /**
     * Returns true if the queue is empty.
     * @return true if the queue is empty.
     */
    public boolean isEmpty() {
        boolean empty = false;
        if (this.queue[0] == null){
             empty = true;
        }
        return empty;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        Node node1 = new Node(4);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        queue.enqueue(node1);
        queue.enqueue(node2);
        queue.enqueue(node3);
        System.out.println(queue.dequeue().value); // Should print 4
        System.out.println(queue.dequeue().value);
        System.out.println(queue.dequeue().value);
    }
    
}
