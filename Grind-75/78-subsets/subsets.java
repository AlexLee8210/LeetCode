class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    private void helper(int[] nums, int i, List<Integer> cur, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        helper(nums, i + 1, cur, res);
        cur.add(nums[i]);
        helper(nums, i + 1, cur, res);
        cur.removeLast();
    }
}