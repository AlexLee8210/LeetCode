class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int[] nums = new int[(int)Math.pow(10, 6) + 1];
        for (int[] interval : intervals) {
            nums[interval[0]]++;
            nums[interval[1]]--;
        }

        int sum = 0;
        for (int n : nums) {
            sum += n;
            if (sum > 1) {
                return false;
            }
        }
        return true;
    }
}