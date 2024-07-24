class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for (int[] course : prerequisites) {
            if (adj[course[1]] == null) {
                adj[course[1]] = new ArrayList<>();
            }
            adj[course[1]].add(course[0]);
            indegree[course[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            res[index++] = course;
            if (adj[course] == null) continue;
            for (int pre : adj[course]) {
                indegree[pre]--;
                if (indegree[pre] == 0) {
                    q.offer(pre);
                }
            }
        }
        if (index != numCourses) return new int[]{};
        return res;
    }
}