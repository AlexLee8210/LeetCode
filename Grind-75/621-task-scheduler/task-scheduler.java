class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A']++;
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> counts[b - 'A'] - counts[a - 'A']);
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) pq.add((char)(i + 'A'));
        }
        int cycle = 0;
        int[] cooldown = new int[26];
        while (!pq.isEmpty()) {
            char task = pq.poll();
            Stack<Character> stack = new Stack<>();
            while (!pq.isEmpty() && cooldown[task - 'A'] > 0) {
                stack.push(task);
                task = pq.poll();
            }
            while (!stack.isEmpty()) {
                pq.offer(stack.pop());
            }
            if (cooldown[task - 'A'] == 0) {
                cooldown[task - 'A'] = n + 1;
                counts[task - 'A']--;
                if (counts[task - 'A'] > 0) {
                    pq.offer(task);
                }
            } else {
                pq.offer(task);
            }
            for (int i = 0; i < cooldown.length; i++) {
                if (cooldown[i] > 0) cooldown[i]--;
            }
            cycle++;
        }
        return cycle;
    }
}