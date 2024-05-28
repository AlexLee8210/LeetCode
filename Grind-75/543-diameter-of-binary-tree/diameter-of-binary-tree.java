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
        int[] ans = new int[1];
        height(root, ans);
        return ans[0];
    }

    /* Returns height, sets diameter in diam */
    private int height(TreeNode node, int[] diam) {
        if (node == null) return 0;
        int lHeight = height(node.left, diam);
        int rHeight = height(node.right, diam);
        int diameter = lHeight + rHeight;
        diam[0] = Math.max(diameter, diam[0]);

        int height = Math.max(lHeight, rHeight) + 1;
        return height;
    }
}