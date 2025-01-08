class Solution {
    public int equalDigitFrequency(String s) {
        Set<Integer> vis = new HashSet<>();
        int mod = (int) 10e7;
        int prime = 31;
        for (int start = 0; start < s.length(); ++start) {
            int[] freq = new int[10];
            int hash = 0;
            int max = 0;
            int unique = 0;
            for (int end = start; end < s.length(); ++end) {
                int digit = s.charAt(end) - '0';
                max = Math.max(max, ++freq[digit]);
                if (freq[digit] == 1) {
                    ++unique;
                }
                hash = (prime * hash + (digit + 1)) % mod;
                if (max * unique == end - start + 1) {
                    vis.add(hash);
                }
            }
        }
        return vis.size();
    }
}