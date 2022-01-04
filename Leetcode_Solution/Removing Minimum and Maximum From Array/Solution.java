class Solution {
    public int minimumDeletions(int[] nums) {
        int min=Integer.MAX_VALUE;
        int minIndex=-1;
        int max=Integer.MIN_VALUE;
        int maxIndex=-1;
        for(int i=0;i<nums.length;i++)
        {
           if(nums[i]>max)
           {
               max=nums[i];
               maxIndex=i;
           }
           if(nums[i]<min)
           {
               min=nums[i];
               minIndex=i;
           }
        }
        int result=0;
        result=(int)Math.max(minIndex+1,maxIndex+1);
        int p=(int)Math.max(nums.length-minIndex, nums.length-maxIndex);
        if(p<result)
        {
            result=p;
        }
        p =(int)Math.min(maxIndex+1,nums.length-maxIndex)+(int)Math.min(minIndex+1,nums.length-minIndex);
        if(result>p)
        {
            result=p;
        }
        
        return result;
        
        
        
    }
}
