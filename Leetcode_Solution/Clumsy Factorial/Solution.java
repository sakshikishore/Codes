class Solution {
    public int clumsy(int n) {
        if(n==1 || n==2)
        {
            return n;
        }
        int i=n;
        int flag=0;
        int result=0;
        while(i!=0)
        {
            int x=i;
            i--;
            if(i>0)
            {
                x=x*(i);
                i--;
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
            if(i>0)
            {
                x=x/i;
                if(flag!=0)
                {
                    result=result-x;
                    flag=1;
                }
                i--;
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
            if(i>0)
            {
                if(flag==0)
                {
                  x=x+i;
                }
                else
                {
                    result=result+i;
                }
                i--;
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
