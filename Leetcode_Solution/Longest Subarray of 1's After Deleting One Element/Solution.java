class Solution {
    public int longestSubarray(int[] nums) {
        int arr[]=new int[nums.length+1];
        int count=0;
        int result=0,flag=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                count++;
                arr[i]=-1;
            }
            else
            {
                flag=1;
                arr[i]=count;
                count=0;
            }
        }
        if(flag==0)
        {
            result=nums.length-1;
        }
        else
        {
            arr[nums.length]=count;
            int first=0,prev=0;
            for(int i=0;i<=nums.length;i++)
            {
                if(arr[i]!=-1)
                {
                    if(first==0)
                    {
                        result=arr[i];
                        prev=arr[i];
                        first=1;
                    }
                    else if(first==1)
                    {
                        result+=arr[i];
                        prev=arr[i];
                        first=2;
                    }
                    else
                    {
                        if(arr[i]+prev>result)
                        {
                            result=arr[i]+prev;
                            prev=arr[i];
                        }
                        else
                        {
                            prev=arr[i];
                        }
                    }

                }
            }
        }
        
        return result;
    }
}
