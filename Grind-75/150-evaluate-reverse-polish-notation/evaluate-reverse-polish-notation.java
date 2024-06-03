class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for (String token : tokens) {
            try {
                int n = Integer.parseInt(token);
                numStack.push(n);
            } catch (Exception e) {
                int n2 = numStack.pop();
                int n1 = numStack.pop();
                numStack.push(op(token, n1, n2));
            }
        }
        return numStack.pop();
    }

    private int op(String op, int n1, int n2) {
        switch (op) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                return n1 / n2;
        }
        return 0;
    }
}