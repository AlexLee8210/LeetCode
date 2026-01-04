class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int l = 0, r = points.length - 1;
        int p = points.length;
        while (p != k) {
            p = partition(points, l, r);
            if (p < k) {
                l = p + 1;
            } else if (p > k) {
                r = p - 1;
            }
        }
        return Arrays.copyOf(points, k);
    }

    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] arr, int i, int j) {
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int partition(int[][] points, int l, int r) {
        int pivot = dist(points[r]);

        int i = l;
        for (int j = l; j < r; ++j) {
            if (dist(points[j]) < pivot) {
                swap(points, i++, j);
            }
        }
        swap(points, i, r);
        return i;
    }
}