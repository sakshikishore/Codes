class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        HashMap<Integer,ArrayList<Integer>> h=new  HashMap<Integer,ArrayList<Integer>>();
        int count=0;
        for(int i=0;i<allowedSwaps.length;i++)
        {
            if(!h.containsKey(allowedSwaps[i][0]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(allowedSwaps[i][1]);
                h.put(allowedSwaps[i][0],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(allowedSwaps[i][0]);
                l.add(allowedSwaps[i][1]);
                h.put(allowedSwaps[i][0],l);
            }
              if(!h.containsKey(allowedSwaps[i][1]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(allowedSwaps[i][0]);
                h.put(allowedSwaps[i][1],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(allowedSwaps[i][1]);
                l.add(allowedSwaps[i][0]);
                h.put(allowedSwaps[i][1],l);
            }
        }
        HashSet<Integer> hset= new HashSet<Integer>();
       for(int i=0;i<source.length;i++)
       {
           if(!hset.contains(i))
           {
            Queue<Integer> q=new LinkedList<Integer>();
            q.add(i);
            hset.add(i);
            PriorityQueue<Integer> pq1=new PriorityQueue<Integer>();
            HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
            while(q.size()>0)
            {
                int x=q.poll();
                pq1.add(source[x]);
                if(!map.containsKey(target[x]))
                {
                    map.put(target[x],1);
                }
                else
                {
                    map.put(target[x],map.get(target[x])+1);
                }
                if(h.containsKey(x))
                {
                    ArrayList<Integer> l=h.get(x);
                    for(int j=0;j<l.size();j++)
                    {
                        if(!hset.contains(l.get(j)))
                        {
                            q.add(l.get(j));
                            hset.add(l.get(j));
                        }
                    }
                }
            }
                  while(pq1.size()>0)
                  {
                    int z=pq1.poll();
                     if(map.containsKey(z))
                     {
                        count++;
                        if(map.get(z)==1)
                        {
                            map.remove(z);
                        }
                        else
                        {
                            map.put(z,map.get(z)-1);
                        }
                     }
                  }
           }
       }
       return target.length-count;

    }
}
