class Solution {
    public long countPairs(int n, int[][] edges) {
        long m=n;
        long total_pair=(m*(m-1))/2;
        long available_pair=0;
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<edges.length;i++)
        {
            if(!h.containsKey(edges[i][0]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(edges[i][1]);
                h.put(edges[i][0],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(edges[i][0]);
                l.add(edges[i][1]);
                h.put(edges[i][0],l);
            }
            if(!h.containsKey(edges[i][1]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(edges[i][0]);
                h.put(edges[i][1],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(edges[i][1]);
                l.add(edges[i][0]);
                h.put(edges[i][1],l);
            }
        }
        HashSet<Integer> hset=new HashSet<Integer>();
        for(int i=0;i<n;i++)
        {
              if(!hset.contains(i))
              {
                   long count=1;
                   hset.add(i);
                   Queue<Integer> q=new LinkedList<Integer>();
                   q.add(i);
                   while(q.size()>0)
                   {
                       int x=q.poll();
                       if(h.containsKey(x))
                       {
                           ArrayList<Integer> al=h.get(x);
                           for(int j=0;j<al.size();j++)
                           {
                               if(!hset.contains(al.get(j)))
                               {
                                hset.add(al.get(j));
                                count++;
                                q.add(al.get(j));
                               }
                               
                           }
                       }
                   }
                   if(count>1)
                   {
                      available_pair+=((count)*(count-1))/2; 
                   }
                  
              }
        }
        
        return total_pair-available_pair;
        
    }
}
