class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] course : prerequisites) {
            HashSet<Integer> prereq = map.getOrDefault(course[0], new HashSet<>());
            prereq.add(course[1]);
            map.put(course[0], prereq);
        }
        HashSet<Integer> canTake = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!map.containsKey(i)) {
                canTake.add(i);
            }
        }
        
        while (canTake.size() != numCourses) {
            int prevSize = canTake.size();
            for (int course : map.keySet()) {
                HashSet<Integer> prereqs = map.get(course);
                boolean valid = true;
                for (int pre : prereqs) {
                    if (!canTake.contains(pre)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    canTake.add(course);
                }
            }
            if (prevSize == canTake.size()) return false;
        }
        return true;
    }
}