class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int result=0;
        int startIndex=0,endIndex=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                startIndex=i;
            }
            if(nums[i]==nums.length)
            {
                endIndex=i;
            }
        }
        if(startIndex>endIndex)
        {
            endIndex++;
        }
         result=startIndex+nums.length-1-endIndex;
        
        return result;
        
        
    }
}
