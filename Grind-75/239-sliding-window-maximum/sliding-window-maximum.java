class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> dq = new LinkedList<>();
        
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] > dq.peekLast()) {
                dq.pollLast();
            }
            dq.addLast(nums[i]);
        }
        res[index++] = dq.peekFirst();

        for (int i = k; i < nums.length; i++) {
            if (dq.peekFirst() == nums[i - k]) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[i] > dq.peekLast()) {
                dq.pollLast();
            }
            dq.addLast(nums[i]);
            res[index++] = dq.peekFirst();
        }
        return res;
    }
}