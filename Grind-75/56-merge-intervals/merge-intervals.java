class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);

        Deque<int[]> merged = new LinkedList<>();
        merged.addLast(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            if (merged.getLast()[1] >= intervals[i][0]) {
                int[] top = merged.getLast();
                top[1] = Math.max(top[1], intervals[i][1]);
            } else {
                merged.addLast(intervals[i]);
            }
        }

        int[][] res = new int[merged.size()][2];

        int index = 0;
        while (!merged.isEmpty()) {
            res[index] = merged.removeFirst();
            ++index;
        }

        return res;
    }
}