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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] diam = new int[]{0};
        height(root, diam);
        return diam[0];
    }

    private int height(TreeNode n, int[] diam) {
        if (n == null) return 0;

        int lh = height(n.left, diam);
        int rh = height(n.right, diam);
        diam[0] = Math.max(diam[0], lh + rh);
        return Math.max(lh, rh) + 1;
    }
}