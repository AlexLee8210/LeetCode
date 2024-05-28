class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int k : nums) {
            if (set.contains(k)) {
                return true;
            }
            set.add(k);
        }
        return false;
    }
}