class Solution {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        boolean isPos = true;
        int num = 0;
        while (i < chars.length && chars[i] == ' ') i++;
        if (i < chars.length && (chars[i] == '-' || chars[i] == '+')) {
            isPos = chars[i++] == '+';
        }
        while (i < chars.length && Character.isDigit(chars[i])) {
            if (num > Integer.MAX_VALUE / 10
                || (num == Integer.MAX_VALUE / 10 && chars[i] >= (isPos ? '7' : '8')))
            {
                num = isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                return num;
            }
            num = num * 10 + (chars[i] - '0');
            i++;
        }
        return isPos ? num : -num;
    }
}