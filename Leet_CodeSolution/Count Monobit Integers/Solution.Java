class Solution {
    public int countMonobit(int n) {
        int ans=1;
        for(int i=1;i<=n;i++)
        {
           int p=i;
           int flag=0;
           int zeroCount=0,oneCount=0;
           while(p>0)
           {
            int r=(p&1);
            if(r==1)
            {
                oneCount++;
            }
            else
            {
                zeroCount++;
            }
            if(zeroCount!=0 && oneCount!=0)
            {
                flag=1;
                break;
            }
            p>>=1;
           }

           if(flag==0)
           {
             ans++;
           }

        }

        return ans;
    }
}
