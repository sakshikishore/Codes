class Solution {
    public List<String> simplifiedFractions(int n) {
        ArrayList<String> l=new ArrayList<String>();
        if(n>1)
        {
            for(int i=1;i<n;i++)
            {
                for(int j=i+1;j<=n;j++)
                {
                    int r1=i,r2=j;
                    while(r2!=0)
                    {
                        int r=r1%r2;
                        r1=r2;
                        r2=r;
                    }
                    if(r1==1)
                    {
                     l.add(Integer.toString(i)+"/"+Integer.toString(j));
                    }
                }
            }
        }
        
        return l;
        
    }
}
