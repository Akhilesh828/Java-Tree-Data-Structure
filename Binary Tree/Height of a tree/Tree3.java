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
