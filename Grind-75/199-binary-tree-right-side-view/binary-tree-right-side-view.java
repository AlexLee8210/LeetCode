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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, new int[]{-1}, 0, res);
        return res;
    }

    private void helper(TreeNode node, int[] maxDepth, int depth, ArrayList<Integer> nodes) {
        if (node == null) return;
        if (depth > maxDepth[0]) {
            nodes.add(node.val);
            maxDepth[0] = depth;
        }
        helper(node.right, maxDepth, depth + 1, nodes);
        helper(node.left, maxDepth, depth + 1, nodes);
    }
}