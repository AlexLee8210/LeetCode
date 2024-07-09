class Solution {

    private class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int a) {
            if (parent[a] == a) {
                return a;
            }
            int par = find(parent[a]);
            parent[a] = par;
            return par;
        }

        public boolean union(int a, int b) {
            int root1 = find(a);
            int root2 = find(b);
            if (root1 == root2) {
                return false;
            } else if (rank[root2] > rank[root1]) {
                parent[root1] = root2;
                rank[root2] += rank[root1];
            } else {
                parent[root2] = root1;
                rank[root1] += rank[root2];
            }
            return true;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());

        HashMap<String, Integer> emailToId = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToId.containsKey(email)) {
                    uf.union(i, emailToId.get(email));
                } else {
                    emailToId.put(email, i);
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> idToEmails = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int id = uf.find(emailToId.get(email));
            if (idToEmails.containsKey(id)) {
                ArrayList<String> list = idToEmails.get(id);
                list.add(email);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(email);
                idToEmails.put(id, list);
            }
        }
        for (int id : idToEmails.keySet()) {
            ArrayList<String> emails = idToEmails.get(id);
            Collections.sort(emails);
            emails.add(0, accounts.get(id).get(0));
            result.add(emails);
        }
        return result;
    }
}