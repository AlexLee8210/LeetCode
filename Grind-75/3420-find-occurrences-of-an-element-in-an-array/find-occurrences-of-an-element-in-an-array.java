class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        // int[] index = new int[100001];
        // Arrays.fill(index, -1);
        HashMap<Integer, Integer> index = new HashMap<>();
        int occ = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (x == nums[i]) {
                index.put(++occ, i);
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            res[i] = index.getOrDefault(queries[i], -1);
        }
        return res;
    }
}