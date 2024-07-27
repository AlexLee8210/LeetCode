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
    public int widthOfBinaryTree(TreeNode root) {
        ArrayList<Integer> levels = new ArrayList<>();
        return helper(root, 0, 1, levels);
    }

    private int helper(TreeNode node, int level, int index, ArrayList<Integer> levels) {
        if (node == null) return 0;
        if (levels.size() <= level) {
            levels.add(index);
        }
        int cur = index - levels.get(level) + 1;
        int left = helper(node.left, level + 1, index * 2 - 1, levels);
        int right = helper(node.right, level + 1, index * 2, levels);
        return Math.max(cur, Math.max(left, right));
    }
    
}