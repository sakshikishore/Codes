class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length / 2) {
                continue;
            }
            if (nums[i] == nums[nums.length / 2]) {
                return false;
            }
        }

        return true;

    }
}
