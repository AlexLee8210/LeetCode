class Solution {
    public int countPalindromicSubsequence(String s) {
        int[][] pos = new int[26][];
        // Set<Integer> vis = new HashSet<>();
        // int[] prefix = new int[s.length() + 1];
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i) - 'a';
            if (pos[c] == null) {
                pos[c] = new int[]{i, 0};
            } else {
                pos[c][1] = i;
            }
            // prefix[i + 1] = prefix[i] + (vis.contains(c) ? 0 : 1);
            // vis.add(c);
        }

        for (int[] arr : pos) {
            if (arr == null || arr[1] <= arr[0] + 1) continue;
            // Set<Character> vis = new HashSet<>();
            boolean[] vis = new boolean[26];
            int start = arr[0];
            int end = arr[1];

            for (int i = start + 1; i < end; ++i) {
                if (!vis[s.charAt(i) - 'a']) ++count;
                vis[s.charAt(i) - 'a'] = true;
            }
            // count += prefix[end] - prefix[start + 1] + 1;
        }

        return count;
    }
}