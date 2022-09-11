class Solution {
    public int partitionString(String s) {
        int ch[]=new int[26];
        int ans=1;
        for(int i=0;i<s.length();i++)
        {
            if(ch[s.charAt(i)-'a']==1)
            {
                ans++;
                ch=new int[26];
                ch[s.charAt(i)-'a']++;
            }
            else
            {
                ch[s.charAt(i)-'a']++;
            }
        }
        
        return ans;
    }
}
