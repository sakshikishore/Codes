class Solution {
    public int appendCharacters(String s, String t) {
        HashMap<Character,ArrayList<Integer>> h=new HashMap<Character,ArrayList<Integer>>();
        for(int i=0;i<s.length();i++)
        {
            if(!h.containsKey(s.charAt(i)))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(s.charAt(i),l);
            }
            else
            {
                ArrayList<Integer> l=h.get(s.charAt(i));
                l.add(i);
                h.put(s.charAt(i),l);
            }
        }
        int prev=-1;
        for(int i=0;i<t.length();i++)
        {
            if(!h.containsKey(t.charAt(i)))
            {
                return t.length()-i;
            }
            else
            {
                ArrayList<Integer> l=h.get(t.charAt(i));
                int flag=0;
                int j=0;
                while(flag==0 && l.size()>0)
                {
                    if(l.get(j)>prev)
                    {
                        prev=l.get(j);
                        flag=1;
                    }
                    else
                    {
                        l.remove(0);
                    }
                }
                if(flag==0)
                {
                     return t.length()-i;
                }
            }
        }
        
        return 0;
    }
}
