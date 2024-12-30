class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] index = new int[100001];
        Arrays.fill(index, -1);
        int occ = 0;
        for (int i = 0; i < nums.length; ++i) {
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