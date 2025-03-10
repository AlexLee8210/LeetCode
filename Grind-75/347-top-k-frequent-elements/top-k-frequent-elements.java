class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1, (Integer a, Integer b) -> freq.get(a) - freq.get(b));

        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        for (int n : freq.keySet()) {
            pq.offer(n);
            if (pq.size() == k + 1) pq.poll();
        }

        int[] res = new int[k];

        for (int i = 0; i < k; ++i) {
            res[i] = pq.poll();
        }

        return res;
    }
}