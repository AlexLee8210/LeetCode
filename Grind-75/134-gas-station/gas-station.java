class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
            sum += gas[i];
        }
        if (sum < 0) return -1;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }
}