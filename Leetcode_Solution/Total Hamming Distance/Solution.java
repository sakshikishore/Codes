class Solution {
    public int totalHammingDistance(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                
                int p=nums[i]^nums[j];
                result=result+Integer.bitCount(p);         
                
            }
        }
        return result;
        
    }
}
