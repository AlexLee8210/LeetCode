class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] vis = new boolean[arr.length];

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int idx = q.poll();
            if (vis[idx]) continue;
            if (arr[idx] == 0) return true;
            vis[idx] = true;

            if (idx >= arr[idx]) q.offer(idx - arr[idx]);
            if (idx + arr[idx] < arr.length) q.offer(idx + arr[idx]);
        }

        return false;
    }
}