class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((String a, String b) -> compare(freq, b, a));
        for (String word : freq.keySet()) {
            pq.offer(word);
        }
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        return res;
    }

    private int compare(HashMap<String, Integer> freq, String a, String b) {
        int comp = freq.get(a) - freq.get(b);
        if (comp == 0) {
            return b.compareTo(a);
        }
        return comp;
    }
}