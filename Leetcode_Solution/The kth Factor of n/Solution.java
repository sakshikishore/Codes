class Solution {
    public int kthFactor(int n, int k) {
        
        int result=-1;
        int l=0;
        for(int i=1;i<=n/2;i++)
        {
            if(n%i==0)
            {
                l++;
                if(l==k)
                {
                    result=i;
                    break;
                }
            }
        }
        if(l+1==k)
        {
            result=n;
        }
        
        return result;
    }
}
