class Trie {

    private class Node {
        public char val;
        public HashMap<Character, Node> adj;
        public boolean end;
        public Node(char _val) {
            val = _val;
            adj = new HashMap<>();
            end = false;
        }

        public boolean hasAdj(char c) {
            return adj.containsKey(c);
        }
        public Node addAdj(char c) {
            if (hasAdj(c)) return adj.get(c);
            Node newNode = new Node(c);
            adj.put(c, newNode);
            return newNode;
        }
    }

    private Node root;

    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            cur = cur.addAdj(c);
        }
        cur.end = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.hasAdj(c)) return false;
            cur = cur.adj.get(c);
        }
        return cur.end;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.hasAdj(c)) return false;
            cur = cur.adj.get(c);
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