class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            if (adj[prereq] == null) {
                adj[prereq] = new ArrayList<>();
            }
            adj[prereq].add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int prereq = q.poll();
            ArrayList<Integer> courses = adj[prereq];
            if (courses == null) continue;
            for (int course : courses) {
                indegree[course]--;
                if (indegree[course] == 0) {
                    q.offer(course);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) return false;
        }
        return true;
    }
}