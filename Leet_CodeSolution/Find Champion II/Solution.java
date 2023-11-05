class Solution {
    public int findChampion(int n, int[][] edges) {
       HashSet<Integer> hset= new HashSet<Integer>();
        for(int i=0;i<edges.length;i++)
        {
            hset.add(edges[i][1]);
        }
        if(hset.size()!=n-1)
        {
            return -1;
        }
        else
        {
            for(int i=0;i<n;i++)
            {
                if(!hset.contains(i))
                {
                    return i;
                }
            }
        }
        
        return -1;
        
    }
}
