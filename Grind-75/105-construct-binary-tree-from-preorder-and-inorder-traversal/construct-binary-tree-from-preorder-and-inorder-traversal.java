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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length, preorder, inorder);
    }

    private TreeNode helper(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preIndex >= preorder.length || inStart >= inEnd) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        int index = -1;
        for (int i = inStart; i < inEnd; i++) {
            if (root.val == inorder[i]) {
                index = i;
                break;
            }
        }
        root.left = helper(preIndex + 1, inStart, index, preorder, inorder);
        root.right = helper(preIndex + (index - inStart) + 1, index + 1, inEnd, preorder, inorder);
        return root;
    }
}