class Node
{
    int i,j;
    public Node(int x,int y)
    {
        i=x;
        j=y;
    }
}
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int visited[][]=new int[maze.length][maze[0].length];
        Queue<Node> q=new LinkedList<Node>();
        q.add(new Node(start[0],start[1]));
        visited[start[0]][start[1]]=1;
        while(q.size()>0)
        {
              Node node=q.poll();
              int x=node.i;
              int y=node.j;
              if(x==destination[0] && y==destination[1])
              {
                return true;
              }
              int p=x;
              while(p>0)
              {
                 if(p-1>=0)
                 {
                    if(maze[p-1][y]==1)
                    {
                        if(visited[p][y]==0)
                        {
                            visited[p][y]=1;
                           
                            q.add(new Node(p,y));
                            
                        }
                        break;
                    }
                 }
                 p--;
              }
              if(p==0 && visited[p][y]==0)
              {
                visited[p][y]=1;
                q.add(new Node(p,y));
              }

               p=x;
              while(p<maze.length-1)
              {
                 if(p+1<maze.length)
                 {
                    if(maze[p+1][y]==1)
                    {
                        if(visited[p][y]==0)
                        {
                            visited[p][y]=1;
                           
                            q.add(new Node(p,y));
                            
                        }
                        break;
                    }
                 }
                 p++;
              }
              if(p==maze.length-1 && visited[p][y]==0)
              {
                visited[p][y]=1;
                q.add(new Node(p,y));
              }

               p=y;
              while(p>0)
              {
                 if(p-1>=0)
                 {
                    if(maze[x][p-1]==1)
                    {
                        if(visited[x][p]==0)
                        {
                            visited[x][p]=1;
                           
                            q.add(new Node(x,p));
                            
                        }
                        break;
                    }
                 }
                 p--;
              }
              if(p==0 && visited[x][p]==0)
              {
                visited[x][p]=1;
                q.add(new Node(x,p));
              }

               p=y;
              while(p<maze[0].length-1)
              {
                 if(p+1<maze[0].length)
                 {
                    if(maze[x][p+1]==1)
                    {
                        if(visited[x][p]==0)
                        {
                            visited[x][p]=1;
                           
                            q.add(new Node(x,p));
                            
                        }
                        break;
                    }
                 }
                 p++;
              }
              if(p==maze[0].length-1 && visited[x][p]==0)
              {
                visited[x][p]=1;
                q.add(new Node(x,p));
              }
             
        }

        return false;
    }
}
