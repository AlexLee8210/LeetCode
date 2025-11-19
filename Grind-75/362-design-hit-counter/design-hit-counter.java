class HitCounter {
    private static final int WND = 300;
    private List<Integer> hits;

    public HitCounter() {
        hits = new ArrayList<>();
    }
    
    public void hit(int timestamp) {
        hits.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        int l = 0, r = hits.size() - 1;
        int target = timestamp - WND;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (hits.get(m) <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return hits.size() -  l;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */