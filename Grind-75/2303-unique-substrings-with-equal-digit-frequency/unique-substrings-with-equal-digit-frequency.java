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

        for (int i = 0; i < n - 1; ++i) {
            ++freq[s.charAt(i) - '0'];
        }

        // if (valid(freq)) {
        //     seen.add(s.substring(0, n));
        //     ++count;
        // }
        for (int i = 0; i <= s.length() - n; ++i) {
            ++freq[s.charAt(i + n - 1) - '0'];
            if (!seen.contains(s.substring(i, i + n)) && valid(freq)) {
                seen.add(s.substring(i, i + n));
                ++count;
            }
            --freq[s.charAt(i) - '0'];
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