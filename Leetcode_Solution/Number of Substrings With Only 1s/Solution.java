class Solution {
    public int numSub(String s) {
        int count=0;
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                count++;
            }
            else
            {
                if(count>0)
                {
                    for(int j=1;j<=count;j++)
                    {
                        sum=sum+j;
                        sum=sum%(1000000007);
                    }
                }
                count=0;
            }
        }
        
        if(count>0)
        {
            for(int j=1;j<=count;j++)
                    {
                        sum=sum+j;
                        sum=sum%(1000000007);
                    }
        }
        
        return sum;
        
    }
}
