class Solution {
    public int lengthOfLIS(int[] nums) {
        int arr[]=new int[nums.length];
        arr[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            int max=0;
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                {
                    if(max<arr[j])
                    {
                        max=arr[j];
                    }
                }
            }
             arr[i]=max+1;
        }
        int max=1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        
        return max;
        
    }
}
