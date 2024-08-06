class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefix = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            int n = arr1[i];
            while (n > 0) {
                prefix.add(n);
                n /= 10;
            }
        }

        int max = 0;
        for (int i = 0; i < arr2.length; i++) {
            int n = arr2[i];
            while (n > 0) {
                if (prefix.contains(n)) {
                    max = Math.max(max, digitCount(n));
                    break;
                }
                n /= 10;
            }
        }
        return max;
    }

    private int digitCount(int n) {
        int cnt = 0;
        while (n > 0) {
            n /= 10;
            cnt++;
        }
        return cnt;
    }
}