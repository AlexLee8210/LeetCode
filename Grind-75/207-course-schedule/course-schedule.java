class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses]; // number of prereqs for course i
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        int total = 0;
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] prereq : prerequisites) {
            adj[prereq[1]].add(prereq[0]);
            indegree[prereq[0]]++;
            total++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int course = q.poll();
            for (int i : adj[course]) {
                indegree[i]--;
                total--;
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        return total == 0;
    }
}