class Node
{
    int r,c,cnt;
    public Node(int x, int y, int count)
    {
        r=x;
        c=y;
        cnt=count;
    }

}
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int visited[][]=new int[matrix.length][matrix[0].length];
        int result=1;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(visited[i][j]==0)
                {
                    visited[i][j]=1;
                    Queue<Node> q=new LinkedList<Node>();
                    q.add(new Node(i,j,1));
                    while(q.size()>0)
                    {
                        Node node=q.poll();
                        int x=node.r;
                        int y=node.c;
                        if(node.cnt>result)
                        {
                            result=node.cnt;
                        }
                        if(x-1>=0 && matrix[x-1][y]>matrix[x][y] && visited[x-1][y]<node.cnt+1)
                        {
                            visited[x-1][y]=node.cnt+1;
                            q.add(new Node(x-1,y,node.cnt+1));
                        }
                        if(y-1>=0 && matrix[x][y-1]>matrix[x][y] && visited[x][y-1]<node.cnt+1)
                        {
                            visited[x][y-1]=node.cnt+1;
                            q.add(new Node(x,y-1,node.cnt+1));
                        }
                        if(x+1<matrix.length && matrix[x+1][y]>matrix[x][y] && visited[x+1][y]<node.cnt+1)
                        {
                            visited[x+1][y]=node.cnt+1;
                            q.add(new Node(x+1,y,node.cnt+1));
                        }
                        if(y+1<matrix[0].length && matrix[x][y+1]>matrix[x][y] && visited[x][y+1]<node.cnt+1)
                        {
                            visited[x][y+1]=node.cnt+1;
                            q.add(new Node(x,y+1,node.cnt+1));
                        }           

                    }

                }
            }
        }

        return result;
    }
}
