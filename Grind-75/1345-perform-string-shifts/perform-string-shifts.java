class Solution {
    public String stringShift(String s, int[][] shift) {
        int n = s.length();
        int start = 0;
        for (int[] pair : shift) {
            boolean left = pair[0] == 0;
            int amount = left ? pair[1] : -pair[1];

            start += amount;
            start = (start % n + n) % n;
        }

        return s.substring(start) + s.substring(0, start);
    }
}