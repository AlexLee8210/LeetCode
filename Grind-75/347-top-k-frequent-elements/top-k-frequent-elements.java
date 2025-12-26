class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int[] res = new int[k];
        // Heap: O(n + nlogk)
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1, (a,b) -> Integer.compare(freq.get(a), freq.get(b)));
        for (int n : freq.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        for (int i = 0; i < k; ++i) {
            res[i] = heap.poll();
        }
        return res;
        // Bucket: O(n + k)
        
    }
}