class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            int last_div = 0;
            for (int div = 2; div <= Math.sqrt(n); div++) {
                if (n % div == 0) {
                    if (last_div == 0) {
                        last_div = div;
                    } else {
                        last_div = 0;
                        break;
                    }
                }
            }
            if (last_div != 0 && last_div != n / last_div) {
                sum += 1 + n + n / last_div + last_div;
            }
        }
        return sum;
    }
}