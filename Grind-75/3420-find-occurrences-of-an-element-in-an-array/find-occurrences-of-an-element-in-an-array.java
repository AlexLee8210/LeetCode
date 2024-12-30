class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int max = Integer.MIN_VALUE;
        for (int q : queries) {
            max = Math.max(max, q);
        }

        int[] index = new int[max + 1];
        Arrays.fill(index, -1);
        int occ = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (occ >= max) break;
            if (x == nums[i]) {
                index[++occ] = i;
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            res[i] = index[queries[i]];
        }
        return res;
    }
}