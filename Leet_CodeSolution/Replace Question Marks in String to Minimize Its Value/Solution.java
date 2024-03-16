class Solution {
    public String minimizeStringValue(String s) {
        int ch[]=new int[26];
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='?')
            {
                continue;
            }
            else
            {
                ch[s.charAt(i)-'a']++;
                count++;
            }
        }
         char c[]=new char[s.length()];
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0;i<26;i++)
        {
            pq.add(ch[i]);
        }
        for(int i=0;i<s.length()-count;i++)
        {
            int x=pq.poll();
            pq.add(x+1);
        }
        int p[]=new int[26];
        int k=0;
        while(pq.size()>0)
        {
            p[k]=pq.poll();
            k++;
        }
        HashSet<Integer> hset=new HashSet<Integer>();
        int x=0;
        for(int i=25;i>=0;i--)
        {
            if(ch[i]==0)
            {
                while(x<26 && p[x]==-1)
                {
                    x++;
                }
                ch[i]=p[x];
                p[x]=-1;
                x++;
            }
            else if(p[x]<ch[i])
            {
                while(p[x]<ch[i])
                {
                    x++;
                }
                ch[i]=p[x];
                p[x]=-1;
                x=0;
            }
            else
            {
                ch[i]=p[x];
                p[x]=-1;
            }
           
        }
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!='?')
            {
                c[i]=s.charAt(i);
                ch[s.charAt(i)-'a']--;
            }
        }
       
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='?')
            {
                for(int j=0;j<26;j++)
                {
                    if(ch[j]!=0)
                    {
                        c[i]=(char)(97+j);
                        ch[j]--;
                        break;
                    }
                }
            }
        }
        
        return new String(c);
    }
}
