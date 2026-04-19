class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int prefMax[] = new int[nums.length];
        int sufMin[] = new int[nums.length];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            prefMax[i] = max;
        }
        int min = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < min) {
                min = nums[i];
            }
            sufMin[i] = min;
        }
        for (int i = 0; i < nums.length; i++) {
            if (prefMax[i] - sufMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}
