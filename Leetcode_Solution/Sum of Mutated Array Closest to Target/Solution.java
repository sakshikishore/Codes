class Solution {
    public int findBestValue(int[] arr, int target) 
    {
        int mindiff=Integer.MAX_VALUE;
        Arrays.sort(arr);
        int min=0,max=arr[arr.length-1];
        int result=0;
        while(min<=max)
        {
            int mid=(min+max)/2;
            int sum=0;
            for(int j=arr.length-1;j>=0;j--)
            {
                if(arr[j]>mid)
                {
                   sum+=mid; 
                }
                else
                {
                    sum+=arr[j];
                }
            }
            if(sum<target)
            {
                int x=target-sum;
                if(x<mindiff)
                {
                    mindiff=x;
                    result=mid;
                }
                else if(x==mindiff)
                {
                    if(mid<result)
                    {
                        result=mid;
                    }
                }
                min=mid+1;
            }
            else
            {
                int x=sum-target;
                if(x<mindiff)
                {
                    mindiff=x;
                    result=mid;
                }
                else if(x==mindiff)
                {
                    if(mid<result)
                    {
                        result=mid;
                    }
                }
                max=mid-1;
            }
        }
        
        return result;
    }
}
