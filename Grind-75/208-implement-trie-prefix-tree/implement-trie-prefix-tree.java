class Trie {

    private class Node {
        public Node[] alph;
        public boolean isEnd;

        public Node() {
            alph = new Node[26];
            isEnd = false;
        }

        public Node insert(char c) {
            if (alph[c - 'a'] == null) {
                alph[c - 'a'] = new Node();
            }
            return alph[c - 'a'];
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            cur = cur.insert(c);
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        int idx = 0;
        while (idx < word.length() && cur != null) {
            cur = cur.alph[word.charAt(idx) - 'a'];
            ++idx;
        }
        return idx == word.length() && cur != null && cur.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        int idx = 0;
        while (idx < prefix.length() && cur != null) {
            cur = cur.alph[prefix.charAt(idx) - 'a'];
            ++idx;
        }
        return idx == prefix.length() && cur != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */