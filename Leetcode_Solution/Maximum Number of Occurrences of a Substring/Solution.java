class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if(minSize>s.length())
        {
            minSize=26;
        }
        if(maxSize>s.length())
        {
            maxSize=26;
        }
        HashMap<String,Integer> h=new HashMap<String,Integer>();
        int max=0;
        for(int i=minSize;i<=maxSize;i++)
        {
            for(int j=0;j<=s.length()-i;j++)
            {
                String str=s.substring(j,j+i);
                int ch[]=new int[26];
                for(int k=0;k<str.length();k++)
                {
                    ch[str.charAt(k)-'a']++;
                }
                int count=0,flag=0;
                for(int k=0;k<26;k++)
                {
                    if(ch[k]>0)
                    {
                        count++;
                        if(count>maxLetters)
                        {
                            flag=1;
                            break;
                        }
                    }
                }
                if(flag==0)
                {
                   if(!h.containsKey(str))
                   {
                       h.put(str,1);
                       if(max==0)
                       {
                           max=1;
                       }
                   }
                   else
                   {
                       h.put(str,h.get(str)+1);
                       if(h.get(str)>max)
                       {
                           max=h.get(str);
                       }
                   }
                }
            }
        }
        
        return max;
    }
}
