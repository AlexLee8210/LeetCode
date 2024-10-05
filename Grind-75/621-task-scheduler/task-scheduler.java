class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freq) {
            if (f == 0) continue;
            pq.offer(f);
        }

        int time = 0;
        Deque<int[]> dq = new LinkedList<>();
        while (!pq.isEmpty() || !dq.isEmpty()) {
            if (!dq.isEmpty() && dq.peekFirst()[1] <= time) {
                pq.offer(dq.removeFirst()[0]);
            }

            if (!pq.isEmpty()) {
                int f = pq.poll();
                if (f > 1) {
                    dq.addLast(new int[]{f - 1, time + n + 1});
                }
            }
            ++time;
        }

        return time;
    }
}