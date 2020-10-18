class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int ch[]=new int[26];
        int max=-1;
        for(int i=0;i<s.length();i++)
        {
            if(ch[s.charAt(i)-'a']==0)
            {
                ch[s.charAt(i)-'a']=i+1;
            }
            else
            {
                int p=i-ch[s.charAt(i)-'a'];
                if(p>max)
                {
                    max=p;
                }
            }
        }
        
        
        return max;
        
    }
}
