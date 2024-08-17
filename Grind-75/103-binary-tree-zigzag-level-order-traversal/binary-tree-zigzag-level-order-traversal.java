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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean startLeft = true;
        while (!q.isEmpty()) {
            int len = q.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode cur = q.poll();
                if (startLeft) {
                    list.addLast(cur.val);
                } else {
                    list.addFirst(cur.val);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(list);
            startLeft = !startLeft;
        }
        return res;
    }
}