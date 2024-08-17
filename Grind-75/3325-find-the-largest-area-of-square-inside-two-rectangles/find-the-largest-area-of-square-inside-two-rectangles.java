class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int res = 0;
        for (int i = 0; i < bottomLeft.length; i++) {
            int[] bl1 = bottomLeft[i];
            int[] tr1 = topRight[i];
            for (int j = i + 1; j < bottomLeft.length; j++) {
                int[] bl2 = bottomLeft[j];
                int[] tr2 = topRight[j];
                if (!intersects(bl1, tr1, bl2, tr2)) continue;
                // System.out.println("Intersecting: " + i + ", " + j);
                int xLen = Math.min(tr1[0], tr2[0]) - Math.max(bl1[0], bl2[0]);
                int yLen = Math.min(tr1[1], tr2[1]) - Math.max(bl1[1], bl2[1]);
                // System.out.println(xLen + ", " + yLen);
                res = Math.max(res, Math.min(xLen, yLen));
            }
        }
        return (long)res * res;
    }

    private boolean intersects(int[] bl1, int[] tr1, int[] bl2, int[] tr2) {
        return tr1[0] >= bl2[0] && tr1[1] >= bl2[1] && tr2[0] >= bl1[0] && tr2[1] >= bl1[1];
    }
}