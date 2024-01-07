class Solution {
    public int minOperations(int[] nums, int k) {
        int x=0;
        for(int i=0;i<nums.length;i++)
        {
            x=x^nums[i];
        }
        
        return Integer.bitCount(x^k);
    }
}
