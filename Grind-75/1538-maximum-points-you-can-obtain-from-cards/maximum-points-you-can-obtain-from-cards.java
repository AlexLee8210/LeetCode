class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        int r = cardPoints.length - k;
        int l = 0;
        while (r < cardPoints.length) {
            sum += cardPoints[l++] - cardPoints[r++];
            max = Math.max(max, sum);
        }
        return max;
    }
}