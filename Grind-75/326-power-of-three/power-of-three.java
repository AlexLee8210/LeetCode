class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        int log = (int) Math.round(Math.log(n) / Math.log(3));
        return ((long) Math.pow(3, log)) == n;
    }
}