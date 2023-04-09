class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        HashMap<Integer,TreeSet<Character>> map=new HashMap<Integer,TreeSet<Character>>();
        int index=0;
        for(int i=0;i<s1.length();i++)
        {
            if(!h.containsKey(s1.charAt(i)) && !h.containsKey(s2.charAt(i)))
            {
                h.put(s1.charAt(i),index);
                h.put(s2.charAt(i),index);
                TreeSet<Character> t=new TreeSet<Character>();
                t.add(s1.charAt(i));
                t.add(s2.charAt(i));
                map.put(index,t);
                index++;
            }
            else
            {
                if(h.containsKey(s1.charAt(i)) && h.containsKey(s2.charAt(i)))
                {
                    int x=h.get(s1.charAt(i));
                    int y=h.get(s2.charAt(i));
                    if(x==y)
                    {
                        continue;
                    }
                    else
                    {
                        TreeSet<Character> t1=map.get(x);
                        TreeSet<Character> t2=map.get(y);
                        if(t1.size()>t2.size())
                        {
                            h.put(s2.charAt(i),x);
                            map.remove(y);
                            Iterator<Character> itr=t2.iterator();
                            while(itr.hasNext())
                            {
                                char c=itr.next();
                                h.put(c,x);
                                t1.add(c);
                            }
                            map.put(x,t1);
                        }
                        else
                        {
                            h.put(s1.charAt(i),y);
                            map.remove(x);
                            Iterator<Character> itr=t1.iterator();
                            while(itr.hasNext())
                            {
                                char c=itr.next();
                                h.put(c,y);
                                t2.add(c);
                            }
                            map.put(y,t2);
                        }
                    }
                }
                else if(h.containsKey(s1.charAt(i)))
                {
                    int x=h.get(s1.charAt(i));
                    TreeSet<Character> t=map.get(x);
                    t.add(s2.charAt(i));
                    map.put(x,t);
                    h.put(s2.charAt(i),x);
                }
                else
                {
                    int x=h.get(s2.charAt(i));
                    TreeSet<Character> t=map.get(x);
                    t.add(s1.charAt(i));
                    map.put(x,t);
                    h.put(s1.charAt(i),x);
                }
            }
        }
        String result="";
        for(int i=0;i<baseStr.length();i++)
        {
            if(h.containsKey(baseStr.charAt(i)))
            {
                int x=h.get(baseStr.charAt(i));
                TreeSet<Character> t=map.get(x);
                Iterator<Character> itr=t.iterator();
                while(itr.hasNext())
                {
                 result+=itr.next();
                 break;
                }
            }
            else
            {
                result+=baseStr.charAt(i);
            }
        }

        return result;
    }
}
