class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < nums.length; ++i) {
            minHeap.offer(nums[i]);
            if (minHeap.size() > 4) {
                minHeap.poll();
            }
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; ++i) {
            maxHeap.offer(nums[i]);
            if (maxHeap.size() > 4) {
                maxHeap.poll();
            }
        }

        int[] minElems = new int[4];
        for (int i = 0; i < 4; ++i) {
            minElems[i] = minHeap.poll();
        }

        int[] maxElems = new int[4];
        for (int i = 3; i >= 0; --i) {
            maxElems[i] = maxHeap.poll();
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 4; ++i) {
            int diff = maxElems[i] - minElems[i];
            minDiff = Math.min(diff, minDiff);
        }
        return minDiff;
    }
}