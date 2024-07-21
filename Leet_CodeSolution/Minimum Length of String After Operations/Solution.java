class Solution {
    public int minimumLength(String s) {
        int ch[]=new int[26];
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(ch[i]>0)
            {
                if(ch[i]%2==0)
                {
                    result+=2;
                }
                else
                {
                    result+=1;
                }
            }
        }

        return result;
    }
}
