class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if(num==0)
        {
            return true;
        }
        boolean result=false;
        for(int i=1;i<num;i++)
        {
            if(i<10)
            {
                if(i*2==num)
                {
                    return true;
                }
            }
            else
            {
                int x=i;
                int revnum=0;
                while(x!=0)
                {
                    int r=x%10;
                    revnum=revnum*10+r;
                    x=x/10;
                }
                
                if(revnum+i==num)
                {
                    return true;
                }
            }
        }
        
        return result;
    }
}
