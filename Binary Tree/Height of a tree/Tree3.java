//3rd Method 

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

public class Tree3 {
    /* -------------------------------------------------------------------------- */
    public static int findHeight(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        int height = 0;

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if(temp == null) { height++; };

            if(temp != null){
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            
            }else if(!queue.isEmpty()){
                queue.add(null);
            }

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
- The time complexity of this method is O(N), where N is the number of nodes in the binary tree.
- In the worst case, the method visits all nodes in the tree exactly once.
- The reason for this time complexity is that each node is visited once, and we perform a constant amount of work for each node.

**Space Complexity:** O(N)
- The space complexity is determined by the maximum number of nodes that can be present in the queue at any given time.
- In the worst case, when the binary tree is completely unbalanced (a skewed tree), the space complexity is O(N), where N is the number of nodes.
- For a balanced tree, the space complexity is O(w), where w is the maximum width of the tree at any level, which is typically less than N.
- The use of the queue helps manage the space efficiently compared to the recursive approach.

In summary, the time complexity is O(N), and the space complexity varies from O(N) for completely unbalanced trees to O(w) for balanced trees, 
where w is the maximum width of the tree at any level. The method is efficient for most types of binary trees and avoids the potential call 
stack space issues associated with recursive solutions for deeply unbalanced trees.
 */