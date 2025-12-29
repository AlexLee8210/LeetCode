class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                if (nums[m] < target) {
                    l = m + 1;
                } else if (nums[m] > target) {
                    if (target <= nums[r]) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                } else {
                    return m;
                }
            } else {
                if (target < nums[m]) {
                    r = m - 1;
                } else if (target > nums[m]) {
                    if (target <= nums[r]) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                } else {
                    return m;
                }
            }
        }

        return -1;
    }
}