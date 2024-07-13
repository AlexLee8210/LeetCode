class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> newSet = new HashSet<>();
            for (int n : set) {
                if (n + nums[i] == target) return true;
                newSet.add(n + nums[i]);
            }
            set.addAll(newSet);
        }
        return false;
    }
}