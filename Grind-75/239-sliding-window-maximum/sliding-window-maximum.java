class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        
        for (int i = 0; i < k; i++) {
            tmap.put(nums[i], tmap.getOrDefault(nums[i], 0) + 1);
        }
        res[index++] = tmap.lastKey();

        for (int i = k; i < nums.length; i++) {
            int freq = tmap.get(nums[i - k]);
            if (freq > 1) {
                tmap.put(nums[i - k], freq - 1);
            } else {
                tmap.remove(nums[i - k]);
            }
            tmap.put(nums[i], tmap.getOrDefault(nums[i], 0) + 1);

            res[index++] = tmap.lastKey();
        }
        return res;
    }
}