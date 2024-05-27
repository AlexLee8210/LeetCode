class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l <= r) {
            if (!Character.isLetterOrDigit(chars[l])) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[r])) {
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