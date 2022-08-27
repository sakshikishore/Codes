class Solution {
    public int findNumberOfLIS(int[] nums) {
        int arr[]=new int[nums.length];
        arr[0]=1;
        int maxcount[]=new int[nums.length];
        maxcount[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            maxcount[i]=1;
            arr[i]=1;
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]>nums[j])
                {
                    int len=arr[j]+1;
                    if(len>arr[i])
                    {
                        arr[i]=len;
                        maxcount[i]=maxcount[j];
                    }
                    else if(len==arr[i])
                    {
                        maxcount[i]+=maxcount[j];
                    }
                }
            }
        }
        int max=0;
        int result=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==max)
            {
               result+=maxcount[i];
            }
        }
        
        return result;
    }
}
