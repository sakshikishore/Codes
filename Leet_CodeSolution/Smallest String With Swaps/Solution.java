class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        HashMap<Integer,HashSet<Integer>> h=new HashMap<Integer,HashSet<Integer>>();
        char result[]=s.toCharArray();
        for(int i=0;i<pairs.size();i++)
        {
           if(!h.containsKey(pairs.get(i).get(0)))
           {
            HashSet<Integer> hset=new HashSet<Integer>();
            hset.add(pairs.get(i).get(1));
            h.put(pairs.get(i).get(0),hset);
           }
           else
           {
                HashSet<Integer> hset=h.get(pairs.get(i).get(0));
                hset.add(pairs.get(i).get(1));
                h.put(pairs.get(i).get(0),hset);
           }
           if(!h.containsKey(pairs.get(i).get(1)))
           {
            HashSet<Integer> hset=new HashSet<Integer>();
            hset.add(pairs.get(i).get(0));
            h.put(pairs.get(i).get(1),hset);
           }
           else
           {
                HashSet<Integer> hset=h.get(pairs.get(i).get(1));
                hset.add(pairs.get(i).get(0));
                h.put(pairs.get(i).get(1),hset);
           }
        }
        HashSet<Integer> hset=new HashSet<Integer>();
        for(int i=0;i<s.length();i++)
        {
          if(!hset.contains(i))
          {
            Queue<Integer> q=new LinkedList<Integer>();
            q.add(i);
            ArrayList<Integer> l=new ArrayList<Integer>();
            while(q.size()>0)
            {
                int x=q.poll();
                hset.add(x);
                if(h.containsKey(x))
                {
                HashSet<Integer> temp=h.get(x);
                Iterator<Integer> itr=temp.iterator();
                    while(itr.hasNext())
                    {
                        int p=itr.next();
                        if(!hset.contains(p))
                        {
                            l.add(p);
                            q.add(p);
                        }
                    }
                }

            }
            if(l.size()>0)
            {
                HashSet<Integer> temp=h.get(i);
                for(int j=0;j<l.size();j++)
                {
                    temp.add(l.get(j));
                }
                 temp.add(i);
                Iterator<Integer> itr=temp.iterator();
                ArrayList<Integer> list=new ArrayList<Integer>();
                while(itr.hasNext())
                {
                   int a=itr.next();
                   list.add(a);
                }
                Collections.sort(list);
                ArrayList<Character> charList=new ArrayList<Character>();
                for(int j=0;j<list.size();j++)
                {
                    charList.add(s.charAt(list.get(j)));
                }
                Collections.sort(charList);
                for(int j=0;j<list.size();j++)
                {
                    result[list.get(j)]=charList.get(j);
                }
            }
          }
        }

        return new String(result);
    }
}
