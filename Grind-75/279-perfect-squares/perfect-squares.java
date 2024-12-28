class Solution {
    public int numSquares(int n) {
        if (n <= 3) return n;

        int[] num = new int[n + 1];
        num[1] = 1;
        num[2] = 2;
        num[3] = 3;

        List<Integer> sqrts = new ArrayList<>();

        for (int i = 2; i <= n; ++i) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                num[i] = 1;
                sqrts.add(i);
            } else {
                num[i] = num[i - 1] + 1;
                for (int k : sqrts) {
                    num[i] = Math.min(num[i], num[i - k] + 1);
                }
            }
        }

        return num[n];
    }
}