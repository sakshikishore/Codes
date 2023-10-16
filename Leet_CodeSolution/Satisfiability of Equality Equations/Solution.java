class Solution {
    public boolean equationsPossible(String[] equations) {
        HashMap<Character,HashSet<Character>> h=new HashMap<Character,HashSet<Character>>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<equations.length;i++)
        {
            if(equations[i].contains("!"))
            {
                l.add(i);
            }
            else
            {
              char firstChar=equations[i].charAt(0),secondChar=equations[i].charAt(3);
                if(!h.containsKey(firstChar))
                {
                   HashSet<Character> hset=new HashSet<Character>();
                   hset.add(secondChar);
                   h.put(firstChar,hset);
                }
                else
                {
                   HashSet<Character> hset=h.get(firstChar);
                   hset.add(secondChar);
                   h.put(firstChar,hset);
                }
                 if(!h.containsKey(secondChar))
                {
                   HashSet<Character> hset=new HashSet<Character>();
                   hset.add(firstChar);
                   h.put(secondChar,hset);
                }
                else
                {
                   HashSet<Character> hset=h.get(secondChar);
                   hset.add(firstChar);
                   h.put(secondChar,hset);
                }
            }
        }
        for(int i=0;i<26;i++)
        {
            char ch=(char)(97+i);
            Queue<Character> q=new LinkedList<Character>();
            q.add(ch);
            HashSet<Character> hset1=new HashSet<Character>();
            if(h.containsKey(ch))
            {
                 hset1=h.get(ch);
            }
            hset1.add(ch);
            HashSet<Character> h1=new HashSet<Character>();
            h1.add(ch);
            while(q.size()>0)
            {
                char c=q.poll();
                 if(h.containsKey(c))
                 {
                     HashSet<Character> hset=h.get(c);
                     Iterator<Character> itr=hset.iterator();
                     while(itr.hasNext())
                     {
                         char a=itr.next();
                         if(!h1.contains(a))
                         {
                             h1.add(a);
                             q.add(a);
                             hset1.add(a);

                         }
                     }
                 }
            }
           
               h.put(ch,hset1);

        }
          
        for(int i=0;i<l.size();i++)
        {
             char ch1=equations[(l.get(i))].charAt(0),ch2=equations[(l.get(i))].charAt(3);
             if(h.containsKey(ch1) && h.containsKey(ch2))
             {
                 HashSet<Character> h1=h.get(ch1);
                 if(h1.contains(ch2))
                 {
                     return false;
                 }
                  HashSet<Character> h2=h.get(ch2);
                 if(h2.contains(ch1))
                 {
                     return false;
                 }

             }
        }
        return true;

    }
}
