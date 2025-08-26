class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 0; i < nums.length - 1; ++i) {
            answer[i + 1] = answer[i] * nums[i];
        }
        
        int prod = 1;
        for (int i = nums.length - 1; i > 0; --i) {
            prod *= nums[i];
            answer[i - 1] *= prod;
        }

        return answer;
    }
}