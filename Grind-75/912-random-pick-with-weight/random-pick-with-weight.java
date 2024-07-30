class Solution {
    TreeMap<Integer, Integer> map;
    int sum;

    public Solution(int[] w) {
        map = new TreeMap<>();
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            map.put(sum, i);
        }
    }
    
    public int pickIndex() {
        return map.get(map.higherKey((int) (Math.random() * sum)));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */