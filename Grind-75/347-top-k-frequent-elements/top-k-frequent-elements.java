class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        for (int n : freq.keySet()) {
            int count = freq.get(n);
            if (buckets[count] == null) buckets[count] = new ArrayList<>();
            buckets[count].add(n);
        }

        int[] res = new int[k];
        
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0; --i) {
            if (buckets[i] == null) continue;
            for (int j = 0; j < buckets[i].size() && idx < k; ++j) {
                res[idx] = buckets[i].get(j);
                ++idx;
            }
        }

        return res;
    }
}