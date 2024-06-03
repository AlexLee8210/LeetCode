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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        ArrayList<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int qSize = q.size();
            ArrayList<Integer> cur = new ArrayList<>(qSize);
            for (int i = 0; i < qSize; i++) {
                TreeNode node = q.poll();
                if (node == null) continue;
                cur.add(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
            if (cur.size() > 0) res.add(cur);
        }
        return res;
        // Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        // q.offer(new Pair<>(root, 0));
        // List<List<Integer>> res = new ArrayList<>();
        // List<Integer> cur = new ArrayList<>();
        // int curLevel = 0;

        // while (!q.isEmpty()) {
        //     Pair<TreeNode, Integer> pair = q.poll();
        //     TreeNode node = pair.getKey();
        //     int level = pair.getValue();
        //     if (node == null) {
        //         continue;
        //     }
        //     q.offer(new Pair<>(node.left, level + 1));
        //     q.offer(new Pair<>(node.right, level + 1));
        //     if (level > curLevel) {
        //         res.add(cur);
        //         cur = new ArrayList<>();
        //         curLevel++;
        //     }
        //     cur.add(node.val);
        // }
        // if (cur.size() > 0) res.add(cur);
        // return res;
    }
}