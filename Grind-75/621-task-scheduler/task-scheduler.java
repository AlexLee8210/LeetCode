class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnts = new int[26];
        int max = 0;
        int numMax = 0;
        for (char task : tasks) {
            cnts[task - 'A']++;
            if (max < cnts[task - 'A']) {
                max = cnts[task - 'A'];
                numMax = 1;
            } else if (max == cnts[task - 'A']) {
                numMax++;
            }
        }
        int numSpaces = max - 1;
        int spaceCount = numSpaces * (n - numMax + 1);
        int numIdles = Math.max(0, spaceCount - tasks.length + (numMax * max));
        return numIdles + tasks.length;
    }
}