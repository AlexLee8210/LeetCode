class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] times = new double[target];
        for (int i = 0; i < speed.length; i++) {
            times[position[i]] = (double)(target - position[i]) / speed[i];
        }
        int cnt = 0;
        double prevTime = 0;
        for (int i = target - 1; i >= 0; i--) {
            if (times[i] > prevTime) {
                cnt++;
                prevTime = times[i];
            }
        }
        return cnt;
    }
}