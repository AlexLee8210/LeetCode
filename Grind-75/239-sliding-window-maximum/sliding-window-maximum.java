class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<int[]> dq = new LinkedList<>(); // [idx, val]

        for (int i = 0; i < k; ++i) {
            while (!dq.isEmpty() && dq.peekLast()[1] < nums[i]) {
                dq.removeLast();
            }
            dq.offerLast(new int[]{i, nums[i]});
        }

        res[0] = dq.peekFirst()[1];

        for (int r = k; r < nums.length; ++r) {
            int l = r - k;
            if (l == dq.peekFirst()[0]) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && dq.peekLast()[1] < nums[r]) {
                dq.removeLast();
            }
            dq.offerLast(new int[]{r, nums[r]});
            res[l + 1] = dq.peekFirst()[1];
        }

        return res;
    }
}