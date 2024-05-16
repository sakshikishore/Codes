class Solution {
    public int minAnagramLength(String s) {
       int n=s.length();
       if(n==1)
       {
        return 1;
       }
       ArrayList<Integer> l=new ArrayList<Integer>();
       l.add(1);
       for(int i=2;i<=n/2;i++)
       {
        if(n%i==0)
        {
            l.add(i);
        }
       }
       for(int i=0;i<l.size();i++)
       {
            int ch[]=new int[26];
             int flag=0;
           for(int j=0;j<s.length();j=j+l.get(i))
           {
             int c[]=new int[26];
             if(j==0)
             {
                for(int k=j;k<j+l.get(i);k++)
                {
                    ch[s.charAt(k)-'a']++;
                }
             }
             else
             {
                for(int k=j;k<j+l.get(i);k++)
                {
                    c[s.charAt(k)-'a']++;
                }
             for(int k=0;k<26;k++)
             {
                if(ch[k]!=c[k])
                {
                    flag=1;
                    break;
                }
             }
             }
           }
           if(flag==0)
           {
            return l.get(i);
           }
       }

       return s.length();
    }
}
