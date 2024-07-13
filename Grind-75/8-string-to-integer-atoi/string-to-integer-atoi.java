// class Solution {
//     public int myAtoi(String s) {
//         int num = 0;
//         boolean isPos = true;
//         boolean readingZero = true;
//         boolean readingNum = false;
//         for (char c : s.toCharArray()) {
//             if ((readingNum && readingZero) && !Character.isDigit(c)) break;
//             if (c == ' ') continue;
//             if (c == '-') {
//                 isPos = false;
//             } else if (Character.isDigit(c)) {
//                 readingNum = true;
//                 if (c == '0' && readingZero) {
//                     readingZero = true;
//                     continue;
//                 }
//                 num *= 10;
//                 num += c - '0';
//             }
//         }
//         return isPos ? num : -num;
//     }
// }
class Solution {
    public int myAtoi(String s) {
        int num = 0;
        boolean isPos = true;
        boolean reading = true;
        boolean readingZero = false;
        for (char c : s.toCharArray()) {
            if (!reading && !Character.isDigit(c)) break;
            if (c == ' ') continue;
            if (c == '-' || c == '+') {
                isPos = c == '+';
                reading = false;
            } else if (Character.isDigit(c)) {
                reading = false;
                if (c == '0' && readingZero) {
                    readingZero = true;
                    continue;
                } else {
                    readingZero = false;
                }

                if (num > Integer.MAX_VALUE / 10) {
                    return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else if (num == Integer.MAX_VALUE / 10) {
                    if (isPos) {
                        if (c >= '7') {
                            return Integer.MAX_VALUE;
                        }
                    } else if (c >= '8') {
                        return Integer.MIN_VALUE;
                    }
                }
                num *= 10;
                num += c - '0';
            } else {
                if (reading && (c != ' ' || c != '-' || c != '+')) break;
                reading = false;
            }
        }
        return isPos ? num : -num;
    }
}