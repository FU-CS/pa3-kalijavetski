package pa3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    // Add tests for the BinaryTree class here

    @Test
    public void testLevelOrderTraversal() {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        assertEquals("1 2 3 4 5 6 7 ", tree.levelOrderTraversal());
    }
    @Test
    public void testEmptyTree() {
        BinaryTree tree = new BinaryTree();
        assertEquals("", tree.levelOrderTraversal());
    }
    @Test
    public void testOutofOrder() {
        BinaryTree tree = new BinaryTree();
        tree.add(2);
        tree.add(4);
        tree.add(3);
        tree.add(8);
        tree.add(5);
        tree.add(1);
        tree.add(7);
        assertEquals("2 4 3 8 5 1 7 ", tree.levelOrderTraversal());
    }
    @Test
    public void invert() {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.invert();
        assertEquals("1 3 2 7 6 5 4 ", tree.levelOrderTraversal());
    }

    @Test
    public void getHeight() {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        assertEquals(2, tree.getHeight());
    }
    @Test
    public void invertempty() {
        BinaryTree tree = new BinaryTree();
        tree.invert();
        assertEquals("", tree.levelOrderTraversal());
    }
    @Test
    public void getHeightempty() {
        BinaryTree tree = new BinaryTree();
        assertEquals(-1, tree.getHeight());
    }
}
