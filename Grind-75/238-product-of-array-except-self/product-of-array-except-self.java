class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 0; i < nums.length - 1; ++i) {
            res[i + 1] = res[i] * nums[i];
        }

        // 1, 1, 2, 6
        // 24, 12, 4, 1

        int prod = 1;
        for (int i = nums.length - 2; i >= 0; --i) {
            prod *= nums[i + 1];
            res[i] *= prod;
        }

        return res;
    }
}