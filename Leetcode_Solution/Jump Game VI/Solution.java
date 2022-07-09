class Solution {
    public int maxResult(int[] nums, int k) {
        int arr[]=new int[nums.length];
        arr[nums.length-1]=nums[nums.length-1];
        int max=arr[nums.length-1];
        int secondMax=Integer.MIN_VALUE;
        int maxIndex=nums.length-1;
        int secondIndex=-1;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(k+i>=nums.length)
            {
                 
                arr[i]=nums[i]+max;
                if(max<=arr[i])
                {
                    secondMax=max;
                    secondIndex=maxIndex;
                    max=arr[i];
                    maxIndex=i;
                    
                }
                else
                {
                    if(secondMax<arr[i])
                    {
                        secondMax=arr[i];
                        secondIndex=i;
                    }
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
                   max=Integer.MIN_VALUE;
                   for(int j=i+1;j<=i+k;j++)
                    {
                        if(nums[i]+arr[j]>max)
                        {
                            max=nums[i]+arr[j];
                        }
                    }
                    arr[i]=max;
                }
            }
        }
        return arr[0];
    }
}
