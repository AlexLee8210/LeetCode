class HitCounter {
    private static final int WND = 300;
    private int[] times;
    private int[] hits;

    public HitCounter() {
        times = new int[WND];
        hits = new int[WND];
    }
    
    public void hit(int timestamp) {
        int idx = timestamp % WND;
        if (times[idx] == timestamp) {
            ++hits[idx];
        } else {
            hits[idx] = 1;
            times[idx] = timestamp;
        }
    }
    
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < WND; ++i) {
            if (times[i] + 300 > timestamp) {
                total += hits[i];
            }
        }

        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */