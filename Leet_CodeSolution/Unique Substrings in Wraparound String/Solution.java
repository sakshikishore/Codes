class Solution {
    public int findSubstringInWraproundString(String s) {
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        int ch[]=new int[26];
        int dp[]=new int[s.length()];
        dp[0]=1;
        h.put(s.charAt(0),1);
        ch[s.charAt(0)-'a']++;
        int start=0;
        for(int i=1;i<s.length();i++)
        {
          if(((s.charAt(i)-s.charAt(i-1))+26)%26==1)
          {
            if(ch[s.charAt(i)-'a']==0)
            {
                ch[s.charAt(i)-'a']=1;
                dp[i]=dp[i-1]+(i-start+1);
                h.put(s.charAt(i),i-start+1);
            }
            else
            {
                int count=h.get(s.charAt(i));
                int p=i-start+1;
                if(p>count)
                {
                    dp[i]=dp[i-1]+p-count;
                     h.put(s.charAt(i),p);
                }
                else
                {
                    dp[i]=dp[i-1];
                }

            }
          }
          else
          {
            if(ch[s.charAt(i)-'a']==0)
            {
                ch[s.charAt(i)-'a']=1;
                dp[i]=dp[i-1]+1;
                start=i;
                h.put(s.charAt(i),1);
            }
            else
            {
                start=i;
                dp[i]=dp[i-1];
            }
          }
        }
       return dp[s.length()-1];
    }
}
