class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Set<Integer>[] postreq = new Set[numCourses];
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            ++indegree[a];
            if (postreq[b] == null) {
                postreq[b] = new HashSet<>();
            }

            postreq[b].add(a);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int course = q.poll();
            if (postreq[course] == null) continue;
            for (int post : postreq[course]) {
                --indegree[post];
                if (indegree[post] == 0) {
                    q.offer(post);
                }
            }
        }

        for (int ind : indegree) {
            if (ind > 0) return false;
        }

        return true;
    }
}