package pa3;

import javax.swing.tree.TreeNode;

/**
 * A binary tree class that stores integers.
 * 
 * The integers are stored in the tree in the order they are added.
 * 
 * The integers are stored from top to bottom by level i.e. node is added to a new level only when the current level is full.
 * Within each level, the integers are stored from left to right.
 * In other words, the tree is always Balanced: depth of the left and right subtrees of every node differ by at most 1.
 * 
 */
public class BinaryTree {

    private Node root;
    /**
     * Constructs an empty binary tree.
     */
    public BinaryTree() {
        this.root = null;
    }

    /**
     * Returns the level order traversal of the tree.
     * 
     * The level order traversal of a tree is the traversal of the tree by levels.
     * 
     * USE THE QUEUE from the pa3 package to implement this method. 
     * You are not allowed to use the built-in Java Queue.
     * 
     * Use the private helper method levelOrderTraversalHelper to implement this method.
     * 
     * @return the level order traversal of the tree.
     */
    public String levelOrderTraversal() {
        String str = "";
        Node current = this.root;
        return levelOrderTraversalHelper(current, str);
    }

    /** 
     * Helper method for levelOrderTraversal that takes a node as an argument.
     */
    private String levelOrderTraversalHelper(Node node, String result) {
        if (node == null)
            return "";
        Queue queue = new Queue();
        queue.enqueue(node);
        while (queue.isEmpty() != true){
            Node current = queue.dequeue();
            result = result + current.value + " ";
            if (current.left != null){
                queue.enqueue(current.left);}
            if (current.right != null){
                queue.enqueue(current.right);}
        }
        return result;
    }

    /**
     * Adds a value to the tree.
     * 
     * The value is added to the tree in the order it is added.
     * Use a variant of the level order traversal to add the value to the tree.
     * First time you find a null child, add the new node there.
     * 
     * @param value the value to add to the tree.
     */
    public void add(int value) {
        Node newnode = new Node(value);
        if (this.root == null){
            this.root = newnode;
            return;
        }
        Queue queue = new Queue();
        queue.enqueue(this.root);
        while (queue.isEmpty() != true){
            Node current =  queue.dequeue();
            if (current.left == null){
                current.left = newnode;
                return;
            }
           else{
            queue.enqueue(current.left);
            }
           if (current.right == null){
                current.right = newnode;
                return;
            }
           else{
            queue.enqueue(current.right);
            }
        }
    }

    /** 
     * Inverts the tree: left and right children of each node are swapped.
     * 
     * For example, the tree:
     * 
     *     1
     *    / \
     *   2   3
     * 
     * is inverted to:
     * 
     *    1
     *   / \
     *  3   2
     * 
     * This inversion is done for all nodes in the tree.
     * 
     */
    public void invert() {
        if (this.root == null) 
            return;
        Queue queue = new Queue();
        queue.enqueue(this.root);
        while (queue.isEmpty() != true){
            Node current = queue.dequeue();
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null){
                queue.enqueue(current.left); 
            }
            if (current.right != null){
                queue.enqueue(current.right);
            }
        }
       
    }

    public int getHeight() {
        return getHeightHelper(this.root);
    }

    /** Counts the height of the tree 
     *  Height is defined as the number of edges in the longest path from the root to a leaf node. 
     */
    private int getHeightHelper(Node node) {
        if (node == null){
            return -1;
        }
        int leftheight = getHeightHelper(node.left);
        int rightheight = getHeightHelper(node.right);
        if (leftheight > rightheight){
            return leftheight + 1;
        }
        else{
            return rightheight + 1;}
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        System.out.println(tree.levelOrderTraversal()); // Should print 1 2 3 4 5 6 7

        tree.invert();

        System.out.println(tree.levelOrderTraversal()); // Should print 1 3 2 7 6 5 4

        System.out.println(tree.getHeight()); // Should print 2
    }
}
