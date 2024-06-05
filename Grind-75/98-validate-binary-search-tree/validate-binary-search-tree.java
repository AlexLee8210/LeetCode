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
        Stack<Integer> stack = new Stack<>();
        inOrder(root, stack);
        int prev = Integer.MAX_VALUE;
        if (stack.peek() == prev) {
            stack.pop();
        }
        while (!stack.isEmpty()) {
            int val = stack.pop();
            if (val >= prev) {
                return false;
            }
            prev = val;
        }
        return true;
    }

    private void inOrder(TreeNode node, Stack<Integer> stack) {
        if (node == null) return;
        inOrder(node.left, stack);
        stack.push(node.val);
        inOrder(node.right, stack);
    }
}