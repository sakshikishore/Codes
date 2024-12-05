class Solution {
    public int minCost(int[] nums, int k) {
        long ans[]=new long[nums.length];
        ans[0]=k*1l;
        for(int i=1;i<nums.length;i++)
        {
            ans[i]=k+ans[i-1];
            int arr[]=new int[1001];
            arr[nums[i]]=1;
            int count=0;
            for(int j=i-1;j>=0;j--)
            {
                int p=nums[j];
                if(arr[p]==0)
                {
                    arr[p]=1;
                }
                else
                {
                    if(arr[p]==1)
                    {
                        arr[p]=2;
                        count=count+2;
                    }
                    else
                    {
                        arr[p]++;
                        count++;
                    }
                }
                if(j==0)
                {
                    if(count+k<ans[i])
                    {
                         ans[i]=count+k;
                    }
                }
                else
                {
                    if(count+k+ans[j-1]<ans[i])
                    {
                        ans[i]=count+k+ans[j-1];
                    }
                }
            }
        }

        return (int)(ans[ans.length-1]);
    }
}
