class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashMap<ArrayList<Integer>, Integer> h=new HashMap<ArrayList<Integer>, Integer>();
        int result=0;
        for(int i=0;i<targetWords.length;i++)
        {
            int ch[]=new int[26];
            for(int j=0;j<targetWords[i].length();j++)
            {
                ch[targetWords[i].charAt(j)-'a']++;
            }
           ArrayList<Integer> l=new ArrayList<Integer>();
           for(int j=0;j<26;j++)
           {
               l.add(ch[j]);
           }
            if(h.containsKey(l))
            {
                h.put(l,h.get(l)+1);
            }
            else
            {
                h.put(l,1);
            }
        }
        for(int i=0;i<startWords.length;i++)
        {
            if(startWords[i].length()!=26)
            {
                int c[]=new int[26];
                for(int j=0;j<startWords[i].length();j++)
                {
                    c[startWords[i].charAt(j)-'a']++;
                }
                ArrayList<Integer> l=new ArrayList<Integer>();
                for(int j=0;j<26;j++)
                {
                    l.add(c[j]);
                }
                for(int j=0;j<26;j++)
                {
                    if(c[j]==0)
                    {
                        l.remove(j);
                        l.add(j,1);
                        if(h.containsKey(l))
                        {
                            result+=h.get(l);
                            h.remove(l);
                        }
                        c[j]=0;
                        l.remove(j);
                        l.add(j,0);
                    }
                }
            }
        }

        return result;
    }
}
