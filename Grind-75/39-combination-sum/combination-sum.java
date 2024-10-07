class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, int index, int target, List<Integer> cur, List<List<Integer>> res) {
        if (target <= 0 || index >= nums.length) {
            if (target == 0) res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < nums.length; ++i) {
            cur.add(nums[i]);
            helper(nums, i, target - nums[i], cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}