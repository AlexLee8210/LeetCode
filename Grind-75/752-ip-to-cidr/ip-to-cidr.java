class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        List<String> blocks = new ArrayList<>();
        long val = ipToLong(ip);
        while (n > 0) {
            long sig = val & (-val);
            if (sig == 0) sig = 1L << 32;
            while (sig > n) {
                sig >>= 1;
            }
            blocks.add(longToCIDR(val, sig));
            val += sig;
            n -= sig;
        }
        return blocks;
    }

    private long ipToLong(String ip) {
        String[] groups = ip.split("\\.");
        long res = 0;
        for (int i = 0; i < groups.length; ++i) {
            res <<= 8;
            res += Long.parseLong(groups[i]);
        }
        return res;
    }

    private String longToCIDR(long val, long sig) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; ++i) {
            sb.insert(0, ".").insert(0, val & 255);
            val >>= 8;
        }
        sb.setCharAt(sb.length() - 1, '/');
        int length = 33;
        while (sig > 0) {
            sig >>= 1;
            --length;
        }
        sb.append(length);
        return sb.toString();
    }
}