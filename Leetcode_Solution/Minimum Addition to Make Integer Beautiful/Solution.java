class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long x=n;
        long sum=0;
        while(x>0)
        {
            long r=x%10;
            sum+=r;
            x=x/10;
        }
        
        if(sum<=target)
        {
            return 0;
        }
        
        int flag=0;
        long result=0;
        while(flag==0)
        {
            String str=Long.toString(n);
            int count=-1;
            long p=0;
            for(int j=str.length()-1;j>=0;j--)
            {
                count++;
                if(str.charAt(j)!='0')
                {
                   int k=str.charAt(j)-'0';
                   p=10-k;
                   break;
                }
            }
            long q=p*(long)Math.pow(10,count);
            result+=q;
            n=n+q;
             x=n;
             sum=0;
                while(x>0)
                {
                    long r=x%10;
                    sum+=r;
                    x=x/10;
                }
            
            if(sum<=target)
            {
                return result;
            }
        }
        
        return result;
    }
}
