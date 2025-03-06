class LRUCache {

    private class DLNode {
        public DLNode prev;
        public DLNode next;
        public int val;

        public DLNode(int val) {
            this.val = val;
        }
    }

    HashMap<Integer, Integer> cache;
    HashMap<Integer, DLNode> nodeMap;
    DLNode head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity + 1);
        nodeMap = new HashMap<>(capacity + 1);
        head = new DLNode(0);
        tail = new DLNode(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        if (nodeMap.containsKey(key)) {
            remove(nodeMap.get(key));
        }
        DLNode nodeToAdd = new DLNode(key);
        add(nodeToAdd);

        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            remove(nodeMap.get(key));
        }
        cache.put(key, value);
        DLNode nodeToAdd = new DLNode(key);
        add(nodeToAdd);

        if (cache.size() > capacity) {
            cache.remove(head.next.val);
            nodeMap.remove(head.next.val);
            remove(head.next);
        }
    }

    private void remove(DLNode nodeToRemove) {
        nodeToRemove.prev.next = nodeToRemove.next;
        nodeToRemove.next.prev = nodeToRemove.prev;
    }

    private void add(DLNode nodeToAdd) {
        nodeToAdd.prev = tail.prev;
        nodeToAdd.next = tail;
        tail.prev.next = nodeToAdd;
        tail.prev = nodeToAdd;

        nodeMap.put(nodeToAdd.val, nodeToAdd);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */