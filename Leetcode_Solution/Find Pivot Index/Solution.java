class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        int result=-1;
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
        }
        int k=0;
        for(int i=0;i<nums.length;i++)
        {
            sum=sum-nums[i];
            if(i-1>=0)
            {
                k=k+nums[i-1];
    
            }
            if(k==sum)
            {
                result=i;
                break;
            }
            
        }
        
        return result;
    }
}
