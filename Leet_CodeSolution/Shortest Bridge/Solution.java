class Node
{
    int x;
    int y;
    public Node(int i, int j)
    {
        this.x=i;
        this.y=j;
    }
    
}
class ListNode
{
    int x;
    int y;
    int count;
    public ListNode(int i, int j,int count)
    {
        this.x=i;
        this.y=j;
        this.count=count;
    }
}
class Solution {
    public int shortestBridge(int[][] grid) {
        int visited[][]=new int[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    Node node=new Node(i,j);
                    visited[i][j]=1;
                    Queue<Node> q=new LinkedList<Node>();
                    q.add(node);  
                    while(q.size()>0)
                    {
                        node=q.poll();
                        count++;
                        int x=node.x;
                        int y=node.y;
                        if(x-1>=0 && grid[x-1][y]==1)
                        {
                            Node p=new Node(x-1,y);
                            if(visited[x-1][y]==0)
                            {
                                visited[x-1][y]=1;
                                q.add(p);
                            }
                        }
                        if(x+1<grid.length && grid[x+1][y]==1)
                        {
                             Node p=new Node(x+1,y);
                             if(visited[x+1][y]==0)
                            {
                                visited[x+1][y]=1;
                                q.add(p);
                            }
                        }
                        if(y-1>=0 && grid[x][y-1]==1)
                        {
                            Node p=new Node(x,y-1);
                             if(visited[x][y-1]==0)
                            {
                                visited[x][y-1]=1;
                                q.add(p);
                            }
                        }
                        if(y+1<grid[0].length && grid[x][y+1]==1)
                        {
                             Node p=new Node(x,y+1);
                             if(visited[x][y+1]==0)
                            {
                                visited[x][y+1]=1;
                                q.add(p);
                            }
                        }
                    }
                    break;

                }
            }
            if(count>0)
            {
                break;
            }
        }
       Queue<ListNode> q=new LinkedList<ListNode>();
        for(int i=0;i<visited.length;i++)
        {
            for(int j=0;j<visited[0].length;j++)
            {
                if(visited[i][j]==1)
                {
                    ListNode list=new ListNode(i,j,0);
                    grid[i][j]=-1;
                    q.add(list);
                }

            }
        }
        while(q.size()>0)
        {
            ListNode p=q.poll();
            int i=p.x;
            int j=p.y;
            int c=p.count;
            if(i-1>=0 && grid[i-1][j]!=-1)
            {
                if(grid[i-1][j]==1)
                {
                    return c;
                }
                else
                {
                    grid[i-1][j]=-1;
                    ListNode list=new ListNode(i-1,j,c+1);
                    q.add(list);
                }
            }
            if(i+1<grid.length && grid[i+1][j]!=-1)
            {
                if(grid[i+1][j]==1)
                {
                    return c;
                }
                else
                {
                    grid[i+1][j]=-1;
                    ListNode list=new ListNode(i+1,j,c+1);
                    q.add(list);
                }
            }
            if(j-1>=0 && grid[i][j-1]!=-1)
            {
                if(grid[i][j-1]==1)
                {
                    return c;
                }
                else
                {
                    grid[i][j-1]=-1;
                    ListNode list=new ListNode(i,j-1,c+1);
                    q.add(list);
                }
            }
            if(j+1<grid[0].length && grid[i][j+1]!=-1)
            {
                if(grid[i][j+1]==1)
                {
                    return c;
                }
                else
                {
                    grid[i][j+1]=-1;
                    ListNode list=new ListNode(i,j+1,c+1);
                    q.add(list);
                }
            }
        }

        return -1;

    }
}
