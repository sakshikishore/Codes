class Solution {
    public long distributeCandies(int n, int limit) {
        long result=0;
        for(int i=0;i<=limit && i<=n;i++)
        {
            int x=n-i;
            int y=x/2;
            int z=x-y;
            if(y>limit || z>limit)
            {
                continue;
            }
            else if(y==limit && z==limit)
            {
                result++;
            }
            else
            {
                result++;
                int p=limit-y;
                int q=limit-z;
                p=Math.min(p,x-y);
                result+=p;
                q=Math.min(q,x-z);
                result+=q;
              
            }
            
        }
        
        return result;
    }
}
