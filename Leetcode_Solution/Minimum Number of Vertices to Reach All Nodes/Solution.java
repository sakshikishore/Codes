class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashSet<Integer> h=new HashSet<Integer>();
        ArrayList<Integer> result=new ArrayList<Integer>();
        for(int i=0;i<edges.size();i++)
        {
            if(!h.contains(edges.get(i).get(1)))
            {
                h.add(edges.get(i).get(1));
            }
        }
        
        for(int i=0;i<n;i++)
        {
            if(!h.contains(i))
            {
                result.add(i);
            }
        }
        
        return result;
        
    }
}
