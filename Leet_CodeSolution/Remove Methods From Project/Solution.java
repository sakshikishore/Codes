class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        HashMap<Integer,ArrayList<Integer>> h=new  HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<invocations.length;i++)
        {
            if(!h.containsKey(invocations[i][0]))
            {
                ArrayList<Integer> l=new  ArrayList<Integer>();
                l.add(invocations[i][1]);
                h.put(invocations[i][0],l);
            }
            else
            {
                 ArrayList<Integer> l=h.get(invocations[i][0]);
                l.add(invocations[i][1]);
                h.put(invocations[i][0],l);
            }
        } 
        Queue<Integer> q=new LinkedList<Integer>();
        HashSet<Integer> hset=new HashSet<Integer>();
        hset.add(k);
        q.add(k);
        while(q.size()>0)
        {
            int x=q.poll();
            if(h.containsKey(x))
            {
                ArrayList<Integer> l=h.get(x);
                for(int i=0;i<l.size();i++)
                {
                        if(!hset.contains(l.get(i)))
                        {
                            hset.add(l.get(i));
                            q.add(l.get(i));
                        }
                }
            }
        }
       ArrayList<Integer> result=new  ArrayList<Integer>();
         HashSet<Integer> hs=new HashSet<Integer>();
       for(int i=0;i<n;i++)
       {
            if(i!=k)
            {
                if(!hs.contains(i) && !hset.contains(i))
                {
                    hs.add(i);
                 q=new LinkedList<Integer>();
                q.add(i);
                while(q.size()>0)
                {
                    int x=q.poll();
                   if(h.containsKey(x))
                    {
                        ArrayList<Integer> l=h.get(x);
                        for(int p=0;p<l.size();p++)
                        {
                                if(!hset.contains(l.get(p)) && !hs.contains(l.get(p)))
                                {
                                    hs.add(l.get(p));
                                    q.add(l.get(p));
                                }
                                else 
                                {
                                    if(hset.contains(l.get(p)))
                                    {
                                        for(int t=0;t<n;t++)
                                        {
                                            result.add(t);
                                        }
                                        return result;
                                    }
                                }
                        }
                    }
                }
                }
            }
       }
       for(int i=0;i<n;i++)
       {
        if(!hset.contains(i))
        {
            result.add(i);
        }
       }
      return result;

    }
}
