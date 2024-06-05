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
    public boolean isValidBST(TreeNode root) {
        long[] prev = new long[]{Long.MIN_VALUE};
        return inOrder(root, prev);
    }

    private boolean inOrder(TreeNode node, long[] prev) {
        if (node == null) return true;
        if (!inOrder(node.left, prev)) return false;
        if (node.val <= prev[0]) return false;
        prev[0] = node.val;
        return inOrder(node.right, prev);
    }
}