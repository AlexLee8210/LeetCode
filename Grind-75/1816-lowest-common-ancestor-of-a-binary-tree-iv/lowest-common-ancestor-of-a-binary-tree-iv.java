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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node);
        }

        return lca(root, set);
    }

    private TreeNode lca(TreeNode root, Set<TreeNode> nodes) {
        if (root == null || nodes.contains(root)) return root;

        TreeNode left = lca(root.left, nodes);
        TreeNode right = lca(root.right, nodes);

        if (left != null && right != null) return root;
        else if (left != null) return left;
        else return right;
    }
}