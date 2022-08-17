class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected[i].length;j++)
            {
                if(isConnected[i][j]==1)
                {
                    if(!h.containsKey(i))
                    {
                        ArrayList<Integer> l=new ArrayList<Integer>();
                        l.add(j);
                        h.put(i,l);
                    }
                    else
                    {
                        ArrayList<Integer> l=h.get(i);
                        l.add(j);
                        h.put(i,l);
                    }
                }
            }
        }
        HashSet<Integer> hset=new HashSet<Integer>();
        int count=0;
        for(int i=0;i<isConnected.length;i++)
        {
            if(!hset.contains(i))
            {
                Queue<Integer> q=new LinkedList<Integer>();
                     hset.add(i);
                     q.add(i);
                     count++;
                     while(q.size()>0)
                     {
                         int x=q.poll();
                         ArrayList<Integer> l=h.get(x);
                         for(int j=0;j<l.size();j++)
                         {
                             if(!hset.contains(l.get(j)))
                             {
                                 hset.add(l.get(j));
                                 q.add(l.get(j));
                             }
                         }
                         
                     }
            }
        }
        
        return count;
    }
}
