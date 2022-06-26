class Solution {
    public int countAsterisks(String s) {
        int count=0,result=0;
        for(int i=0;i<s.length();i++)
        {
            if(count%2==0)
            {
                if(s.charAt(i)=='*')
                {
                    result++;
                }
            }
            if(s.charAt(i)=='|')
            {
                count++;
            }
        }
        
        return result;
    }
}
