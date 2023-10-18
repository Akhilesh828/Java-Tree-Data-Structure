/*
Recursion 

- In this code, we define a TreeNode class to represent the nodes of the binary tree. 
- The findHeight method takes the root of the binary tree as an argument and recursively calculates the height of the tree. 
- The height of an empty tree is defined as -1, and the height of a non-empty tree is the maximum of the 
- heights of its left and right subtrees plus 1.

The main method demonstrates how to create a binary tree and find its height. You can modify the binary tree structure in the main method to test with different trees.
*/

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Tree {
    /* -------------------------------------------------------------------------- */
    public static int findHeight(TreeNode root) {
        if (root == null) {
            return 0; // Height of an empty tree is 0.
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    /* -------------------------------------------------------------------------- */

    public static void main(String[] args) {
        // Create a binary tree.
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int height = findHeight(root);
        System.out.println("Height of the binary tree: " + height);
    }
}
