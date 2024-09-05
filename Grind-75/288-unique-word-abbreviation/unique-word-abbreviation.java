class ValidWordAbbr {
    HashMap<String, HashSet<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String k : dictionary) {
            String ab = abbr(k);
            if (!map.containsKey(ab)) {
                HashSet<String> set = new HashSet<>();
                set.add(k);
                map.put(ab, set);
            } else {
                map.get(ab).add(k);
            }
        }
    }

    private String abbr(String k) {
        if (k.length() <= 2) return k;
        StringBuilder sb = new StringBuilder();
        sb.append(k.charAt(0)).append(k.length() - 2).append(k.charAt(k.length() - 1));
        return sb.toString();
    }
    
    public boolean isUnique(String word) {
        String ab = abbr(word);
        if (!map.containsKey(ab)) return true;
        HashSet<String> set = map.get(ab);
        return set.size() == 1 && set.contains(word);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */