class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        ArrayList<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] prev = result.get(result.size() - 1);
            if (interval[0] > prev[1]) {
                result.add(interval);
            } else if (interval[1] > prev[1]) {
                prev[1] = interval[1];
            }
        }
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}