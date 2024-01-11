class Solution {
    public int trailingZeroes(int n) {
        int ans=0;
        int count2=0,count5=0;
        for(int i=1;i<=n;i++)
        {
            int p=i;
            while(p%10==0)
            {
                p=p/10;
                ans++;
            }
            if(p%2==0)
            {
                int l=p;
                while(l%2==0)
                {
                  l=l/2;
                  count2++;
                }
            }
            if(p%5==0)
            {
                while(p%5==0)
                {
                    p=p/5;
                  count5++;
                }
            }

        }
        return ans+Math.min(count2,count5);
    }
}
