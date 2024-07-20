class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        int pivot = findPivot(nums);
        if (pivot != -1) {
            int pivotSwap = lastIndexGreater(nums, nums[pivot]);
            swap(nums, pivot, pivotSwap);
        }
        reverse(nums, pivot + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private int findPivot(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) return i;
        }
        return -1;
    }

    private int lastIndexGreater(int[] nums, int n) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > n) return i;
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}