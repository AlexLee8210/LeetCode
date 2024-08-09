class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        int prevEnd = -1;
        for (int[] interval : intervals) {
            if (prevEnd > interval[0]) {
                return false;
            }
            prevEnd = interval[1];
        }
        return true;
    }
}