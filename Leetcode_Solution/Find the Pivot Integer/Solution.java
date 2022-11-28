class Solution {
    public int pivotInteger(int n) {
        int sum=n*(n+1);
        sum=sum/2;
        int x=sum;
        int y=n;
        int ans=-1;
        int p=n;
        while(x!=0)
        {
            if(x==y)
            {
                ans=p;
                break;
            }
            else
            {
                x=x-p;
                y=y+p-1;
                p--;
            }
        }
        
        return ans;
    }
}
