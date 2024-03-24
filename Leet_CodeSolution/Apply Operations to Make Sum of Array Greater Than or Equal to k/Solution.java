class Solution {
    public int minOperations(int k) {
        if(k==1)
        {
            return 0;
        }
        if(k<4)
        {
            return k-1;
        }
        int flag=0;
        int p=2;
        int res=Integer.MAX_VALUE;
        while(flag!=1)
        {
            if(k%p==0)
            {
                int x=k/p;
                int y=x-1+(p-1);
                if(y<=res)
                {
                    res=y;
                }
                else
                {
                    break;
                }
                
            }
            else
            {
                int x=k/p;
                int y=x+(p-1);
                if(y<=res)
                {
                    res=y;
                }
                else
                {
                    break;
                }
            }
            
            p++;
        }
        
        return res;
        
    }
}
