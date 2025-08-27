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
        Stack<TreeNode> stack = new Stack<>();
        inOrder(root, stack);
        TreeNode prev = stack.pop();
        boolean valid = true;
        while(!stack.isEmpty() && valid) {
            TreeNode cur = stack.pop();
            valid &= prev.val > cur.val;
            prev = cur;
        }
        return valid;
    }

    private void inOrder(TreeNode root, Stack<TreeNode> stack) {
        if (root == null) return;
        inOrder(root.left, stack);
        stack.push(root);
        inOrder(root.right, stack);
    }
}