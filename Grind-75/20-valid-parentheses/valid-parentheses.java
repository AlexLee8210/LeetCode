class Solution {
    public boolean isValid(String s) {
        Set<Character> opens = new HashSet<>();
        opens.add('(');
        opens.add('{');
        opens.add('[');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (opens.contains(c)) {
                stack.push(c);
            } else {
                if (stack.size() == 0) return false;
                char open = getOpen(c);
                char top = stack.pop();
                if (top != open) return false;
            }
        }
        return stack.size() == 0;
    }
    private char getOpen(char c) {
        switch (c) {
            case '}':
                return '{';
            case ')':
                return '(';
            case ']':
                return '[';
            default:
                return '0';
        }
    }
}