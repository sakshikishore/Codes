class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean result=false;
        if(source==destination)
        {
            return true;
        }
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
        
        Queue<Integer> q=new LinkedList<Integer>();
        if(h.containsKey(source) && h.containsKey(destination))
        {
            HashSet<Integer> hset=new HashSet<Integer>();
            q.add(source);
            while(q.size()>0)
            {
                int key=q.poll();
                ArrayList<Integer> l=h.get(key);
                for(int j=0;j<l.size();j++)
                {
                    int x=l.get(j);
                    if(x==destination)
                    {
                        result=true;
                        break;
                    }
                    else
                    {
                        if(!hset.contains(x))
                        {
                            hset.add(x);
                            q.add(x);
                        }
                    }
                }
                
                if(result)
                {
                    break;
                }
            }
        }
        
        return result;
    }
}
