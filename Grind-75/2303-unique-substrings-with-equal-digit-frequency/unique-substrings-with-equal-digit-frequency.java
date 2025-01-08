class Solution {
    public int equalDigitFrequency(String s) {
        // return helper(s, 0, 0, new StringBuilder(), new HashSet<>(), new int[10]);
        int count = 0;
        for (int n = 1; n <= s.length(); ++n) {
            count += helper(s, n);
        }

        return count;
    }

    private int helper(String s, int n) {
        int count = 0;
        int[] freq = new int[10];
        Set<String> seen = new HashSet<>();
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n - 1; ++i) {
            ++freq[s.charAt(i) - '0'];
            sb.append(s.charAt(i));
        }

        for (int i = n - 1; i < s.length(); ++i) {
            ++freq[s.charAt(i) - '0'];
            sb.append(s.charAt(i));
            if (!seen.contains(sb.toString()) && valid(freq)) {
                seen.add(sb.toString());
                ++count;
            }
            --freq[s.charAt(i - n + 1) - '0'];
            sb.deleteCharAt(0);
        }
        return count;
    }

    // private int helper(String s, int l, int r, StringBuilder sb, Set<String> seen, int[] freq) {
    //     int n = 0;
    //     if (r < s.length() - 1) {
    //         ++freq[s.charAt(r) - '0'];
    //         sb.append(s.charAt(r));
    //         if (!seen.contains(sb.toString())) {
    //             n += valid(freq) ? 1 : 0;
    //             seen.add(sb.toString());
    //         }
    //         n += helper(s, l, r + 1, sb, seen, freq);
    //         sb.deleteCharAt(sb.length() - 1);
    //         --freq[s.charAt(r) - '0'];
    //     }
    //     if (l < r - 1) {
    //         ++freq[s.charAt(l) - '0'];
    //         sb.append(s.charAt(l));
    //         if (!seen.contains(sb.toString())) {
    //             n += valid(freq) ? 1 : 0;
    //             seen.add(sb.toString());
    //         }
    //         n += helper(s, l + 1, r, sb, seen, freq);
    //         sb.deleteCharAt(sb.length() - 1);
    //         --freq[s.charAt(l) - '0'];
    //     }
    //     System.out.println(n);
    //     return n;
    // }

    private boolean valid(int[] freq) {
        int n = 0;
        for (int i : freq) {
            if (i == 0 || i == n) continue;
            if (n == 0) n = i;
            else return false;
        }
        // System.out.println(Arrays.toString(freq));
        return true;
    }
}