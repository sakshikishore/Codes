class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[]=new int[graph.length]; // 1 or 2
        for(int j=0;j<graph.length;j++)
        {
            if(color[j]==0)
            {
                Queue<Integer> q=new LinkedList<Integer>();
                q.add(j);
                color[j]=1;
                while(q.size()>0)
                {
                    int x=q.poll();
                    int c=color[x];
                    for(int i=0;i<graph[x].length;i++)
                    {
                        int p=graph[x][i];
                        if(color[p]==0)
                        {
                            if(c==1)
                            {
                            color[p]=2;
                            }
                            else
                            {
                                color[p]=1;
                            }
                            q.add(p);
                        }
                        else
                        {
                            if(color[p]==c)
                            {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;

    }
}
