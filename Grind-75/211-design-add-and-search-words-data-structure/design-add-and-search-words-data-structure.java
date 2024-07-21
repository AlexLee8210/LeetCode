class WordDictionary {

    private class Node {
        char val;
        Node[] children;
        boolean isEnd;
        public Node(char v) {
            val = v;
            children = new Node[26];
        }
    }

    Node root;
    public WordDictionary() {
        root = new Node('.');
    }
    
    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Node(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] chars, int index, Node par) {
        if (index == chars.length) return par.isEnd;
        if (chars[index] == '.') {
            for (Node child : par.children) {
                if (child == null) continue;
                if (search(chars, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }
        Node child = par.children[chars[index] - 'a'];
        if (child == null) return false;
        return search(chars, index + 1, child);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */