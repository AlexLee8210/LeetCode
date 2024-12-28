class Solution {
    public int minimumOperations(int[] nums) {
        Deque<Integer> dq = new LinkedList<>();
        int ops = 0;

        for (int n : nums) {
            dq.addLast(n);
        }

        while (dq.size() > 1) {
            // if (dq.getFirst() == dq.getLast()) {
            //     dq.removeFirst();
            //     dq.removeLast();
            //     continue;
            // }

            // 
            // left: 7, right: 5
            int left = dq.removeFirst(), right = dq.removeLast();
            while (!dq.isEmpty() && left != right) {
                ++ops;
                if (left < right) {
                    left += dq.removeFirst();
                } else {
                    right += dq.removeLast();
                }
            }
            if (dq.isEmpty() && left != right) {
                ++ops;
            }
        }

        return ops;
    }
}