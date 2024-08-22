class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        Stack<Double> times = new Stack<>();
        for (int i = pairs.length - 1; i >= 0; i--) {
            double curTime = (double)(target - pairs[i][0]) / pairs[i][1];
            if (!times.isEmpty()) {
                double time = times.peek();
                if (curTime > time) {
                    times.push(curTime);
                }
            } else {
                times.push(curTime);
            }
        }
        return times.size();
    }
}