class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        // long[] dist = new long[points.length];
        TreeMap<Long, LinkedList<int[]>> dist = new TreeMap<>();
        for (int[] point : points) {
            long d = (long)Math.pow(point[0], 2) + (long)Math.pow(point[1], 2);
            LinkedList<int[]> list = dist.getOrDefault(d, new LinkedList<>());
            list.add(point);
            dist.put(d, list);
        }
        int idx = 0;
        for (Long d : dist.keySet()) {
            if (idx >= k)  break;
            LinkedList<int[]> list = dist.get(d);
            for (int[] point : list) {
                if (idx >= k)  break;
                ans[idx++] = point;
            }
        }
        return ans;
    }
}