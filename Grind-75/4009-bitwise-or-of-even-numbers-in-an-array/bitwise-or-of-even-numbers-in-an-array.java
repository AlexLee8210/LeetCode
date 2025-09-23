class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int res = 0;
        for (int i : nums) {
            if (i % 2 == 1) continue;
            res |= i;
        }
        return res;
    }
}