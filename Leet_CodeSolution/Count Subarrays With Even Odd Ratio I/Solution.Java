class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int count = 0;
        double t = a * 1.0;
        t = t / b;
        for (int i = 0; i < nums.length; i++) {
            double x = 0, y = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 0) {
                    x++;
                } else {
                    y++;
                }
                if (y > 0) {
                    double p = x / y;
                    if (p <= t) {
                        count++;
                    }
                }
            }
        }

        return count;

    }
}
