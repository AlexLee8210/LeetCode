class Solution {
    public void sortColors(int[] nums) {
        int middle = 1;
        int start = 0, mid = 0, end = nums.length - 1;
        while (mid <= end) {
            if (nums[mid] < middle) {
                swap(nums, mid, start);
                start++;
                mid++;
            } else if (nums[mid] > middle) {
                swap(nums, mid, end);
                end--;
            } else {
                mid++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}