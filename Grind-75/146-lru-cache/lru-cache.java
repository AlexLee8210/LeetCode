class LRUCache {

    private class DLNode {
        public DLNode prev;
        public DLNode next;
        public int key;
        public int value;

        public DLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, DLNode> cache;
    DLNode head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new DLNode(0, 0);
        tail = new DLNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        DLNode node = cache.get(key);
        remove(node);
        add(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLNode node = cache.get(key);
            remove(node);
            add(node);
            node.value = value;
            return;
        }

        DLNode node = new DLNode(key, value);
        if (cache.size() == capacity) {
            cache.remove(head.next.key);
            remove(head.next);
        }

        add(node);
        cache.put(key, node);
    }

    private void remove(DLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(DLNode node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */