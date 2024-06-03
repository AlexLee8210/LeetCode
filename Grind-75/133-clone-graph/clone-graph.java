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
        return cloneGraphHelper(node, new HashMap<Integer, Node>());
    }

    // return clone
    private Node cloneGraphHelper(Node node, HashMap<Integer, Node> vis) {
        if (vis.containsKey(node.val)) {
            return vis.get(node.val);
        }
        Node newNode = new Node(node.val);
        vis.put(node.val, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraphHelper(neighbor, vis));
        }
        return newNode;
    }
}