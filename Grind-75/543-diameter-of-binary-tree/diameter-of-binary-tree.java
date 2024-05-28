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
        return diam(root, new HashMap<>());
    }

    private int diam(TreeNode node, HashMap<TreeNode, Integer> heightMap) {
        if (node == null) return 0;
        int diameter = height(node.left, heightMap) + height(node.right, heightMap);
        return Math.max(diameter, Math.max(diam(node.left, heightMap), diam(node.right, heightMap)));
    }

    // private int diamHelper(TreeNode cur, HashMap<TreeNode, Integer> heightMap) {
    //     if (cur.left == null && cur.right == null) {
    //         return 0;
    //     } else if (cur.left == null) {
    //         return height(cur.right, heightMap);
    //     } else if (cur.right == null) {
    //         return height(cur.left, heightMap);
    //     }
    //     int maxDiam = Math.max(diamHelper(cur.left, heightMap), diamHelper(cur.right, heightMap));
    //     return Math.max(maxDiam, height(cur.left, heightMap) + height(cur.right, heightMap));
    // }

    private int height(TreeNode cur, HashMap<TreeNode, Integer> memo) {
        if (cur == null) {
            return 0;
        } else if (memo.containsKey(cur)) {
            return memo.get(cur);
        }
        int height = Math.max(height(cur.left, memo), height(cur.right, memo)) + 1;
        memo.put(cur, height);
        return height;
    }
}