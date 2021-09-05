class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum=0;
        int middleIndex=-1;
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
        }
        int l=0;
        for(int i=0;i<nums.length;i++)
        {
           if(i==0)
           {
               if(sum-nums[i]==0)
               {
                   middleIndex=i;
                   break;
               }
               else
               {
                   sum=sum-nums[i];
                   l=nums[i];
               }
           }
           else
           {
               if(sum-nums[i]==l)
               {
                   middleIndex=i;
                   break;
               }
               else
               {
                   l=l+nums[i];
                   sum=sum-nums[i];
               }
           }
        }
        return middleIndex;
    }
    
}
