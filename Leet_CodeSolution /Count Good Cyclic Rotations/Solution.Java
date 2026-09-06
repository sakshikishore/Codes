class Solution {
    public int countGoodRotations(int[] nums) {
        long midSum = 0, totalSum = 0;
        int ans=0;
        int mid=(nums.length/2)-1;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            if (i == (nums.length / 2) - 1) {
                midSum = totalSum;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (midSum> totalSum - midSum) {
                        ans++;
                }
            }
            else
            {
                midSum=midSum-nums[i-1];
                midSum+=nums[(mid+i)%nums.length];
                  if (midSum> (totalSum - midSum)) {
                        ans++;
                }                
            }
        }

        return ans;
    }
}
