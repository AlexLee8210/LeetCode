class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, new ArrayList<>(), new HashSet<>());
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> perm, Set<Integer> cur) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) continue;
            cur.add(nums[i]);
            perm.add(nums[i]);
            helper(nums, result, perm, cur);
            perm.remove(perm.size() - 1);
            cur.remove(nums[i]);
        }
    }
}