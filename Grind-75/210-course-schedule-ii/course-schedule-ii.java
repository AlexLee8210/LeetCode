class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        ArrayList<Integer>[] requisites = new ArrayList[numCourses];
        int[] res = new int[numCourses];
        int index = 0;

        for (int[] prereq : prerequisites) {
            ++indegree[prereq[0]];
            if (requisites[prereq[1]] == null) {
                requisites[prereq[1]] = new ArrayList<>();
            }
            requisites[prereq[1]].add(prereq[0]);
        }
    
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < indegree.length; ++i) {
            if (indegree[i] == 0) dq.offer(i);
        }

        while (!dq.isEmpty()) {
            int course = dq.poll();
            res[index] = course;
            ++index;
            if (requisites[course] == null) continue;
            for (int postreq : requisites[course]) {
                if (--indegree[postreq] == 0) dq.offer(postreq);
            }
        }

        return index == numCourses ? res : new int[0];
    }
}