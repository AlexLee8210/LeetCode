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
        Map<Node, Node> clones = new HashMap<>();
        Set<Node> vis = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node og = queue.poll();
            if (vis.contains(og)) continue;
            vis.add(og);
            if (!clones.containsKey(og)) {
                clones.put(og, new Node(og.val));
            }
            Node clone = clones.get(og);

            for (Node n : og.neighbors) {
                if (clones.containsKey(n)) {
                    Node nclone = clones.get(n);
                    clone.neighbors.add(nclone);
                } else {
                    Node nclone = new Node(n.val);
                    clones.put(n, nclone);
                    clone.neighbors.add(nclone);
                    queue.offer(n);
                }
            }
        }
        return clones.get(node);
    }
}