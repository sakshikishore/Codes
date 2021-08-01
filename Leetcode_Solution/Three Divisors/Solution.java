class Solution {
    public boolean isThree(int n) {
        boolean result=false;
        int count=0;
        for(int i=2;i<=n/2;i++)
        {
            if(n%i==0)
            {
                count++;
                if(count>1)
                {
                    break;
                }
            }
        }
        
        if(count==1)
        {
            result=true;
        }
        
        return result;
    }
}
