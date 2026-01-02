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
        return isValidBSTHelper(root)[0] == 1;
    }

    private long[] isValidBSTHelper(TreeNode node) {
        if (node == null) return new long[]{1, Long.MAX_VALUE, Long.MIN_VALUE};
        long[] left = isValidBSTHelper(node.left);
        if (left[0] == 0) return left;
        long[] right = isValidBSTHelper(node.right);
        if (right[0] == 0) return right;
        
        boolean valid = node.val > left[2] && node.val < right[1];
        long min = Math.min(node.val, left[1]);
        long max = Math.max(node.val, right[2]);
        return new long[]{valid ? 1 : 0, min, max};
    }
}