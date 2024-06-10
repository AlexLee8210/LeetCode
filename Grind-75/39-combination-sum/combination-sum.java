class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> cur, int index) {
        if (target == 0) {
            if (cur.size() > 0) {
                List<Integer> copy = new ArrayList<>(cur);
                result.add(copy);
            }
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int n = candidates[i];
            cur.add(n);
            helper(candidates, target - n, result, cur, i);
            cur.remove(cur.size() - 1);
        }
    }
}