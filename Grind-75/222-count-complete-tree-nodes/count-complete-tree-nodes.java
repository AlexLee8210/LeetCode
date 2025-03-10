/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();
        if (root == null) return 0;

        int nodes = 0;
        int nodesInLevel = 1;
        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            if (nodesInLevel != size) return nodes + size;
            for (int i = 0; i < size; ++i) {
                TreeNode node = dq.poll();
                if (node.left != null) dq.offer(node.left);
                if (node.right != null) dq.offer(node.right);
            }

            nodes += nodesInLevel;
            nodesInLevel *= 2;
        }

        return nodes;
    }
}