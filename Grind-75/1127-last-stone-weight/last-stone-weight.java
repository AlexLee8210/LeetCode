class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int smash = pq.poll() - pq.poll();
            if (smash > 0) pq.offer(smash);
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}