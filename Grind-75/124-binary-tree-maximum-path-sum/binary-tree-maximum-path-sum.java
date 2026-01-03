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
    public int maxPathSum(TreeNode root) {
        int[] maxPath = new int[]{Integer.MIN_VALUE};
        System.out.println(maxPathHelper(root, maxPath));
        return maxPath[0];
    }

    private int maxPathHelper(TreeNode root, int[] maxPath) {
        if (root == null) return 0;
        int left = maxPathHelper(root.left, maxPath);
        int right = maxPathHelper(root.right, maxPath);
        
        int curpath = left + right + root.val;
        maxPath[0] = Math.max(maxPath[0], curpath);
        return Math.max(0, Math.max(left, right) + root.val);
    }
}