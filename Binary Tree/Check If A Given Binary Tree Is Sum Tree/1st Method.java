// A binary tree is called a "Sum Tree" if the value of each node is equal to the sum of the values of its left and right subtrees. 
// To check if a given binary tree is a Sum Tree, you can use a recursive approach. 

/*  
1st Method 

Explanation 

1. We define a `TreeNode` class to represent the nodes of the binary tree. Each node contains a value and references to its left and right children.
2. In the `SumTreeChecker` class, we create a method `isSumTree` that checks if a binary tree is a Sum Tree.
3. The base case checks if the `root` is `null` or if it's a leaf node (both left and right children are `null`). In such cases, the tree is considered a Sum Tree by default.
4. In the recursive case, we recursively check if the left and right subtrees are also Sum Trees.
5. If both the left and right subtrees are Sum Trees and the current node's value is equal to the sum of its left and right subtree values, then it's a Sum Tree.
6. We use a helper function `sum` to calculate the sum of a binary tree by recursively adding the values of all nodes.
7. In the `main` method, we create a sample binary tree and call `isSumTree` to check if it's a Sum Tree. We print the result.

The code follows a recursive approach to check if the binary tree is a Sum Tree, ensuring that the sum property holds for each node.
*/
/* -------------------------------------------------------------------------- */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SumTreeChecker {
    public boolean isSumTree(TreeNode root) {
        // Base case: If the node is null or it's a leaf node, it is a Sum Tree by default.
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        // Recursively check if the left and right subtrees are Sum Trees.
        boolean leftSumTree = isSumTree(root.left);
        boolean rightSumTree = isSumTree(root.right);

        // If both subtrees are Sum Trees and the current node's value
        // is equal to the sum of the left and right subtree values, then it's a Sum Tree.
        if (leftSumTree && rightSumTree && (root.val == sum(root.left) + sum(root.right))) {
            return true;
        }

        return false; // If any of the conditions fail, it's not a Sum Tree.
    }

    // Helper function to calculate the sum of a binary tree.
    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sum(node.left) + sum(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);

        SumTreeChecker treeChecker = new SumTreeChecker();
        boolean isSumTree = treeChecker.isSumTree(root);

        System.out.println("Is the tree a Sum Tree? " + isSumTree);
    }
}

/* -------------------------------------------------------------------------- */

// **Time Complexity:** O(n), where 'n' is the number of nodes in the binary tree.

// **Space Complexity:** O(h), where 'h' is the height of the binary tree. In the worst case, when the tree is skewed, the space complexity can be O(n), but for balanced trees, it is typically O(log n).
