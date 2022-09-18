class Solution {
    public int longestContinuousSubstring(String s) {
        int max=0;
        int count=1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i-1)-'a'+1==s.charAt(i)-'a')
            {
                count++;
            }
            else
            {
                if(count>max)
                {
                    max=count;
                }
                count=1;
            }
        }
        
        if(count>max)
        {
            max=count;
        }
        
        return max;
    }
}
