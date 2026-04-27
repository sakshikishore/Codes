class Solution {
    public int compareBitonicSums(int[] nums) {
        long ascendingSum = nums[0];
        long descendingSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                descendingSum = nums[i];
                ascendingSum += nums[i];
            } else {
                descendingSum += nums[i];
            }
        }

        if (descendingSum == ascendingSum) {
            return -1;
        } else if (ascendingSum > descendingSum) {
            return 0;
        }

        return 1;
    }
}
