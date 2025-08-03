class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> trips = new HashSet<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; ++j) {
                int numK = - (nums[i] + nums[j]);
                if (map.containsKey(numK)) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(numK);
                    Collections.sort(list);
                    trips.add(list);
                }
                map.put(nums[j], j);
            }
        }

        return new ArrayList<>(trips);
    }
}