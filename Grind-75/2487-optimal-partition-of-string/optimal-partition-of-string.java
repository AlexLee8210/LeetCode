class Solution {
    public int partitionString(String s) {
        int partition = 0;
        int[] partitions = new int[26];
        for (char c : s.toCharArray()) {
            if (partition == partitions[c - 'a']) {
                ++partition;
            }
            partitions[c - 'a'] = partition;
        }
        return partition;
    }
}