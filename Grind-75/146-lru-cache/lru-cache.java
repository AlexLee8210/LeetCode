class LRUCache {
    private class Node {
        int key;
        int val;
        Node prev, next;
        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    HashMap<Integer, Node> cache;
    int cap;
    Node head, tail;

    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void add(Node n) {
        Node lastNode = tail.prev;
        lastNode.next = n;
        n.prev = lastNode;
        n.next = tail;
        tail.prev = n;
    }

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>(cap + 1);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node n = cache.get(key);
        remove(n);
        add(n);

        return n.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node n = new Node(key, value);
        cache.put(key, n);
        add(n);
        if (cache.size() > cap) {
            Node lru = head.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    // private void print() {
    //     if (head.next == tail) {
    //         System.out.println("[]");
    //         return;
    //     }
    //     Node cur = head.next;
    //     StringBuilder sb = new StringBuilder();
    //     sb.append("[");
    //     while (cur != tail) {
    //         sb.append(cur.key).append(", ");
    //         cur = cur.next;
    //     }
    //     sb.delete(sb.length() - 2, sb.length());
    //     sb.append("]");
    //     System.out.println(sb);
    // }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */