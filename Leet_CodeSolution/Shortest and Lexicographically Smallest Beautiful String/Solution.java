class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int minLen=Integer.MAX_VALUE;
        String result="";
        for(int i=0;i<s.length();i++)
        {
            int count=0;
            int len=0;
            for(int j=i;j<s.length();j++)
            {
                len++;
                if(s.charAt(j)=='1')
                {
                    count++;
                }
                if(count==k)
                {
                    if(len<minLen)
                    {
                        minLen=len;
                        result=s.substring(i,j+1);
                    }
                    if(len==minLen)
                    {
                        String p=s.substring(i,j+1);
                        if(p.compareTo(result)<0)
                        {
                            result=p;
                        }
                    }
                }
            }
            
        }
         return result;
    }
}
