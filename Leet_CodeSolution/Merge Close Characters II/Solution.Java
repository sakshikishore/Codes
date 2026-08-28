class Solution {
    public String mergeCharacters(String s, int k) {
        Queue<Character> q=new LinkedList<Character>();
        StringBuffer sb=new StringBuffer("");
        q.add(s.charAt(0));
        int ch[]=new int[26];
        Arrays.fill(ch,-1);
        ch[s.charAt(0)-'a']=0;
        int j=1;
        for(int i=1;i<s.length();i++)
        {
            if(ch[s.charAt(i)-'a']!=-1)
            {
                int diff=j-ch[s.charAt(i)-'a'];
                if(diff>k)
                {
                    ch[s.charAt(i)-'a']=j;
                    q.add(s.charAt(i));
                    j++;
                }
            }
            else
            {
                ch[s.charAt(i)-'a']=j;
                q.add(s.charAt(i));
                j++;
            }
        }
        while(q.size()>0)
        {
            sb.append(q.poll());
        }

        return new String(sb);
    }
}
