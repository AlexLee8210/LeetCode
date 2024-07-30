class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> dq = new LinkedList<>();
        int i = 0;
        while (i < asteroids.length) {
            int asteroid = asteroids[i];
            while (!dq.isEmpty() && willCollide(dq.peekFirst(), asteroid)) {
                int prev = dq.removeFirst();
                asteroid = collide(prev, asteroids[i]);
            }
            if (asteroid != 0) {
                dq.addFirst(asteroid);
            }
            i++;
        }
        int[] res = new int[dq.size()];
        int index = 0;
        while (!dq.isEmpty()) {
            res[index++] = dq.removeLast();
        }
        return res;
    }

    private boolean willCollide(int l, int r) {
        return l > 0 && r < 0;
    }

    private int collide(int a, int b) {
        if (Math.abs(a) == Math.abs(b)) return 0;
        return Math.abs(a) > Math.abs(b) ? a : b;
    }
}