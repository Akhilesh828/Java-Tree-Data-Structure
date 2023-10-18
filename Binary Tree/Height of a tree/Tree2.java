// 2nd Method - without Recursion

import java.util.LinkedList;
import java.util.Queue;

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

public class Tree2 {
    /* -------------------------------------------------------------------------- */
    public static int findHeight(TreeNode root) {
        if (root == null) {
            return 0; 
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                TreeNode temp = queue.poll();

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }

                
            }
            height++;
        }
        return height;
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
- The time complexity is O(N), where N is the number of nodes in the binary tree.
- In the worst case, the method visits all nodes in the tree once during the level-order traversal.
- The time complexity is linear with respect to the number of nodes in the tree.

**Space Complexity:** O(N)
- The space complexity is determined by the maximum number of nodes at any level of the tree.
- In the worst case, for a completely unbalanced tree (skewed tree), the space complexity is O(N), where N is the number of nodes.
- For a balanced tree, the space complexity is O(M), where M is the maximum number of nodes at any level (the widest level).

In summary, the time complexity is O(N), and the space complexity varies from O(N) for completely unbalanced trees to O(M) for balanced trees, where M is typically much smaller than N. This method is efficient and has a smaller space requirement compared to the recursive method when dealing with balanced and unbalanced trees.
 */