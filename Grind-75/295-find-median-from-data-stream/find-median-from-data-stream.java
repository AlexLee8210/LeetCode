class MedianFinder {
    PriorityQueue<Integer> small, large;

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        int smallMax = small.isEmpty() ? Integer.MAX_VALUE : small.peek();
        // int largeMin = large.isEmpty() ? Integer.MAX_VALUE : large.peek();
        if (num < smallMax) {
            small.offer(num);
        } else {
            large.offer(num);
        }
        rebalance();
    }

    private void rebalance() {
        if (Math.abs(small.size() - large.size()) <= 1) return;
        while (small.size() - large.size() > 1) {
            large.offer(small.poll());
        }
        while (large.size() - small.size() >= 1) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        // System.out.println(small);
        // System.out.println(large);
        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        }
        return small.size() > large.size() ? small.peek() : large.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */