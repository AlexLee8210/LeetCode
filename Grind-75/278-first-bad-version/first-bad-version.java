/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 0;
        int ans = -1;
        while (l <= n) {
            int m = l + (n - l) / 2;
            if (isBadVersion(m)) {
                ans = m;
                n = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}