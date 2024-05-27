class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean odd = false;
        int total = 0;
        for (char c : map.keySet()) {
            int n = map.get(c);
            if (n % 2 == 0) {
                total += n;
            } else {
                odd = true;
                total += n - 1;
            }
        }
        return total + (odd ? 1 : 0);
    }
}