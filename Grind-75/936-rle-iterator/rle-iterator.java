class RLEIterator {
    int[] encoding;
    int idx;

    public RLEIterator(int[] encoding) {
        this.encoding = Arrays.copyOf(encoding, encoding.length);
        this.idx = 0;
    }
    
    public int next(int n) {
        int res = -1;
        while (idx < encoding.length && (n > 0 || encoding[idx] == 0)) {
            if (encoding[idx] == 0) {
                idx += 2;
                continue;
            }
            int sub = Math.min(n, encoding[idx]);
            encoding[idx] -= sub;
            n -= sub;
            if (n == 0) {
                res = encoding[idx + 1];
            }
        }
        return res;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */