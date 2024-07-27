class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int idx = bs(arr, x);
        int cnt = 1;
        int l = idx - 1, r = idx + 1;
        while (cnt < k && (l >= 0 || r < arr.length)) {
            int diffL = l >= 0 ? Math.abs(arr[l] - x) : Integer.MAX_VALUE;
            int diffR = r < arr.length ? Math.abs(arr[r] - x) : Integer.MAX_VALUE;
            if (diffL <= diffR) {
                l--;
            } else {
                r++;
            }
            cnt++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = l + 1; i < r; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    private int bs(int[] arr, int x) {
        if (x <= arr[0]) return 0;
        if (x >= arr[arr.length - 1]) return arr.length - 1;

        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] > x) {
                if (m > 0 && arr[m - 1] <= x) {
                    return arr[m] - x >= x - arr[m - 1] ? m - 1 : m;
                }
                r = m - 1;
            } else if (arr[m] < x) {
                if (m < arr.length - 1 && arr[m + 1] >= x) {
                    return arr[m + 1] - x >= x - arr[m] ? m : m + 1;
                }
                l = m + 1;
            } else {
                return m;
            }
        }
        return l;
    }
}