class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int[] indegree = new int[numCourses];
        List<Integer>[] reqs = new List[numCourses];

        for (int[] course : prerequisites) {
            int pre = course[1];
            int post = course[0];
            ++indegree[post];
            if (reqs[pre] == null) {
                reqs[pre] = new ArrayList<>();
            }
            reqs[pre].add(post);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int i = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            order[i++] = course;
            if (reqs[course] == null) {
                continue;
            }
            for (int post : reqs[course]) {
                --indegree[post];
                if (indegree[post] == 0) {
                    q.offer(post);
                }
            }
        }

        return i == numCourses ? order : new int[]{};
    }
}