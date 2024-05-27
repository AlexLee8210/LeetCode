class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l <= r) {
            if (!(Character.isDigit(chars[l]) || Character.isLetter(chars[l]))) {
                l++;
                continue;
            }
            if (!(Character.isDigit(chars[r]) || Character.isLetter(chars[r]))) {
                r--;
                continue;
            }
            if (Character.toLowerCase(chars[l]) != Character.toLowerCase(chars[r])) return false;
            l++;
            r--;
        }
        return true;
    }
}