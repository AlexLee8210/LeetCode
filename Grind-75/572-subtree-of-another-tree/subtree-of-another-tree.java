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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (root.val == subRoot.val) {
            if (sameSubtree(root, subRoot)) return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean sameSubtree(TreeNode node, TreeNode subNode) {
        if (node == null && subNode == null) {
            return true;
        } else if (node == null || subNode == null) {
            return false;
        } else if (node.val != subNode.val) {
            return false;
        }
        return sameSubtree(node.left, subNode.left) && sameSubtree(node.right, subNode.right);
    }

    // private boolean solve(TreeNode node, TreeNode subRoot) {
    //     if (node == null && subNode == null) {
    //         return true;
    //     } else if (node == null || subNode == null) {
    //         return false;
    //     } else if (node.val == subNode.val) {
    //         sameSubTree(node, subNode);
    //     }
    //     return solve(node.left, subRoot) || solve(node.right, subRoot);
    // }
}