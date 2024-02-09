class Node
{
    int x;
    int y;
    public Node(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public boolean hasValidPath(int[][] grid) {
        Queue<Node> q=new LinkedList<Node>();
        Node node=new Node(0,0);
        q.add(node);
        int visited[][]=new int[grid.length][grid[0].length];
        visited[0][0]=1;
        while(q.size()>0)
        {
            node=q.poll();
            int x=node.x;
            int y=node.y;
            if(x==grid.length-1 && y==grid[0].length-1)
            {
                return true;
            }
            if(grid[x][y]==1)
            {
                if(y==0)
                {
                    if(y+1<grid[0].length)
                    {
                         if((grid[x][y+1]==3 || grid[x][y+1]==5 || grid[x][y+1]==1) && visited[x][y+1]==0)
                         {
                             Node p=new Node(x,y+1);
                             q.add(p);
                             visited[x][y+1]=1;
                         }
                    }
                }
                else if(y==grid[0].length-1)
                {
                    if(y-1>=0)
                    {
                         if((grid[x][y-1]==4 || grid[x][y-1]==6 || grid[x][y-1]==1) && visited[x][y-1]==0)
                         {
                             Node p=new Node(x,y-1);
                             q.add(p);
                             visited[x][y-1]=1;
                         }
                    }
                }
                else
                {
                         if((grid[x][y+1]==3 || grid[x][y+1]==5 || grid[x][y+1]==1) && visited[x][y+1]==0)
                         {
                             Node p=new Node(x,y+1);
                             q.add(p);
                             visited[x][y+1]=1;
                         }
                          if((grid[x][y-1]==4 || grid[x][y-1]==6 || grid[x][y-1]==1) && visited[x][y-1]==0)
                         {
                             Node p=new Node(x,y-1);
                             q.add(p);
                             visited[x][y-1]=1;
                         }
                }
            }
            else if(grid[x][y]==2)
            {
                if(x==0)
                {
                    if(x+1<grid.length)
                    {
                        if((grid[x+1][y]==5 || grid[x+1][y]==6 || grid[x+1][y]==2) && visited[x+1][y]==0)
                        {
                             Node p=new Node(x+1,y);
                             q.add(p);
                             visited[x+1][y]=1;
                        }
                    }
                }
                else if(x==grid.length-1)
                {
                    if((grid[x-1][y]==3 || grid[x-1][y]==4 || grid[x-1][y]==2) && visited[x-1][y]==0)
                        {
                             Node p=new Node(x-1,y);
                             q.add(p);
                             visited[x-1][y]=1;
                        }
                }
                else
                {
                     if((grid[x+1][y]==5 || grid[x+1][y]==6 || grid[x+1][y]==2) && visited[x+1][y]==0)
                        {
                             Node p=new Node(x+1,y);
                             q.add(p);
                             visited[x+1][y]=1;
                        }
                        if((grid[x-1][y]==3 || grid[x-1][y]==4 || grid[x-1][y]==2) && visited[x-1][y]==0)
                        {
                             Node p=new Node(x-1,y);
                             q.add(p);
                             visited[x-1][y]=1;
                        }
                }
            }
            else if(grid[x][y]==3)
            {
                        if(y-1>=0)
                        {
                            if((grid[x][y-1]==1 || grid[x][y-1]==6 || grid[x][y-1]==6) && visited[x][y-1]==0)
                            {
                                 Node p=new Node(x,y-1);
                                 q.add(p);
                                 visited[x][y-1]=1;
                            }
                        }
                        if(x+1<grid.length)
                        {
                            if((grid[x+1][y]==5 || grid[x+1][y]==6 || grid[x+1][y]==2) && visited[x+1][y]==0)
                            {
                                Node p=new Node(x+1,y);
                                q.add(p);
                                visited[x+1][y]=1;
                            }
                        }
                    
            }
            else if(grid[x][y]==4)
            {
                if(y+1<grid[0].length)
                {
                    if((grid[x][y+1]==3 || grid[x][y+1]==1 || grid[x][y+1]==5) && visited[x][y+1]==0)
                    {
                                Node p=new Node(x,y+1);
                                q.add(p);
                                visited[x][y+1]=1;
                    }
                }
                 if(x+1<grid.length)
                        {
                            if((grid[x+1][y]==5 || grid[x+1][y]==6 || grid[x+1][y]==2) && visited[x+1][y]==0)
                            {
                                Node p=new Node(x+1,y);
                                q.add(p);
                                visited[x+1][y]=1;
                            }
                        }
            }
            else if(grid[x][y]==5)
            {
               if(x-1>=0)
               {
                   if((grid[x-1][y]==2 || grid[x-1][y]==3 || grid[x-1][y]==4) && visited[x-1][y]==0)
                   {
                       Node p=new Node(x-1,y);
                                q.add(p);
                                visited[x-1][y]=1;
                   }
               }
                if(y-1>=0)
                        {
                            if((grid[x][y-1]==1 || grid[x][y-1]==6 || grid[x][y-1]==6) && visited[x][y-1]==0)
                            {
                                 Node p=new Node(x,y-1);
                                 q.add(p);
                                 visited[x][y-1]=1;
                            }
                        }
            }
            else
            {
                 if(y+1<grid[0].length)
                {
                    if((grid[x][y+1]==3 || grid[x][y+1]==1 || grid[x][y+1]==5) && visited[x][y+1]==0)
                    {
                                Node p=new Node(x,y+1);
                                q.add(p);
                                visited[x][y+1]=1;
                    }
                }
               if(x-1>=0)
               {
                   if((grid[x-1][y]==2 || grid[x-1][y]==3 || grid[x-1][y]==4) && visited[x-1][y]==0)
                   {
                       Node p=new Node(x-1,y);
                                q.add(p);
                                visited[x-1][y]=1;
                   }
               }
            }
        }


        return false;
    }
}
