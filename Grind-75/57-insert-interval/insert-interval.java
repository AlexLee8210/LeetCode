class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int index = 0;
        while (index < intervals.length && newInterval[0] > intervals[index][1]) {
            res.add(intervals[index++]);
        }
        if (index == intervals.length) {
            res.add(newInterval);
            return res.toArray(new int[res.size()][]);
        } else if (newInterval[1] >= intervals[index][0]) {
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            index++;
        }
        while (index < intervals.length && newInterval[1] >= intervals[index][0]) {
            newInterval[1] = Math.max(intervals[index++][1], newInterval[1]);
        }
        res.add(newInterval);
        while (index < intervals.length) {
            res.add(intervals[index++]);
        }
        return res.toArray(new int[res.size()][]);
    }
}