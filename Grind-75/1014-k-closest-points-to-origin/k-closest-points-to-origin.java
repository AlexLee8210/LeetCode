class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxheap = new PriorityQueue<>(
            k + 1,
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1])
        );

        for (int[] point : points) {
            maxheap.offer(point);
            if (maxheap.size() > k) maxheap.poll();
        }

        int[][] res = new int[k][];
        for (int i = 0; i < k; ++i) {
            res[i] = maxheap.poll();
        }
        return res;
    }
}