class WordDistance {

    HashMap<String, TreeSet<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (!map.containsKey(wordsDict[i])) {
                map.put(wordsDict[i], new TreeSet<>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        TreeSet<Integer> word2Set = map.get(word2);
        for (int i : map.get(word1)) {
            Integer floor = word2Set.floor(i);
            Integer ceiling = word2Set.ceiling(i);
            if (floor == null && ceiling == null) {
                continue;
            } else if (floor == null) {
                min = Math.min(ceiling - i, min);
            } else if (ceiling == null) {
                min = Math.min(i - floor, min);
            } else {
                int dist = Math.min(i - floor, ceiling - i);
                min = Math.min(dist, min);
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */