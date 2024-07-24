class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (res.get(res.size() - 1) < nums[i]) {
                res.add(nums[i]);
            } else {
                int idx = bs(res, nums[i]);
                res.set(idx, nums[i]);
            }
        }
        return res.size();
    }

    private int bs(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (list.get(m) > target) {
                r = m - 1;
            } else if (list.get(m) < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return l;
    }
}