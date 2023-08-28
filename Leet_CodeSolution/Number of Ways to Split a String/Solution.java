class Solution {
    public int numWays(String s) {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                count++;
            }
        }
        if(count%3!=0)
        {
            return 0;
        }
        if(count==0)
        {
            long n=s.length()-2;
            long ans=((n*(n+1))/2)%1000000007;
            return (int)ans;

        }
        else
        {
            int x=count/3;
            long leftCount=0,rightCount=0;
            long leftZero=0,rightZero=0;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='1')
                {
                   if(leftCount<x)
                   {
                     leftCount++;
                   }
                   else
                   {
                       break;
                   }
                }
                else
                {
                    if(leftCount==x)
                    {
                        leftZero++;
                    }
                }
            }
            for(int i=s.length()-1;i>=0;i--)
            {
                if(s.charAt(i)=='1')
                {
                    if(rightCount<x)
                    {
                        rightCount++;
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    if(rightCount==x)
                    {
                        rightZero++;
                    }
                }
            }

            long ans=((leftZero+1)*(rightZero+1))%1000000007;

            return (int)ans;
        }

    }
}
