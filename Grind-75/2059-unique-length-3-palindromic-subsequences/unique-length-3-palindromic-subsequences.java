class Solution {
    public int countPalindromicSubsequence(String s) {
        int[][] pos = new int[26][];
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i) - 'a';
            if (pos[c] == null) {
                pos[c] = new int[]{i, 0};
            } else {
                pos[c][1] = i;
            }
        }

        for (int[] arr : pos) {
            if (arr == null || arr[1] <= arr[0] + 1) continue;
            boolean[] vis = new boolean[26];
            int start = arr[0];
            int end = arr[1];

            for (int i = start + 1; i < end; ++i) {
                if (!vis[s.charAt(i) - 'a']) ++count;
                vis[s.charAt(i) - 'a'] = true;
            }
        }

        return count;
    }
}