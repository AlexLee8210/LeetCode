class Solution {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        int ones = 0;
        int total = 0;

        for (int i = 0; i < boxes.length(); ++i) {
            res[i] = total;
            if (boxes.charAt(i) == '1') {
                ++ones;
            }
            total += ones;
        }

        ones = 0;
        total = 0;
        
        for (int i = boxes.length() - 1; i >= 0; --i) {
            res[i] += total;
            if (boxes.charAt(i) == '1') {
                ++ones;
            }
            total += ones;
        }

        return res;
    }
}