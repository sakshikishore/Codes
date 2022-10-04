class Solution {
    public int clumsy(int n) {
        if(n==1 || n==2)
        {
            return n;
        }
        int flag=0;
        int result=0;
        while(n!=0)
        {
            int x=n;
            n--;
            if(n>0)
            {
                x=x*(n);
                n--;
            }
            else
            {
                if(flag!=0)
                {
                  result=result-x;
                }
                else
                {
                    result=x;
                }
                break;
            }
            if(n>0)
            {
                x=x/n;
                if(flag!=0)
                {
                    result=result-x;
                }
                n--;
            }
            else
            {
                if(flag!=0)
                {
                result=result-x;
                }
                else
                {
                    result=x;
                }
                break;
                    
            }
            if(n>0)
            {
                if(flag==0)
                {
                  x=x+n;
                }
                else
                {
                    result=result+n;
                }
                n--;
            }
            if(flag==0)
            {
                result=x;
                flag=1;
            }
            
        }
        
      return result;
    }
}
