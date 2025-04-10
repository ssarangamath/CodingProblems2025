package LowestCommonAncestor;

import java.util.Objects;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;

        return lca(root, p, q);
    }

    private TreeNode lca(TreeNode root, TreeNode p , TreeNode q){
        if(root == null)
            return null;

        if(Objects.equals(root, p) || Objects.equals(root, q)){
            return root;
        }

        TreeNode left = lca(root.left, p , q);
        TreeNode right = lca(root.right, p, q);

        if(left == null)
            return right;

        if(right == null)
            return left;

        return root;
    }


    static class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
