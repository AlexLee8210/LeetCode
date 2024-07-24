class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> prereqs = new HashMap<>();
        for (int[] course : prerequisites) {
            if (prereqs.containsKey(course[0])) {
                prereqs.get(course[0]).add(course[1]);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(course[1]);
                prereqs.put(course[0], set);
            }
        }
        LinkedHashSet<Integer> completed = new LinkedHashSet<>();
        // Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (prereqs.containsKey(i)) continue;
            completed.add(i);
            // q.offer(i);
        }
        int prevSize = 0;
        int size = numCourses - completed.size();
        while (size != prevSize) {
            HashMap<Integer, HashSet<Integer>> temp = new HashMap<>();
            for (int k : prereqs.keySet()) {
                prereqs.get(k).removeAll(completed);
                if (prereqs.get(k).size() == 0) {
                    completed.add(k);
                } else {
                    temp.put(k, prereqs.get(k));
                }
            }
            prereqs = temp;
            prevSize = size;
            size = prereqs.size();
        }
        if (size != 0) return new int[]{};
        int[] res = new int[numCourses];
        int idx = 0;
        for (int course : completed) {
            res[idx++] = course;
        }
        return res;
    }
}