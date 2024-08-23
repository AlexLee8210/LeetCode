class Solution {
    public String fractionAddition(String expression) {
        Stack<Integer> numerators = new Stack<>();
        Stack<Integer> denominators = new Stack<>();
        int cur = 0;
        boolean isPositive = true;
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                cur *= 10;
                cur += (int)(c - '0');
            } else if (c == '/') {
                numerators.push(cur * (isPositive ? 1 : -1));
                isPositive = true;
                cur = 0;
            } else { // c == '-' or '+'
                if (i - 1 >= 0 && chars[i - 1] != '/') {
                    denominators.push(cur * (isPositive ? 1 : -1));
                    cur = 0;

                    if (denominators.size() > 1) {
                        int n2 = numerators.pop();
                        int n1 = numerators.pop();
                        int d2 = denominators.pop();
                        int d1 = denominators.pop();
                        int gcd = gcd(d1, d2);
                        n2 *= d1 / gcd;
                        n1 *= d2 / gcd;
                        numerators.push(n1 + n2);
                        denominators.push(d1 / gcd * d2);
                    }
                }
                isPositive = c == '+';
            }
        }
        denominators.push(cur * (isPositive ? 1 : -1));


        if (denominators.size() > 1) {
            int n2 = numerators.pop();
            int n1 = numerators.pop();
            int d2 = denominators.pop();
            int d1 = denominators.pop();
            int gcd = gcd(d1, d2);
            n2 *= d1 / gcd;
            n1 *= d2 / gcd;
            numerators.push(n1 + n2);
            denominators.push(d1 / gcd * d2);
        }
        int numerator = numerators.pop();
        int denominator = denominators.pop();
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {
            denominator *= -1;
            numerator *= -1;
        }
        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}