class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int ans = 0;
        int prev = 0;
        int n = 0;
        for (char c : s.toCharArray()) {
            n = map.get(c);
            if (prev < n) {
                n -= 2 * prev;
            }
            ans += n;
            prev = n;
        }
        return ans;
    }
}