class Solution {
    public int captureForts(int[] forts) {
        int a=-1,b=-1;
        int max=0;
        for(int i=0;i<forts.length;i++)
        {
            if(forts[i]==1)
            {
                if(b<a)
                {
                    b=-1;
                }
                a=i;
            }
            else if(forts[i]==-1)
            {
                if(a<b)
                {
                    a=-1;
                }
                b=i;
            }
            if(a!=-1 && b!=-1)
            {
                int x=Math.abs(b-a)-1;
                if(x>max)
                {
                    max=x;
                }
            }
        }
        
        return max;
    }
}
