class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int max = Math.max(v1.length, v2.length);
        
        for (int i = 0; i < max; ++i) {
            int n1 = i >= v1.length ? 0 : Integer.parseInt(v1[i]);
            int n2 = i >= v2.length ? 0 : Integer.parseInt(v2[i]);

            if (n1 == n2) continue;
            return n1 < n2 ? -1 : 1;
        }

        return 0;
    }
}