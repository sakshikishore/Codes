class Solution {
    public int maxOperations(String s) {
        int count=0,result=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                if(count==0)
                {
                    count++;
                }
                else if(s.charAt(i)!=s.charAt(i-1))
                {
                    result+=count;
                    count++;
                }
                else
                {
                    count++;
                }
            }
        }
         if(s.charAt(s.length()-1)=='0')
         {
            return result+count;
         }
        return result;
    }
}
