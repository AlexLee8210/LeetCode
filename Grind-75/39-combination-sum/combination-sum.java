class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] candidates, int target, int idx, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (idx >= candidates.length || target < 0) return;

        for (int i = idx; i < candidates.length; ++i) {
            cur.add(candidates[i]);
            helper(candidates, target - candidates[i], i, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}