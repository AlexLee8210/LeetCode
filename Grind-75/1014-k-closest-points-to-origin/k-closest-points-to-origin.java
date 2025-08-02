class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
        for (int i = 0; i < points.length; ++i) {
            pq.add(points[i]);
            if (pq.size() > k) pq.remove();
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; ++i) {
            res[i] = pq.remove();
        }

        return res;
    }
}