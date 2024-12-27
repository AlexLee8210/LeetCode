class Solution {
    public int kthFactor(int n, int k) {
        int top = (int) Math.floor(Math.sqrt(n));
        ArrayList<Integer> factors = new ArrayList<Integer>(Arrays.asList(1));

        for (int i = 2; i <= top; ++i) {
            if (n % i == 0) {
                factors.add(i);
            }
        }

        if (k <= factors.size()) {
            return factors.get(k - 1);
        }

        int last = factors.getLast();
        boolean sqrt = last * last == n;

        int size = factors.size() * 2 + (sqrt ? -1 : 0);
        if (k > size) {
            return -1;
        }

        int cofactorIndex = factors.size() - (k - factors.size()) + (sqrt ? -1 : 0);
        return n / factors.get(cofactorIndex);
    }
}