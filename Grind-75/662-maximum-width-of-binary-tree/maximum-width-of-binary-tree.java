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
        return helper(root, 0, 1, new HashMap<>());
    }

    private int helper(TreeNode node, int level, int index, HashMap<Integer, Integer> map) {
        if (node == null) return 0;
        if (!map.containsKey(level)) {
            map.put(level, index);
        }
        int cur = index - map.get(level) + 1;
        int left = helper(node.left, level + 1, index * 2 - 1, map);
        int right = helper(node.right, level + 1, index * 2, map);
        return Math.max(cur, Math.max(left, right));
    }
    
}