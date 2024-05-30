class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int index = 0;
        // before insert
        while (index < intervals.length && newInterval[0] > intervals[index][1]) {
            res.add(intervals[index++]);
        }
        // merge insert
        while (index < intervals.length && newInterval[1] >= intervals[index][0]) {
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            index++;
        }
        res.add(newInterval);
        // after insert
        while (index < intervals.length) {
            res.add(intervals[index++]);
        }
        return res.toArray(new int[res.size()][]);
    }
}