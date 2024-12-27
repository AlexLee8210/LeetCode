class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int num = 1;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                ++num;
                // set = new HashSet<>();
                set.clear();
            }
            set.add(c);
        }
        return num;
    }
}