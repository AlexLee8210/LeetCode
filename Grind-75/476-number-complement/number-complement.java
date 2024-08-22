class Solution {
    public int findComplement(int num) {
        if (num == 0) return 1;
        else if (num == 1) return 0;

        double d = Math.log(num) / Math.log(2);
        int exp = (int) d + 1;
        return ((1 << exp) - 1) ^ num;
        // 0 1 2 3 4 5 6 8
        // 1 1 3 3 7 7 7 15
    }
}