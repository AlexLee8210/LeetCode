class Solution {
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (freq.containsKey(sum - k)) {
                total += freq.get(sum - k);
            }
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        return total;
    }
}