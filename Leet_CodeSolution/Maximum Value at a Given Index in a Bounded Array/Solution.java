class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long low=maxSum/n,high=maxSum;
        if(low==1 && low*n==maxSum)
        {
            return 1;
        }
        long result=low;
        while(low<=high)
        {
            long mid=(low+high)/2;
            long sum=mid;
            if(mid>=index+1)
            {
                long m=index;
                sum=sum+(m*((2*(mid-1))+(m-1)*(-1)))/2;
            }
            else 
            {
                 long m=mid-1;
                 long r=index-m;
                 sum+=r;
                 sum=sum+(m*((2*(mid-1))+(m-1)*(-1)))/2;

            }
            long m=n-1-index;
            if(mid>m)
            {
                sum=sum+(m*((2*(mid-1))+(m-1)*(-1)))/2;
            }
            else
            {
                m=mid-1;
                long r=(n-1)-(index+m);
                 sum+=r;
                 sum=sum+(m*((2*(mid-1))+(m-1)*(-1)))/2;

            }
            if(sum<=maxSum)
            {
                result=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return (int)result;
    }
}
