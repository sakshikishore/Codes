class Solution {

    public String findLexSmallestString(String s, int a, int b) {
        HashSet<String> hset=new HashSet<String>();
        Queue<String> q=new LinkedList<String>();
        hset.add(s);
        q.add(s);
        String res=s;
        while(q.size()>0)
        {
           String str=q.poll();
           char c[]=str.toCharArray();
           char ch[]=new char[c.length];
           for(int i=0;i<c.length;i++)
           {
               ch[(i+b)%str.length()]=c[i];
           }
           String p=new String(ch);
           if(!hset.contains(p))
           {
                if(res.compareTo(p)>0)
                {
                    res=p;
                }
                hset.add(p);
                q.add(p);
           }
           for(int i=1;i<str.length();i=i+2)
           {
               int l=c[i]-'0';
               l=(l+a)%10;
               c[i]=(char)(48+l);
           }
          p=new String(c);
           if(!hset.contains(p))
           {
                if(res.compareTo(p)>0)
                {
                    res=p;
                }
                hset.add(p);
                q.add(p);
           }

        }

        return res;
    }
}
