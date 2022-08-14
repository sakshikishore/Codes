class Solution {
    public int edgeScore(int[] edges) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int max=-1;
        int node=-1;
        for(int i=0;i<edges.length;i++)
        {
            if(!h.containsKey(edges[i]))
            {
                h.put(edges[i],i);
                if(i>max)
                {
                    max=i;
                    node=edges[i];
                }
                else if(i==max)
                {
                    if(node>edges[i])
                    {
                        node=edges[i];
                    }
                }
            }
            else
            {
                h.put(edges[i],h.get(edges[i])+i);
                if(h.get(edges[i])>max)
                {
                    max=h.get(edges[i]);
                    node=edges[i];
                }
                 else if(h.get(edges[i])==max)
                {
                    if(node>edges[i])
                    {
                        node=edges[i];
                    }
                }
            }
        }
        
        return node;
    }
}
