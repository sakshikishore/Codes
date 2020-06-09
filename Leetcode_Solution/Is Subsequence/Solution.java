class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean result=false;
        if(s.length()<=t.length())
        {
            int i=0;
            int j=0;
            while(i!=s.length() && j!=t.length())
            {
                if(s.charAt(i)==t.charAt(j))
                {
                    i++;
                }
                j++;
            }
            
            if(i==s.length())
            {
                result=true;
            }
        }
        
        return result;
        
    }
}
