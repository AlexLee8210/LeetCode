class LRUCache {

    private class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head, tail;

    private void add(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    HashMap<Integer, Node> cache;
    int capacity;

    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;

        this.capacity = capacity;
        cache = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        remove(node);
        add(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            add(node);
            node.value = value;

            return;
        }

        // new k,v pair
        if (cache.size() == capacity) {
            Node lruNode = head.next;
            cache.remove(lruNode.key);
            remove(lruNode);
        }

        Node node = new Node(key, value);
        add(node);
        cache.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */