class Solution {
    private class Unit {
        StringBuilder sb;
        int k;
        public Unit(int _k) {
            k = _k;
        }
    }
    public String decodeString(String s) {
        s = "1[" + s + "]";
        return decode(s.toCharArray(), new int[1]).toString();
    }

    private StringBuilder decode(char[] chars, int[] start) {
        int k = 0;
        while (Character.isDigit(chars[start[0]])) {
            k *= 10;
            k += chars[start[0]++] - '0';
        }
        // now chars[start[0]] = '['
        start[0]++;

        StringBuilder sb = new StringBuilder();
        while (chars[start[0]] != ']') {
            while (Character.isLetter(chars[start[0]])) {
                sb.append(chars[start[0]++]);
            }
            // if it is an encoded string.
            if (Character.isDigit(chars[start[0]])) {
                sb.append(decode(chars, start));
            }
        }
        start[0]++;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < k; i++) {
            res.append(sb);
        }
        return res;
        
    }
}