class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer>[] postreq = new List[numCourses];

        for (int[] prereq : prerequisites) {
            ++indegree[prereq[0]];
            if (postreq[prereq[1]] == null) postreq[prereq[1]] = new ArrayList<>();
            postreq[prereq[1]].add(prereq[0]);
        }

        Queue<Integer> courses = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) courses.offer(i);
        }

        int[] res = new int[numCourses];
        int idx = 0;
        while (!courses.isEmpty()) {
            int course = courses.poll();
            res[idx++] = course;
            if (postreq[course] == null) continue;
            for (int next : postreq[course]) {
                if (--indegree[next] == 0) courses.offer(next);
            }
        }
        return idx == numCourses ? res : new int[0];
    }
}