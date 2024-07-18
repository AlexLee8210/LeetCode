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
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestHelper(root, k, new int[1]);
    }

    private int kthSmallestHelper(TreeNode node, int k, int[] index) {
        if (node == null) {
            return 0;
        }
        int res = kthSmallestHelper(node.left, k, index);
        if (res > 0) return res;
        index[0]++;
        if (index[0] == k) {
            return node.val;
        }
        return kthSmallestHelper(node.right, k, index);
    }
}