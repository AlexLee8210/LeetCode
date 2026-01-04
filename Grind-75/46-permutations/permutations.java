class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<>(), new HashSet<>(), res);
        return res;
    }

    private void helper(int[] nums, List<Integer> cur, Set<Integer> vis, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (vis.contains(i)) continue;
            cur.add(nums[i]);
            vis.add(i);
            helper(nums, cur, vis, res);
            cur.remove(cur.size() - 1);
            vis.remove(i);
        }
    }
}