/* 1st method - Recursion 

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

/*
**Time Complexity:** O(N)
- The time complexity of this method is O(N), where N is the number of nodes in the binary tree.
- In the worst case, the method visits all nodes in the tree once.
- The reason for this time complexity is that each node is visited once, and for each node, we perform a constant amount of work (comparing left and right subtree heights and performing the `Math.max` operation).

**Space Complexity:** O(log N)
- The space complexity is determined by the maximum depth of the recursive call stack.
- In the worst case, for a completely unbalanced tree (skewed tree), the space complexity is O(N), where N is the number of nodes.
- For a balanced tree, the space complexity is O(log N) because the maximum depth of the recursive call stack is limited by the height of the tree.

In summary, the time complexity is O(N), and the space complexity varies from O(log N) for balanced trees to O(N) for completely unbalanced trees. The method is efficient for balanced trees but may have performance issues for highly unbalanced trees due to the large call stack space required.

*/