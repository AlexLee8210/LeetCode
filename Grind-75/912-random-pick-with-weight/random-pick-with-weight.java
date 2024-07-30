class Solution {
    TreeMap<Integer, Integer> map;
    int sum;
    Random random;

    public Solution(int[] w) {
        map = new TreeMap<>();
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            map.put(sum, i);
        }
        random = new Random();
    }
    
    public int pickIndex() {
        return map.get(map.higherKey(random.nextInt(sum)));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */