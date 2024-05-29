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
    public TreeNode sortedArrayToBST(int[] nums) {
        int l = 0, r = nums.length - 1;
        return addToTree(l, r, nums);
    }

    private TreeNode addToTree(int l, int r, int[] nums) {
        if (l > r) return null;
        int m = l + (r - l) / 2;
        TreeNode newNode = new TreeNode(nums[m]);
        newNode.left = addToTree(l, m - 1, nums);
        newNode.right = addToTree(m + 1, r, nums);
        return newNode;
    }
}