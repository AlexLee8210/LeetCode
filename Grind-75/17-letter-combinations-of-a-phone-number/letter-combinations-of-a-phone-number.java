class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        
        ArrayList<String> res = new ArrayList<>();
        helper(digits, map, 0, res, new StringBuilder());
        return res;
    }

    private void helper(String digits, HashMap<Character, char[]> map, int index, ArrayList<String> res, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (char c : map.get(digits.charAt(index))) {
            sb.append(c);
            helper(digits, map, index + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}