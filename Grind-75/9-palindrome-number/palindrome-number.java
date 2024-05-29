class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        // if (x % 11 == 0 || x < 10) return true;
        Stack<Integer> stack = new Stack<>();
        int n = x;
        while (n > 0) {
            stack.push(n % 10);
            n /= 10;
        }
        while (x > 0) {
            if (stack.pop() != x % 10) return false;
            x /= 10;
        }
        return true;
    }
}