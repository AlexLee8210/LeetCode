class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < strs[0].length()) {
            char cur = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= index) return sb.toString();
                if (strs[i].charAt(index) != cur) return sb.toString();
            }
            sb.append(cur);
            index++;
        }
        return sb.toString();
    }
}