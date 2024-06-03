class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for (String token : tokens) {
            int n = process(token, numStack);
            numStack.push(n);
        }
        return numStack.pop();
    }

    private int process(String token, Stack<Integer> stack) {
        switch (token) {
            case "+":
                return stack.pop() + stack.pop();
            case "-":
                int n = stack.pop();
                return stack.pop() - n;
            case "*":
                return stack.pop() * stack.pop();
            case "/":
                n = stack.pop();
                return stack.pop() / n;
            default:
                return Integer.parseInt(token);
        }
    }
}