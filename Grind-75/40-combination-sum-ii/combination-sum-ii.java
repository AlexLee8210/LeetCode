class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, int index, int target, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < nums.length; ++i) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            if (nums[i] > target) break;
            cur.add(nums[i]);
            helper(nums, i + 1, target - nums[i], cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}