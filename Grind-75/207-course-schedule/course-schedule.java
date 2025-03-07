class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        ArrayList<Integer>[] requisites = new ArrayList[numCourses];

        for (int[] prereq : prerequisites) {
            ++indegree[prereq[0]];
            if (requisites[prereq[1]] == null) {
                requisites[prereq[1]] = new ArrayList<>();
            }
            requisites[prereq[1]].add(prereq[0]);
        }

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) dq.offer(i);
        }

        int courses = 0;

        while (!dq.isEmpty()) {
            int course = dq.poll();
            ++courses;
            if (requisites[course] == null) continue;
            for (int req : requisites[course]) {
                if (--indegree[req] == 0) dq.offer(req);
            }
        }

        return courses == numCourses;
    }
}