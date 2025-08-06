class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum > target) {
                    --r;
                } else if (sum < target) {
                    ++l;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    --r;
                    do {
                        ++l;
                    } while (l < r && nums[l - 1] == nums[l]);
                }
            }
        }

        return res;
    }
}