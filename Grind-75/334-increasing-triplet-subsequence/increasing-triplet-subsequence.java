class Solution {
    public boolean increasingTriplet(int[] nums) {
        int s = Integer.MAX_VALUE, m = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= s) {
                s = n;
            } else if (n <= m) {
                m = n;
            } else {
                return true;
            }
        }
        return false;
    }
}