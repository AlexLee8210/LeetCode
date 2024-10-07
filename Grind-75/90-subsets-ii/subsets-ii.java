class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, int index, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));

        for (int i = index; i < nums.length; ++i) {
            if (i > index && nums[i - 1] == nums[i]) continue;
            cur.add(nums[i]);
            helper(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}