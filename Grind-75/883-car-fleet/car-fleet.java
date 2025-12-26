class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] times = new double[target];
        for (int i = 0; i < n; ++i) {
            times[position[i]] = (double) (target - position[i]) / speed[i];
        }

        int cnt = 0;
        double prev = 0;
        for (int i = target - 1; i >= 0; --i) {
            if (times[i] > prev) {
                ++cnt;
                prev = times[i];
            }
        }

        return cnt;
    }
}