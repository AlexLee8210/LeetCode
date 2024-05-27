/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcaHelper(root, p, q);
    }

    private TreeNode lcaHelper(TreeNode node, TreeNode p, TreeNode q) {
        if (q.val < p.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        if (node.val >= p.val && node.val <= q.val) {
            return node;
        } else if (node.val >= p.val) {
            return lowestCommonAncestor(node.left, p, q);
        } else {
            return lowestCommonAncestor(node.right, p, q);
        }
    }
}