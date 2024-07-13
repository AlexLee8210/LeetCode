class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        subsetHelper(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void subsetHelper(int idx, int[] nums, ArrayList<Integer> cur, ArrayList<List<Integer>> total) {
        total.add(new ArrayList<>(cur));
        for (int i = idx; i < nums.length; i++) {
            cur.add(nums[i]);
            subsetHelper(i + 1, nums, cur, total);
            cur.remove(cur.size() - 1);
        }
    }
}