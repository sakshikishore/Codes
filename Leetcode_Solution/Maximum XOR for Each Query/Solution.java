class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int max=(int)Math.pow(2,maximumBit);
        int result[]=new int[nums.length];
        int p=nums[nums.length-1];
        int q=Math.max(max-1,p);
        for(int i=0;i<nums.length;i++)
        {
            q=q^nums[i];
            result[nums.length-1-i]=q;
        }
        
        return result;
        
    }
}
