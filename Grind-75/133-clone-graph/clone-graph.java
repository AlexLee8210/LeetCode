/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node[] nodes = new Node[101];
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            Node original = q.poll();
            if (nodes[original.val] == null) {
                nodes[original.val] = new Node(original.val);
            }
            
            if (!nodes[original.val].neighbors.isEmpty()) continue;

            for (Node neighbor : original.neighbors) {
                if (nodes[neighbor.val] == null) {
                    nodes[neighbor.val] = new Node(neighbor.val);
                }
                nodes[original.val].neighbors.add(nodes[neighbor.val]);
                q.offer(neighbor);
            }
        }

        return nodes[node.val];
    }
}