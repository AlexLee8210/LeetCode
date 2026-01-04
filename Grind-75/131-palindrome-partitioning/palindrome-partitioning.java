class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int l = s.length() - 1; l >= 0; --l) {
            dp[l][l] = true;
            for (int r = l + 1; r < s.length(); ++r) {
                if (s.charAt(r) != s.charAt(l)) continue;
                dp[l][r] = (r - l) < 2 || dp[l + 1][r - 1];
            }
        }

        List<List<String>> res = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), res, dp);
        return res;
    }

    private void helper(String s, int start, List<String> cur, List<List<String>> res, boolean[][] dp) {
        if (start == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int r = start; r < s.length(); ++r) {
            if (dp[start][r]) {
                cur.add(s.substring(start, r + 1));
                helper(s, r + 1, cur, res, dp);
                cur.remove(cur.size() - 1);
            }
        }
    }
}