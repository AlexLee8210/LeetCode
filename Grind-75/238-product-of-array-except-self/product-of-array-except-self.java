class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        prefix[0] = 1;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        postfix[postfix.length - 1] = 1;
        for (int i = postfix.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i + 1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = prefix[i] * postfix[i];
        }
        // System.out.println(Arrays.toString(prefix));
        // System.out.println(Arrays.toString(postfix));
        /*
        1   2   3   4
        1   1   2   6
        24  12  4   1
        */
        return res;
    }
}