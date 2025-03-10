class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; ++j) {
                int idx = q.poll();
                if (idx == arr.length - 1) return dist;
                
                if (idx > 0 && map.containsKey(arr[idx - 1])) q.offer(idx - 1);
                if (map.containsKey(arr[idx + 1])) q.offer(idx + 1);
                
                if (!map.containsKey(arr[idx])) continue;
                List<Integer> adj = map.get(arr[idx]);
                for (int i : adj) {
                    if (i == idx) continue;
                    q.offer(i);
                }
                map.remove(arr[idx]);
            }
            ++dist;
        }

        return -1;
    }
}