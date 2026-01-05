class MedianFinder {

    private PriorityQueue<Integer> low;
    private PriorityQueue<Integer> high;

    public MedianFinder() {
        low = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        high = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        low.offer(num);
        if (low.size() - high.size() > 1) {
            high.offer(low.poll());
        }
        if (!high.isEmpty() && low.peek() > high.peek()) {
            high.offer(low.poll());
            if (high.size() > low.size()) low.offer(high.poll());
        }
    }
    
    public double findMedian() {
        int size = low.size() + high.size();
        double med = size % 2 == 0 ? (low.peek() + high.peek()) / 2.0 : low.peek();
        return med;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */