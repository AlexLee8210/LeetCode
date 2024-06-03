class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for (int[] pair : prerequisites) {
            int prereq = pair[1];
            int course = pair[0];
            if (adj[prereq] == null) {
                adj[prereq] = new ArrayList<>();
            }
            adj[prereq].add(course);
            indegree[course]++;
        }
        // System.out.println(map);
        // System.out.println(Arrays.toString(indegree));
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int course = q.poll();
            ArrayList<Integer> prereqs = adj[course];
            if (prereqs == null) continue;
            for (int prereq : prereqs) {
                indegree[prereq]--;
                if (indegree[prereq] == 0) {
                    q.offer(prereq);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] > 0) return false;
        }
        return true;
        // HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        // for (int[] course : prerequisites) {
        //     HashSet<Integer> prereq = map.getOrDefault(course[0], new HashSet<>());
        //     prereq.add(course[1]);
        //     map.put(course[0], prereq);
        // }
        // HashSet<Integer> canTake = new HashSet<>();
        // for (int i = 0; i < numCourses; i++) {
        //     if (!map.containsKey(i)) {
        //         canTake.add(i);
        //     }
        // }
        
        // while (canTake.size() != numCourses) {
        //     int prevSize = canTake.size();
        //     for (int course : map.keySet()) {
        //         if (canTake.contains(course)) continue;
        //         HashSet<Integer> prereqs = map.get(course);
        //         boolean valid = true;
        //         for (int pre : prereqs) {
        //             if (!canTake.contains(pre)) {
        //                 valid = false;
        //                 break;
        //             }
        //         }
        //         if (valid) {
        //             canTake.add(course);
        //         }
        //     }
        //     if (prevSize == canTake.size()) return false;
        // }
        // return true;
    }
}