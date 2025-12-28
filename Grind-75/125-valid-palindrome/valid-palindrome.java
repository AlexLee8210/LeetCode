class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(chars[l])) {
                ++l;
            }
            while (l < r && !Character.isLetterOrDigit(chars[r])) {
                --r;
            }
            if (Character.toLowerCase(chars[l]) != Character.toLowerCase(chars[r])) {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }
}