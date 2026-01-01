/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node cur = head;
        Node prev = new Node(-1);
        while (cur != null) {
            if (!map.containsKey(cur)) {
                map.put(cur, new Node(cur.val));
            }

            Node copy = map.get(cur);
            prev.next = copy;

            if (cur.random != null) {
                if (!map.containsKey(cur.random)) {
                    map.put(cur.random, new Node(cur.random.val));
                }

                Node rand = map.get(cur.random);
                copy.random = rand;
            }

            prev = copy;
            cur = cur.next;
        }

        return map.get(head);
    }
}