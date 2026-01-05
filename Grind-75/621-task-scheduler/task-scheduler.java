class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            ++freq[c - 'A'];
        }

        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Queue<int[]> cooldown = new LinkedList<>(); // [freq, time]
        for (int i = 0; i < freq.length; ++i) {
            if (freq[i] > 0) maxheap.offer(freq[i]);
        }

        int time = 0;
        while (!maxheap.isEmpty() || !cooldown.isEmpty()) {
            if (!cooldown.isEmpty()) {
                if (cooldown.peek()[1] == time) {
                    maxheap.offer(cooldown.poll()[0]);
                }
            }

            if (!maxheap.isEmpty()) {
                int f = maxheap.poll();
                if (f > 1) {
                    cooldown.offer(new int[]{f - 1, time + n + 1});
                }
            } else {
                time = cooldown.peek()[1] - 1;
            }
            ++time;
        }
        return time;
    }
}