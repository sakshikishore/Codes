class Solution {
    public int findKthNumber(int m, int n, int k) {
        if(m==1)
        {
            return k;
        }
        else if(m==1 && n==1)
        {
            return 1;
        }
        else if(k==m*n)
        {
            return m*n;
        }
         int min=1,max=m*n;
        while(min<=max)
        {
            int mid=(min+max)/2;
            int count=0;
            for(int i=1;i<=m;i++)
            {
                count=count+Math.min(mid/i,n);
            }
            if(count>=k)
            {
                max=mid-1;
            }
            else
            {
                min=mid+1;
            }
        }
        
        return min;
    }
}
