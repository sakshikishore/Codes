class Solution {
    public String clearStars(String s) {
        HashMap<Character,ArrayList<Integer>> h=new HashMap<Character,ArrayList<Integer>>();
        HashSet<Integer> hset=new HashSet<Integer>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='*')
            {
               if(h.size()>0)
               {
                for(int j=0;j<26;j++)
                {
                    if(h.containsKey((char)(97+j)))
                    {
                        ArrayList<Integer> l=h.get((char)(97+j));
                        hset.add(l.get(l.size()-1));
                        l.remove(l.size()-1);
                        if(l.size()==0)
                        {
                            h.remove((char)(97+j));
                        }
                        else
                        {
                            h.put((char)(97+j),l);
                        }
                        break;
                    }
                }
               }
            }
            else
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

        }
        String result="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!='*')
            {
                if(!hset.contains(i))
                {
                    result+=s.substring(i,i+1);
                }
            }
        }

        return result;
    }
}
