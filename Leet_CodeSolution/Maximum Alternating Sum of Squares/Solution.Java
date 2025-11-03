class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = nums[i] * (-1);
            }
        }
        Arrays.sort(nums);
        int mid = nums.length / 2;
        long p = 0, q = 0;
        for (int i = 0; i < mid; i++) {
            long r = nums[i] * 1l;
            r = r * nums[i];
            p = p + r;
        }
        for (int i = mid; i < nums.length; i++) {
            long r = nums[i] * 1l;
            r = r * nums[i];
            q = q + r;
        }

        return q - p;
    }
}
