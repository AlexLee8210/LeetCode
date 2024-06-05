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
        return isValidHelper(root, Integer.MAX_VALUE, false, Integer.MIN_VALUE, false);
    }

    private boolean isValidHelper(TreeNode node,int lt, boolean ltSet, int gt, boolean gtSet) {
        if (node.left == null && node.right == null) {
            return true;
        } else if (node.right == null) {
            lt = Math.min(node.val, lt);
            boolean valid = node.left.val < lt && (!gtSet || node.left.val > gt);
            return valid && isValidHelper(node.left, lt, true, gt, gtSet);
        } else if (node.left == null) {
            gt = Math.max(node.val, gt);
            boolean valid = node.right.val > gt && (!ltSet || node.right.val < lt);
            return valid && isValidHelper(node.right, lt, ltSet, gt, true);
        }
        int newLt = Math.min(node.val, lt);
        int newGt = Math.max(node.val, gt);
        // System.out.println("At " + node.val + ", " + node.left " > " + newGTt)
        boolean valid = node.left.val < newLt && (!gtSet || node.left.val > gt);
        valid = valid && (!ltSet || node.right.val < lt) && node.right.val > newGt;
        return valid && isValidHelper(node.right, lt, ltSet, newGt, true) && isValidHelper(node.left, newLt, true, gt, gtSet);
    }
}