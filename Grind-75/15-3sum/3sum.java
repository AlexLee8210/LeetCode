class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int prev = nums[0] - 1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == prev) continue;
            int target = -nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum < target) {
                    ++l;
                } else if (sum > target) {
                    --r;
                } else {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) ++l;
                    while (l < r && nums[r] == nums[r - 1]) --r;
                    ++l;
                    --r;
                }
            }

            prev = nums[i];
        }

        return res;
    }
}