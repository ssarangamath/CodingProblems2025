package CompleteBinaryTreeInsertor;

import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter {
    private TreeNode root;
    private Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();

        // Level order traversal to populate the queue with incomplete nodes
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);

        while (!bfs.isEmpty()) {
            TreeNode node = bfs.poll();

            if (node.left != null) bfs.offer(node.left);
            if (node.right != null) bfs.offer(node.right);

            if (node.left == null || node.right == null) {
                queue.offer(node);
            }
        }
    }

    public int insert(int v) {
        TreeNode parent = queue.peek();
        TreeNode newNode = new TreeNode(v);

        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
            queue.poll(); // Remove node after both children are filled
        }

        queue.offer(newNode); // New node might receive children in the future
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
