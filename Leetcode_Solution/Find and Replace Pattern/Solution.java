class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
    
        ArrayList<String> l=new ArrayList<String>();
        for(int i=0;i<words.length;i++)
        {
            if(words[i].length()==pattern.length())
            {
                HashMap<Character,Character> h=new HashMap<Character,Character>();
                ArrayList<Character> t=new ArrayList<Character>();
                int count=0;
                for(int j=0;j<pattern.length();j++)
                {
                    if(!h.containsKey(pattern.charAt(j)))
                    {
                        if(!t.contains(words[i].charAt(j)))
                        {
                        h.put(pattern.charAt(j),words[i].charAt(j));
                            t.add(words[i].charAt(j));
                        }
                        else
                        {
                            count++;
                            break;
                        }
                    }
                    else
                    {
                        if(words[i].charAt(j)!=h.get(pattern.charAt(j)))
                        {
                            count++;
                            break;
                        }
                    }
                }
                if(count==0)
                {
                    l.add(words[i]);
                }
            }
        }
        
        return l;
        
    }
}
