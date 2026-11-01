class Solution {
    public int minMergedInteger(int[] nums) {
        int min = 10001001;
        for (int i = 0; i < nums.length; i = i + 2) {
            if (nums[i + 1] <= 9) {
                int val = (nums[i] * 10) + nums[i + 1];
                if (val < min) {
                    min = val;
                }
            } else if (nums[i + 1] < 100) {
                int val = (nums[i] * 100) + nums[i + 1];
                if (val < min) {
                    min = val;
                }
            } else if (nums[i+1] < 1000) {
                int val = (nums[i] * 1000) + nums[i + 1];
                if (val < min) {
                    min = val;
                }
            } else {
                int val = (nums[i] * 10000) + nums[i + 1];
                if (val < min) {
                    min = val;
                }
            }
        }
        return min;


    }
}
