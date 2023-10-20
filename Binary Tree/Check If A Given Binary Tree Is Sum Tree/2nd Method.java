// 2nd Method 

// This code is for checking if a given binary tree is a Sum Tree. A Sum Tree is a binary tree in which the value of each node is equal to the sum of the values of its left and right subtrees. Here's the code with comments to explain each part:
/*

Explanation 

1. The code defines a `Node` class to represent nodes in the binary tree, each containing a value (`data`) and references to their left and right children.
2. In the `Main` class, we create a method `isSumTree` to check if a given binary tree is a Sum Tree.
3. The base case checks if the `root` is null (empty tree). In this case, the function returns 0 because an empty tree is trivially a Sum Tree.
4. The special case checks if the `root` is a leaf node (both left and right children are null). If so, the function returns the value of the leaf node as the sum of its subtrees is itself.
5. In the recursive case, we calculate the sums of values in the left and right subtrees by making recursive calls to `isSumTree` for those subtrees.
6. The code then checks if the current node's value is equal to the sum of values in its left and right subtrees. If this condition is met and both the left and right subtrees are not marked as not Sum Trees (sentinel value `Integer.MIN_VALUE`), it returns twice the value of the current node, indicating it's a Sum Tree.
7. If the current node is not a Sum Tree, it returns `Integer.MIN_VALUE` as a sentinel value.
8. In the `main` method, a sample binary tree is created, and the `isSumTree` function is called to check if it's a Sum Tree. The result is printed based on the returned value.

This code uses a recursive approach to check whether the binary tree is a Sum Tree, making sure that the sum property holds for each node in the tree.
*/

/* -------------------------------------------------------------------------- */
class Node {
    int data;
    Node left = null, right = null;

    Node(int data) {
        this.data = data;
    }
}

class Main {
    // Recursive function to check if a given binary tree is a sum tree or not
    public static int isSumTree(Node root) {
        // Base case: empty tree
        if (root == null) {
            return 0;
        }

        // Special case: leaf node
        if (root.left == null && root.right == null) {
            return root.data;
        }

        // Recursively calculate the sum of values in the left and right subtrees
        int left = isSumTree(root.left);
        int right = isSumTree(root.right);

        // Check if the current node's value is equal to the sum of left and right subtrees
        if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE &&
                root.data == left + right) {
            // If the current node is a Sum Tree, return twice its value
            return 2 * root.data;
        }

        // If the current node is not a Sum Tree, return a sentinel value (Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(2);

        int result = isSumTree(root);

        if (result != Integer.MIN_VALUE) {
            System.out.println("The tree is a Sum Tree.");
        } else {
            System.out.println("The tree is not a Sum Tree.");
        }
    }
}
/* -------------------------------------------------------------------------- */

// **Time Complexity:** O(n), where 'n' is the number of nodes in the binary tree.

// **Space Complexity:** O(h), where 'h' is the height of the binary tree. In the worst case, when the tree is skewed, the space complexity can be O(n), but for balanced trees, it is typically O(log n).