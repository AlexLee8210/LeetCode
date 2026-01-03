/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        // System.out.println(sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val);
        
        if (node.left != null) {
            sb.append('l');
            serializeHelper(node.left, sb);
        }
        if (node.right != null) {
            sb.append('r');
            serializeHelper(node.right, sb);
        }

        sb.append('u');
    }

    private int token(String data, int[] idx) {
        if (idx[0] > data.length() || Character.isAlphabetic(data.charAt(idx[0]))) {
            return -1;
        }
        
        boolean pos = true;
        if (data.charAt(idx[0]) == '-') {
            pos = false;
            ++idx[0];
        }

        int val = 0;
        while (Character.isDigit(data.charAt(idx[0]))) {
            val = val * 10 + (data.charAt(idx[0]) - '0');
            ++idx[0];
        }
        return pos ? val : -val;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        int[] idx = new int[]{0};
        TreeNode root = new TreeNode(token(data, idx));

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (idx[0] < data.length()) {
            TreeNode node = stack.peek();
            char dir = data.charAt(idx[0]++);
            if (dir == 'l') {
                node.left = new TreeNode(token(data, idx));
                stack.push(node.left);
            } else if (dir == 'r') {
                node.right = new TreeNode(token(data, idx));
                stack.push(node.right);
            } else {
                stack.pop();
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));