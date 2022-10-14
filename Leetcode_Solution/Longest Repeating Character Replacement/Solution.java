class Solution {
    public int characterReplacement(String s, int k) {
        int ch[]=new int[26];
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'A']++;
        }
        for(int i=0;i<26;i++)
        {
            if(ch[i]!=0)
            {
                char c=(char)(65+i);
                Queue<Integer> q=new LinkedList<Integer>();
                int start=0;
                for(int j=0;j<s.length();j++)
                {
                    if(s.charAt(j)!=c)
                    {
                        if(q.size()<k)
                        {
                            q.add(j);
                        }
                        else
                        {
                            int len=j-start;
                            if(len>max)
                            {
                                max=len;
                            }
                            if(q.size()>0)
                            {
                                start=q.poll()+1;
                                q.add(j);
                            }
                            else
                            {
                                start=j+1;
                            }
                        }
                    }
                }
                
                if(s.length()-start>max)
                {
                    max=s.length()-start;
                }
                
                if(max==s.length())
                {
                    break;
                }
            }
        }
        
        return max;
    }
}
