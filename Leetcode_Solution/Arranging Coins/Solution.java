class Solution {
    public int arrangeCoins(int n) {
        long sum=0;
        int result=0;
        for(int i=1;i<=n;i++)
        {
            sum=sum+i;
            if(sum>n)
            {
                result=i-1;
                break;
            }
            if(sum==n)
            {
                result=i;
                break;
            }
        }
        
        return result;
        
    }
}
