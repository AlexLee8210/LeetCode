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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ancestor = lca(root, startValue, destValue);
        System.out.println(ancestor.val);
        String start = dfs(ancestor, startValue, new StringBuilder());
        String dest = dfs(ancestor, destValue, new StringBuilder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < start.length(); ++i) {
            sb.append("U");
        }
        sb.append(dest);
        return sb.toString();
    }

    private TreeNode lca(TreeNode node, int p, int q) {
        if (node == null) return null;
        if (node.val == p) return node;
        if (node.val == q) return node;
        
        TreeNode left = lca(node.left, p, q);
        TreeNode right = lca(node.right, p, q);

        if (left == null) return right;
        if (right == null) return left;
        return node;
    }
    
    private String dfs(TreeNode node, int target, StringBuilder sb) {
        if (node == null) return null;
        if (node.val == target) return sb.toString();

        sb.append("L");
        String left = dfs(node.left, target, sb);
        sb.deleteCharAt(sb.length() - 1);

        if (left != null) return left;

        sb.append("R");
        String right = dfs(node.right, target, sb);
        sb.deleteCharAt(sb.length() - 1);
        return right;
    }
}