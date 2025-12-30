class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int m1 = kthSmallest(nums1, nums2, m, n, 0, 0, (m + n + 1) / 2);
        if ((n + m) % 2 == 1) {
            return m1;
        }
        return (double) (m1 + kthSmallest(nums1, nums2, m, n, 0, 0, (m + n) / 2 + 1)) / 2;
    }

    private int kthSmallest(int[] a, int[] b, int aLen, int bLen, int aStart, int bStart, int k) {
        if (aLen > bLen) return kthSmallest(b, a, bLen, aLen, bStart, aStart, k);
        if (aLen == 0) return b[bStart + k - 1];
        if (k == 1) return Math.min(a[aStart], b[bStart]);
        
        int i = Math.min(aLen, k / 2);
        int j = Math.min(bLen, k / 2);

        // kth smallest elem cannot be in a
        if (a[aStart + i - 1] <= b[bStart + j - 1]) {
            return kthSmallest(a, b, aLen - i, bLen, aStart + i, bStart, k - i);
        } else {
            return kthSmallest(a, b, aLen, bLen - j, aStart, bStart + j, k - j);
        }
    }
}