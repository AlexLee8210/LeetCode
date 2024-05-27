class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int total = 0;
        for (char c : map.keySet()) {
            int n = map.get(c);
            if (n % 2 == 0) {
                total += n;
            } else {
                if (total % 2 == 0) {
                    total++;
                }
                total += n - 1;
            }
        }
        return total;
    }
}