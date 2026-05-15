class Solution {
    public long minIncrease(int[] nums) {
        long ans[] = new long[nums.length];
        int count[] = new int[nums.length];
        for (int i = 1; i < nums.length - 1; i++) {
            if (i == 1) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    ans[i] = 0l;
                } else {
                    ans[i] = Math.max(nums[i + 1] - nums[i], nums[i - 1] - nums[i]) + 1l;
                }
                count[i] = 1;
            } else if (i == 2) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    ans[i] = 0l;
                } else {
                    ans[i] = Math.max(nums[i + 1] - nums[i], nums[i - 1] - nums[i]) + 1l;
                }
                count[i] = 1;
            } else if (i == 3) {
                ans[i] = ans[1];
                if (nums[i] <= nums[i + 1] || nums[i] <= nums[i - 1]) {
                    ans[i] = ans[i] + Math.max(nums[i + 1] - nums[i], nums[i - 1] - nums[i]) + 1l;
                }
                count[i] = 2;
            } else {
                if (count[i - 2] == count[i - 3]) {
                    ans[i] = Math.min(ans[i - 2], ans[i - 3]);
                } else {
                    ans[i] = ans[i - 2];
                }
                count[i] = count[i - 2] + 1;
                if (nums[i] <= nums[i + 1] || nums[i] <= nums[i - 1]) {
                    ans[i] = ans[i] + Math.max(nums[i + 1] - nums[i], nums[i - 1] - nums[i]) + 1l;
                }
            }
        }
        if (nums.length % 2 == 0) {
            return Math.min(ans[ans.length - 2], ans[ans.length - 3]);
        }

        return ans[ans.length - 2];

    }
}
