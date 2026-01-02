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

        int leftd = diameterOfBinaryTree(root.left);
        int rightd = diameterOfBinaryTree(root.right);
        int curd = height(root.left) + height(root.right);
        return Math.max(curd, Math.max(leftd, rightd));
    }

    Map<TreeNode, Integer> heights = new HashMap<>();
    private int height(TreeNode n) {
        if (n == null) return 0;
        if (heights.containsKey(n)) return heights.get(n);

        int h = Math.max(height(n.left), height(n.right)) + 1;
        heights.put(n, h);
        return h;
    }
}