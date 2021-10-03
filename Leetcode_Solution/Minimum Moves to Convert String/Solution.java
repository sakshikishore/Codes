class Solution {
    public int minimumMoves(String s) {
        int count=0,l=0,result=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='X')
            {
                count++;
                if(count>0 && count+l==3)
                {
                    result++;
                    count=0;
                    l=0;
                }
            }
            else
            {
                if(count>0)
                {
                    l++;
                    if(count>0 && count+l==3)
                    {
                        result++;
                        count=0;
                        l=0;
                    }
                }
            }
        }
        if(count>0)
        {
            result++;
        }
        
        return result;
    }
}
