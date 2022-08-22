class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> list=new ArrayList();
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<edges.length;i++)
        {
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
        for(int i=0;i<n;i++)
        {
            if(h.containsKey(i))
            {
                HashSet<Integer> hset=new HashSet<Integer>();
                ArrayList<Integer> l=h.get(i);
                ArrayList<Integer> al=new ArrayList<Integer>();
                Queue<Integer> q=new LinkedList<Integer>();
                for(int j=0;j<l.size();j++)
                {
                    q.add(l.get(j));
                    hset.add(l.get(j));
                }
                while(q.size()>0)
                {
                    int x=q.poll();
                    al.add(x);
                    if(h.containsKey(x))
                    {
                         ArrayList<Integer> m=h.get(x);
                         for(int j=0;j<m.size();j++)
                         {
                             if(!hset.contains(m.get(j)))
                             {
                                 hset.add(m.get(j));
                               q.add(m.get(j));
                             }
                         }
                    }
                }
                Collections.sort(al);
                list.add(al);
            }
            else
            {
                ArrayList<Integer> al=new ArrayList<Integer>();
                list.add(al);
            }
        }
        
        return list;
    }
}
