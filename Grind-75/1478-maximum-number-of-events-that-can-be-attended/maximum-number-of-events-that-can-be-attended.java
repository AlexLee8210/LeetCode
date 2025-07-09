class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[0], b[0]);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int maxDay = 0;
        for (int i = 0; i < events.length; ++i) {
            maxDay = Math.max(events[i][1], maxDay); 
        }
        
        int day = events[0][0];
        int count = 0;
        int idx = 0;
        while (day <= maxDay) {
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            while (idx < events.length && events[idx][0] == day) {
                pq.offer(events[idx++][1]);
            }

            if (!pq.isEmpty()) {
                pq.poll();
                ++count;
            }
            ++day;
        }
        return count;

    }
}