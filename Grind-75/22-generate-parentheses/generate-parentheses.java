class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        helper(n, n, new StringBuilder(), res);
        return res;
    }
    private void helper(int l, int r, StringBuilder sb, ArrayList<String> res) {
        if (r == 0) {
            res.add(sb.toString());
            return;
        }
        if (l > 0) {
            sb.append("(");
            helper(l - 1, r, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (l < r) {
            sb.append(")");
            helper(l, r - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}