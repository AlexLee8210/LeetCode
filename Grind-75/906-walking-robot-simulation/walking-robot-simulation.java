class Solution {
    private int[][] dirs = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    public int robotSim(int[] commands, int[][] obstacles) {
        int res = 0;
        HashSet<String> obs = new HashSet<>();
        for (int[] pos : obstacles) {
            obs.add(pos[0] + "," + pos[1]);
        }
        int x = 0, y = 0;
        int dirIndex = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                dirIndex = (dirIndex + 1) % 4;
            } else if (commands[i] == -1) {
                dirIndex = ((dirIndex - 1) + 4) % 4;
            } else {
                int m = commands[i];
                while (m > 0 && !obs.contains(x + dirs[dirIndex][0] + "," + (y + dirs[dirIndex][1]))) {
                    x += dirs[dirIndex][0];
                    y += dirs[dirIndex][1];
                    m--;
                    res = Math.max(res, x * x + y * y);
                }
            }
        }
        return res;
    }
}