class Solution {
    public int maxDistance(int[][] grid) {
       int visited[][]=new int[grid.length][grid[0].length];
       int distance[][]=new int[grid.length][grid[0].length];
       Queue<int []> q=new LinkedList<int []>();
       for(int i=0;i<grid.length;i++)
       {
           for(int j=0;j<grid[0].length;j++)
           {
                 if(grid[i][j]==1)
                 {
                     int arr[]=new int[2];
                     arr[0]=i;
                     arr[1]=j;
                     distance[i][j]=0;
                      visited[i][j]=1;
                     q.add(arr);
                 }
           }
       } 
       if(q.size()==0 || q.size()==grid.length*grid[0].length)
       {
           return -1;
       }

       while(q.size()>0)
       {
           int a[]=q.poll();
           int x=a[0];
           int y=a[1];
           int dist=distance[x][y];
           if(x-1>=0)
           {
               if(grid[x-1][y]==0)
               {
                    if(visited[x-1][y]==0)
                    {
                        visited[x-1][y]=1;
                        int arr[]=new int[2];
                        arr[0]=x-1;
                        arr[1]=y;
                        q.add(arr);
                         distance[x-1][y]=dist+1;
                    }
                    else
                    {
                        if(dist+1<distance[x-1][y])
                        { 
                            distance[x-1][y]=dist+1;
                        }
                    }
               }
           }
           if(x+1<grid.length)
           {
               if(grid[x+1][y]==0)
               {
                    if(visited[x+1][y]==0)
                    {
                        visited[x+1][y]=1;
                        int arr[]=new int[2];
                        arr[0]=x+1;
                        arr[1]=y;
                        q.add(arr);
                        distance[x+1][y]=dist+1;
                    }
                    else
                    {
                        if(dist+1<distance[x+1][y])
                        { 
                            distance[x+1][y]=dist+1;
                        }
                    }
                    
               }
           }
           if(y+1<grid[0].length)
           {
               if(grid[x][y+1]==0)
               {
                    if(visited[x][y+1]==0)
                    {
                        visited[x][y+1]=1;
                        int arr[]=new int[2];
                        arr[0]=x;
                        arr[1]=y+1;
                        q.add(arr);
                        distance[x][y+1]=dist+1;
                    }
                    else
                    {
                        if(dist+1<distance[x][y+1])
                        { 
                            distance[x][y+1]=dist+1;
                        }
                    }
                    
               }
           }
            if(y-1>=0)
           {
               if(grid[x][y-1]==0)
               {
                    if(visited[x][y-1]==0)
                    {
                        visited[x][y-1]=1;
                        int arr[]=new int[2];
                        arr[0]=x;
                        arr[1]=y-1;
                        q.add(arr);
                        distance[x][y-1]=dist+1;
                    }
                    else
                    {
                        if(dist+1<distance[x][y-1])
                        { 
                            distance[x][y-1]=dist+1;
                        }
                    }
                    
               }
           }

       }
        int max=0;
       for(int i=0;i<grid.length;i++)
       {
           for(int j=0;j<grid[0].length;j++)
           {
               if(distance[i][j]>max)
               {
                    max=distance[i][j];
               }
           }
       }

       return max;
    }
}
