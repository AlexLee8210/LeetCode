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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, targetSum, 0, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode node, List<List<Integer>> res, int target, int sum, List<Integer> cur) {
        if (node == null) return;
        cur.add(node.val);
        sum += node.val;
        if (sum == target && node.left == null && node.right == null) {
            res.add(new ArrayList<>(cur));
        }
        helper(node.left, res, target, sum, cur);
        helper(node.right, res, target, sum, cur);
        cur.remove(cur.size() - 1);
    }
}