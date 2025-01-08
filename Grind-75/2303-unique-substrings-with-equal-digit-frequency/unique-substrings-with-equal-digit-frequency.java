class Solution {
    public int equalDigitFrequency(String s) {
        Set<Integer> vis = new HashSet<>();

        for (int start = 0; start < s.length(); ++start) {
            int hash = 0;
            int unique = 0;
            int max = 0;
            int[] freq = new int[10];

            for (int end = start; end < s.length(); ++end) {
                int digit = s.charAt(end) - '0';
                max = Math.max(max, ++freq[digit]);
                if (freq[digit] == 1) ++unique;

                hash = (31 * hash + digit + 1) % ((int) 10e7);

                if (max * unique == end - start + 1) {
                    vis.add(hash);
                }
            }
        }

        return vis.size();
    }
}