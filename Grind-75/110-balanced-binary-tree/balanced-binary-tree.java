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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int lh = height(root.left);
        int rh = height(root.right);
        boolean valid = Math.abs(rh - lh) <= 1;
        return valid && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}