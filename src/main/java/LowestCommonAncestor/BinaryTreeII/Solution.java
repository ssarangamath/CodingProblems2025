package LowestCommonAncestor.BinaryTreeII;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> nodes = new HashSet();
        while (p != null){
            nodes.add(p);
            p = p.parent;
        }

        while (q!= null){
            if(nodes.contains(q)){
                return q;
            }
            q = q.parent;
        }
        return null;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
