class Solution {
    public boolean canJump(int[] nums) {
        int arr[]=new int[nums.length];
        boolean result=true;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]==0)
            {
                arr[i]=-1;
            }
            else
            {
                int j=i+1;
                int min=Integer.MAX_VALUE;
                int count=0;
                while(j<nums.length && count<nums[i])
                {
                    count++;
                    if(arr[j]>=0)
                    {
                        if(arr[j]<min)
                        {
                            min=arr[j];
                        }
                    }
                    j++;
                }
                
                if(min==Integer.MAX_VALUE)
                {
                    arr[i]=-1;
                }
                else
                {
                    arr[i]=min+1;
                }
            }
        }
        
        if(arr[0]==-1)
        {
            result=false;
        }
        
        return result;
    }
}
