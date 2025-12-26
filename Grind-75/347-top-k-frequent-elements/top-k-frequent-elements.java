class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        int[] res = new int[k];
        
        // Heap: O(n + nlogk)
        // PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1, (a,b) -> Integer.compare(freq.get(a), freq.get(b)));
        // for (int n : freq.keySet()) {
        //     heap.add(n);
        //     if (heap.size() > k) {
        //         heap.poll();
        //     }
        // }
        // for (int i = 0; i < k; ++i) {
        //     res[i] = heap.poll();
        // }
        // return res;

        // Bucket: O(n + k)
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int n : freq.keySet()) {
            int f = freq.get(n);
            if (bucket[f] == null) {
                bucket[f] = new ArrayList<>();
            }
            bucket[f].add(n);
        }

        int idx = 0;
        for (int i = nums.length; i >= 0 && idx < k; --i) {
            if (bucket[i] == null) continue;
            int j = 0;
            while (idx < k && j < bucket[i].size()) {
                res[idx++] = bucket[i].get(j++);
            }
        }

        return res;
    }
}