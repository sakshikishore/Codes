class Solution {
    public int maximumJumps(int[] nums, int target) {
       int arr[]=new int[nums.length];
       for(int i=nums.length-2;i>=0;i--)
       {
           for(int j=i+1;j<nums.length;j++)
           {
               if(nums[j]-nums[i]<=target && nums[j]-nums[i]>=(-1*target))
               {
                   if(arr[j]==0)
                   {
                       if(j==nums.length-1)
                       {
                           if(arr[j]+1>arr[i])
                           {
                               arr[i]=arr[j]+1;
                           }
                       }
                   }
                   else
                   {
                        if(arr[j]+1>arr[i])
                           {
                               arr[i]=arr[j]+1;
                           }
                   }
               }
           }
       }
        if(arr[0]==0)
        {
            return -1;
        }
        
        return arr[0];
    }
}
