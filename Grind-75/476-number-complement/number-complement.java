class Solution {
    public int findComplement(int num) {
        if (num == 0) return 1;

        int exp = (int) (Math.log(num) / Math.log(2) + 1);
        return (int)((long)Math.pow(2, exp) - 1) ^ num;
    }
}