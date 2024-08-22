class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || stack.pop() != getOpen(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpen(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private char getOpen(char c) {
        if (c == ')') {
            return '(';
        } else if (c == ']') {
            return '[';
        } else {
            return '{';
        }
    }
}
