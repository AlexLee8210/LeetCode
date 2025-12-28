class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][];
        for (int i = 0; i < n; ++i) {
            pairs[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        // 0  3  5  8  10
        // 1  3  1  4  2
        // 12 3  7  1  1

        Stack<Double> stack = new Stack<>();
        for (int[] pair : pairs) {
            double time = (double) (target - pair[0]) / pair[1];
            while (!stack.isEmpty() && time >= stack.peek()) {
                stack.pop();
            }
            stack.push(time);
        }

        return stack.size();
    }
}