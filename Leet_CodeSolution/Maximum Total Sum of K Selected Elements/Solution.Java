class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        long sum = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (mul >0) {
                sum += (nums[i]*1l * mul);
            } else {
                sum = sum + nums[i];
            }
            mul--;
            k--;
            if (k == 0) {
                break;
            }
        }

        return sum;
    }
}
