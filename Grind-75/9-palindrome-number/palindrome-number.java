class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x < 10 || x == 0) return true;
        else if (x % 10 == 0) return false;
        // else if (x < 1000 && x % 11 == 0) return true;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev == x || x == rev / 10;
    }
}