class Solution {
    public int longestCycle(int[] edges) {
        HashSet<Integer> h=new HashSet<Integer>();
        int max=0;
        for(int i=0;i<edges.length;i++)
        {
            if(!h.contains(i))
            {
                h.add(i);
                HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
                map.put(i,1);
                Queue<Integer> q=new LinkedList();
                q.add(i);
                int count=2;
                while(q.size()>0)
                {
                    int x=q.poll();
                    if(x==-1)
                    {
                        break;
                    }
                    if(map.containsKey(edges[x]))
                    {
                        int a=map.get(edges[x]);
                        int b=map.get(x);
                        if(b-a>max)
                        {
                            max=b-a;
                        }

                    }
                    else
                    {
                        if(h.contains(edges[x]))
                        {
                            break;
                        }
                        else
                        {
                            map.put(edges[x],count);
                            count++;
                            h.add(edges[x]);
                            q.add(edges[x]);
                        }
                    }
                }
                
            }
        }
        if(max==0)
        {
            return -1;
        }
        return max+1;
    }
}
