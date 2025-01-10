class Solution {
    public int reverse(int x) {
        int y = 0;
        int next = 0;
        while (x != 0) {
            next = y * 10 + x % 10;
            if (next / 10 != y) return 0;
            y = next;
            x /= 10;
        }
        
        return y;
    }
}