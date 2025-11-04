class Solution {

    private static final int NUM_GROUPS = 4;
    private static final int GROUP_SIZE = 8; // in bits

    public List<String> ipToCIDR(String ip, int n) {
        long cur = ipToLong(ip);
        List<String> res = new ArrayList<>();

        while (n > 0) {
            long zeros = cur & (-cur);
            if (zeros == 0) zeros = (long) 1 << (NUM_GROUPS * GROUP_SIZE);
            while (zeros > n) {
                zeros >>= 1;
            }
            res.add(ipToString(cur, (int) zeros));
            cur += zeros;
            n -= zeros;
        }
        return res;
    }

    private String ipToString(long ip, int zeros) {
        int[] groups = new int[NUM_GROUPS];
        for (int i = 0; i < NUM_GROUPS; ++i) {
            groups[i] = (int) (ip & ((1 << GROUP_SIZE) - 1));
            ip >>= GROUP_SIZE;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = NUM_GROUPS - 1; i >= 0; --i) {
            sb.append(groups[i]).append(".");
        }
        sb.setCharAt(sb.length() - 1, '/');

        int len = NUM_GROUPS * GROUP_SIZE + 1;
        while (zeros > 0) {
            zeros >>= 1;
            --len;
        }
        sb.append(len);
        return sb.toString();
    }

    private long ipToLong(String ip) {
        long val = 0;
        String[] groups = ip.split("\\.");
        for (int i = 0; i < groups.length; ++i) {
            val *= (1 << GROUP_SIZE);
            val += Long.parseLong(groups[i]);
        }
        return val;
    }
}