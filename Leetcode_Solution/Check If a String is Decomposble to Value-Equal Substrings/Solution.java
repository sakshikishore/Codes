class Solution {
    public boolean isDecomposable(String s) {
        int count=1;
        boolean result=false;
        int p=0;
        int l=0;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                count++;
                if(count==3)
                {
                    l=0;
                    count=1;
                    i++;              
                }
            }
            else
            {
                if(count==1)
                {
                    l=1;
                    break;
                }
                else
                {
                    if(p==1)
                    {
                        l=1;
                        break;
                    }
                    else
                    {
                        l=0;
                        p++;
                        count=1;
                     
                    }
                }
            }
        }
        if((l==0 && p==1)||(count==2 && p==0 && l==0)) 
        {
            result=true;
        }
        
        
        return result;
        
    }
}
