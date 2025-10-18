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
        Map<Integer, Node> map = new HashMap<>();
        return helper(node, map, new HashSet<>());
    }

    private Node helper(Node node, Map<Integer, Node> map, Set<Integer> vis) {
        if (node == null) return null;
        if (vis.contains(node.val)) return map.get(node.val);
        
        Node clone = new Node(node.val);
        vis.add(node.val);
        map.put(node.val, clone);
        for (Node n : node.neighbors) {
            clone.neighbors.add(helper(n, map, vis));
        }

        return clone;
    }
}