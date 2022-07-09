class Solution {
    public int maxResult(int[] nums, int k) {
        int arr[]=new int[nums.length];
        arr[nums.length-1]=nums[nums.length-1];
        int max=arr[nums.length-1];
        int maxIndex=nums.length-1;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(k+i>=nums.length)
            {
                 
                arr[i]=nums[i]+max;
                if(max<=arr[i])
                {
                    max=arr[i];
                    maxIndex=i;
                    
                }
        
                
            }
            else
            {
                
                if(maxIndex<=i+k)
                {
                    arr[i]=max+nums[i];
                    if(max<=arr[i])
                    {
                       maxIndex=i;
                        max=arr[i];
                    }
                }
                else
                {
                   int max1=Integer.MIN_VALUE;
                   max=max1;
                   for(int j=i+1;j<=i+k;j++)
                    {
                       if(arr[j]>max)
                       {
                           max=arr[j];
                           maxIndex=j;
                       }
                        if(nums[i]+arr[j]>max1)
                        {
                            max1=nums[i]+arr[j];
                        }
                    }
                    arr[i]=max1;
                    if(arr[i]>max)
                    {
                        max=arr[i];
                        maxIndex=i;
                    }
                }
            }
        }
        return arr[0];
    }
}
