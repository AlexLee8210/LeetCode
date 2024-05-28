class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        int prev = 0;
        int n = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            n = getNum(chars[i]);
            if (prev > n) {
                ans -= n;
            } else {
                ans += n;
            }
            prev = n;
        }
        return ans;
    }

    private int getNum(char c) {
        switch (c) {
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
        }
        return -1;
    }
}