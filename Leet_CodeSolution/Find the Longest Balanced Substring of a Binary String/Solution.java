class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int max=0;
        int zeros=0,ones=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
            {
                if(ones!=0)
                {
                    int m=Math.min(zeros,ones);
                    if(max<m*2)
                    {
                        max=m*2;
                    }
                    ones=0;
                    zeros=0;
                }
                zeros++;
            }
            else
            {
                if(zeros!=0)
                {
                    ones++;
                }
            }
        }
        int m=Math.min(zeros,ones);
                    if(max<m*2)
                    {
                        max=m*2;
                    }
        return max;
    }
}
