class Solution {
    public int maxScore(String s) {
        int a=0,b=0;
        int max=0;
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
            {
                a++;
            }
            else
            {
                b++;
            }
        }
        if(a==0|| b==0)
        {
            max=s.length()-1;
        }
        else
        {
        int l=0;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)=='0')
            {
                l++;
                sum=l+b;
                if(sum>max)
                {
                    max=sum;
                }
                a--;
            }
            else
            {
                b--;
                sum=l+b;
                if(sum>max)
                {
                    max=sum;
                }
            }
        }
        }
        
        return max;
        
    }
}
