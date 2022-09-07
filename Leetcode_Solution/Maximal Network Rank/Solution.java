class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer,HashSet<Integer>> h=new HashMap<Integer,HashSet<Integer>>();
        for(int i=0;i<roads.length;i++)
        {
            if(!h.containsKey(roads[i][0]))
            {
                HashSet<Integer> l=new HashSet<Integer>();
                l.add(roads[i][1]);
                h.put(roads[i][0],l);
            }
            else
            {
                HashSet<Integer> l=h.get(roads[i][0]);
                l.add(roads[i][1]);
                h.put(roads[i][0],l);
            }
            if(!h.containsKey(roads[i][1]))
            {
               HashSet<Integer> l=new HashSet<Integer>();
                l.add(roads[i][0]);
                h.put(roads[i][1],l);
            }
            else
            {
                HashSet<Integer> l=h.get(roads[i][1]);
                l.add(roads[i][0]);
                h.put(roads[i][1],l);
            }
        }
        int max=0;
        for(int i=0;i<n-1;i++)
        {
               HashSet<Integer> hset=new HashSet<Integer>();
               HashSet<String>set=new HashSet<String>();
               if(h.containsKey(i))
                {
                   hset=h.get(i);
                   Iterator<Integer> itr=hset.iterator();
                   while(itr.hasNext())
                   {
                       int x=itr.next();
                       if(x>i)
                       {
                           String s=Integer.toString(i)+" "+Integer.toString(x);
                           set.add(s);
                       }
                       else
                       {
                           String s=Integer.toString(x)+" "+Integer.toString(i);
                           set.add(s);
                       }
                   }
                }
            for(int j=i+1;j<n;j++)
            {
                int p=0;
                if(h.containsKey(j))
                {
                    Iterator<Integer> itr=h.get(j).iterator();
                    while(itr.hasNext())
                    {
                        int x=itr.next();
                        if(x>j)
                        {
                            String s=Integer.toString(j)+" "+Integer.toString(x);
                            if(!set.contains(s))
                            {
                                p++;
                            }
                        }
                        else
                        {
                            String s=Integer.toString(x)+" "+Integer.toString(j);
                            if(!set.contains(s))
                            {
                                p++;
                            }
                        }
                    }
                }
                
                if(set.size()+p>max)
                {
                    max=set.size()+p;
                }
            }
        }
        
        
        return max;
    }
}
