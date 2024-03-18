class Solution {
    public long countSubstrings(String s, char c) {
        long ans=0;
        long count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==c)
            {
                count++;
            }
        }
        ans=ans+count;
        ans+=((count-1)*(count))/2;
        
        
        return ans;
    }
}
