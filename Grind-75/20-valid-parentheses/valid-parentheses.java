class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> openToClose = Map.of(
            '(', ')',
            '{', '}',
            '[', ']'
        );

        for (char c : s.toCharArray()) {
            if (openToClose.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char open = stack.pop();
                if (c != openToClose.get(open)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}