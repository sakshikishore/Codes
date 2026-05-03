class Solution {
    public int[] countOppositeParity(int[] nums) {
        int suf[][] = new int[nums.length][2];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                if (nums[i] % 2 == 0) {
                    suf[i][0] = 1;
                } else {
                    suf[i][1] = 1;
                }
            } else {
                if (nums[i] % 2 == 0) {
                    suf[i][0] = 1 + suf[i + 1][0];
                    suf[i][1] = suf[i + 1][1];
                } else {
                    suf[i][0] = suf[i + 1][0];
                    suf[i][1] = suf[i + 1][1] + 1;
                }
            }
        }
        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] % 2 == 0) {
                result[i] = suf[i + 1][1];
            } else {
                result[i] = suf[i + 1][0];
            }
        }

        return result;
    }
}
