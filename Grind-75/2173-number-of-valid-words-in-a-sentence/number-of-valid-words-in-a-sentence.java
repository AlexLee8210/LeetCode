class Solution {
    public int countValidWords(String sentence) {
        int cnt = 0;
        boolean isValid = false;
        int hyphens = 0;
        char[] chars = sentence.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (isValid) {
                    cnt++;
                    isValid = false;
                }
                hyphens = 0;
            } else if (Character.isDigit(chars[i])) {
                isValid = false;
            } else if (Character.isLetter(chars[i])) {
                if ((i > 0 && chars[i - 1] == ' ') || i == 0) {
                    isValid = true;
                }
            } else if (chars[i] == '-') {
                if (i == 0 || i == chars.length - 1 || !Character.isLetter(chars[i - 1]) || !Character.isLetter(chars[i + 1])) {
                    isValid = false;
                }
                if (hyphens > 0) {
                    isValid = false;
                }
                hyphens++;
            } else {
                if (!(i + 1 == chars.length || chars[i + 1] == ' ')) {
                    isValid = false;
                } else if ((i == 0 || chars[i - 1] == ' ') && (i + 1 == chars.length || chars[i + 1] == ' ')) {
                    isValid = true;
                }
            }
        }
        return cnt += isValid ? 1 : 0;
    }
}