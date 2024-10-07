class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new HashSet<>(), new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, Set<Integer> vis, List<Integer> cur, List<List<Integer>> res) {
        if (vis.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis.contains(nums[i])) continue;
            cur.add(nums[i]);
            vis.add(nums[i]);
            helper(nums, vis, cur, res);
            vis.remove(nums[i]);
            cur.remove(cur.size() - 1);
        }
    }
}