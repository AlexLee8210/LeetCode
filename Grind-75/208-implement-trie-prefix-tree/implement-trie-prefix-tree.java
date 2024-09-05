class Trie {

    private class Node {
        boolean end;
        Node[] adj;
        public Node() {
            end = false;
            adj = new Node[26];
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.adj[c - 'a'] == null) cur.adj[c - 'a'] = new Node();
            cur = cur.adj[c - 'a'];
        }
        cur.end = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.adj[c - 'a'] == null) return false;
            cur = cur.adj[c - 'a'];
        }
        return cur.end;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.adj[c - 'a'] == null) return false;
            cur = cur.adj[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */