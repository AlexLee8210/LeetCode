class Solution {
    public int numSquares(int n) {
        int[] num = new int[n + 1];
        num[1] = 1;

        List<Integer> sqrts = new ArrayList<>(Arrays.asList(1));

        for (int i = 2; i <= n; ++i) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                num[i] = 1;
                sqrts.add(i);
            } else {
                num[i] = Integer.MAX_VALUE;
                for (int k : sqrts) {
                    num[i] = Math.min(num[i], num[i - k] + 1);
                }
            }
        }

        return num[n];
    }
}