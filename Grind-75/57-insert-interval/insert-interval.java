class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int idx = 0;
         
        while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            res.add(intervals[idx++]);
        }

        // newInterval[0] = Math.min(intervals[idx][0], newInterval[0]);
        while (idx < intervals.length && intervals[idx][1] >= newInterval[0] && newInterval[1] >= intervals[idx][0]) {
            newInterval[0] = Math.min(intervals[idx][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[idx++][1], newInterval[1]);
        }

        res.add(newInterval);
         
        while (idx < intervals.length) {
            res.add(intervals[idx++]);
        }

        return res.toArray(new int[res.size()][2]);
    }
}