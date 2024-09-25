package pa3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    // Add tests for the Queue class here

    @Test
    public void testEnqueue() {
        Queue queue = new Queue();
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        queue.enqueue(node1);
        queue.enqueue(node2);
        assertEquals(node1, queue.dequeue());
    }

    @Test
    public void testDequeue() {
        Queue queue = new Queue();
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        queue.enqueue(node1);
        queue.enqueue(node2);
        assertEquals(node1, queue.dequeue());
        assertEquals(node2, queue.dequeue());
    }

    @Test
    public void testIsEmpty() {
        Queue queue = new Queue();
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        queue.enqueue(node1);
        queue.enqueue(node2);
        assertEquals(node1, queue.dequeue());
        assertEquals(node2, queue.dequeue());
        assertEquals(queue.isEmpty(), true);
    }





}
