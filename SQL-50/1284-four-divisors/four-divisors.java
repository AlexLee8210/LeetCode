class Solution {
    public int sumFourDivisors(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0, cnt = 0;
            for (int j = 1; j <= Math.sqrt(nums[i]); j++) {
                if (nums[i] % j == 0) {
                    if (nums[i] / j == j) {
                        sum += j;
                        cnt++;
                    } else {
                        sum += nums[i] / j + j;
                        cnt += 2;
                    }
                }
            }
                System.out.println(sum);
            if (cnt == 4) total += sum;
        }
        return total;
    }
}