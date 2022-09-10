class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int result[]=new int[2];
        int n=edges.length;
        int p[]=new int[n+1];
        for(int i=0;i<p.length;i++)
        {
            p[i]=i;
        }
        for(int i=0;i<n;i++)
        {
            int v1=edges[i][0];
            int v2=edges[i][1];
            int node=v1;
            while(p[node]!=node)
            {
                node=p[node];
            }
            p[v1]=node;
            node=v2;
            while(p[node]!=node)
            {
                node=p[node];
            }
            p[v2]=node;
            if(p[v1]==p[v2])
            {
                result[0]=v1;
                result[1]=v2;
                return result;
            }
            else
            {
                p[node]=p[p[v1]];
            }
            
        }
        
        return result;
    }
}
