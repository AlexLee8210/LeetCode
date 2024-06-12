class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>(nums.length);
        for (int i : nums) {
            list.add(i);
        }
        helper(list, result, new ArrayList<>());
        return result;
    }

    private void helper(List<Integer> nums, List<List<Integer>> result, List<Integer> perm) {
        if (nums.size() == 0) {
            result.add(new ArrayList<>(perm));
            return;
        }
        System.out.println(nums);
        for (int i = 0; i < nums.size(); i++) {
            int temp = nums.get(i);
            nums.remove(i);
            perm.add(temp);
            helper(nums, result, perm);
            perm.remove(perm.size() - 1);
            nums.add(i, temp);
        }
    }
}