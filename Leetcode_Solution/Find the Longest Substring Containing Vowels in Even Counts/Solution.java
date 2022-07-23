class Solution {
    public int findTheLongestSubstring(String s) {
        int ans=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            String str=s.substring(0,i+1);
            int ch[]=new int[26];
            for(int j=0;j<str.length();j++)
            {
                ch[str.charAt(j)-'a']++;
            }
            if(ch[0]%2==0 && ch[4]%2==0 && ch[8]%2==0 && ch[14]%2==0 && ch[20]%2==0)
            {
                ans=str.length();
                break;
            }
            for(int j=1;j<s.length()-i;j++)
            {
                
                ch[s.charAt(j-1)-'a']--;
                ch[s.charAt(j+i)-'a']++;
            if(ch[0]%2==0 && ch[4]%2==0 && ch[8]%2==0 && ch[14]%2==0 && ch[20]%2==0)
            {
                ans=str.length();
                break;
            }
          }
            if(ans!=0)
            {
                break;
            }
        }
        
        return ans;
    }
}
