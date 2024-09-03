class WordDistance {
    HashMap<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (!map.containsKey(wordsDict[i])) {
                map.put(wordsDict[i], new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            int idx1 = list1.get(i);
            int idx2 = list2.get(j);
            if (idx1 < idx2) {
                min = Math.min(min, idx2 - idx1);
                i++;
            } else {
                min = Math.min(min, idx1 - idx2);
                j++;
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