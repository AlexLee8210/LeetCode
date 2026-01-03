class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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

        int prev = candidates[idx] - 1;
        for (int i = idx; i < candidates.length; ++i) {
            if (candidates[i] == prev) continue;
            cur.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, cur, res);
            cur.remove(cur.size() - 1);
            prev = candidates[i];
        }
    }
}