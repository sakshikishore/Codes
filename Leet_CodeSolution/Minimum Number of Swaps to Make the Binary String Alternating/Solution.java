class Solution {
    public int minSwaps(String s) {
        int zero=0,one=0;
        int result=-1;
        int count=0;
        // Case 1 0 1...
        for(int i=0;i<s.length();i++)
        {
            if(i%2==0)
            {
                if(s.charAt(i)=='0')
                {
                    if(one<=0)
                    {
                        count++;
                    }
                     zero++;
                     one--;
                }
            }
            else
            {
                if(s.charAt(i)=='1')
                {
                    if(zero<=0)
                    {
                        count++;
                    }
                     zero--;
                     one++;
                }
            }
        }
        if(one==0)
        {
            result=count;
        }
        zero=0;
        one=0;
        count=0;
        // Case 0 1 0...
        for(int i=0;i<s.length();i++)
        {
            if(i%2!=0)
            {
                if(s.charAt(i)=='0')
                {
                    if(one<=0)
                    {
                        count++;
                    }
                     zero++;
                     one--;
                }
            }
            else
            {
                if(s.charAt(i)=='1')
                {
                    if(zero<=0)
                    {
                        count++;
                    }
                     zero--;
                     one++;
                }
            }
        }
        if(one==0)
        {
            if(result==-1)
            {
                result=count;
            }
            else
            {
            if(count<result)
            {
                result=count;
            }
            }
        }

        return result;
    }
}
