class LRUCache {

    private class Node {
        int key;
        int value;
        Node next, prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int cap;
    private HashMap<Integer, Node> map;

    private Node head, tail;

    private void add(Node n) {
        n.prev = tail.prev;
        n.next = tail;
        tail.prev.next = n;
        tail.prev = n;
    }

    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            n.value = value;
            add(n);
        } else {
            if (map.size() == cap) {
                Node n = head.next;
                remove(n);
                map.remove(n.key);
            }
            Node n = new Node(key, value);
            add(n);
            map.put(key, n);
        }
    }
}
