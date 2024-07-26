class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }
        return max;
    }
}