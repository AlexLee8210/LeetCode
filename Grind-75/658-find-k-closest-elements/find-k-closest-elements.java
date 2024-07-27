class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (r - l >= k) {
            if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
                l++;
            } else {
                r--;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (l <= r) {
            res.add(arr[l++]);
        }
        return res;
    }
}