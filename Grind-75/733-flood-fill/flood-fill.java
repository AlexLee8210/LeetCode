class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        floodFillHelper(image, sr, sc, color, new boolean[image.length][image[0].length], image[sr][sc]);
        return image;
    }

    private void floodFillHelper(int[][] image, int sr, int sc, int color, boolean[][] seen, int ogColor) {
        if ((sr < 0 || sr >= image.length) ||
            (sc < 0 || sc >= image[0].length) ||
            seen[sr][sc] ||
            image[sr][sc] != ogColor
        ) {
            return;
        }
        image[sr][sc] = color;
        seen[sr][sc] = true;
        floodFillHelper(image, sr - 1, sc, color, seen, ogColor);
        floodFillHelper(image, sr + 1, sc, color, seen, ogColor);
        floodFillHelper(image, sr, sc - 1, color, seen, ogColor);
        floodFillHelper(image, sr, sc + 1, color, seen, ogColor);
    }
}