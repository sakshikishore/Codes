class Node
{
    int a,b;
    public Node(int i,int j)
    {
       a=i;
       b=j;
    }
}
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int visited[][]=new int[moveTime.length][moveTime[0].length];
        int f[][]=new int[moveTime.length][moveTime[0].length];
        int v[][]=new int[moveTime.length][moveTime[0].length];
        for(int i=0;i<visited.length;i++)
        {
            Arrays.fill(visited[i],-1);
        }

        visited[0][0]=1;
        f[0][0]=0;
        Queue<Node> q=new LinkedList<Node>();
        int arr[][]=new int[moveTime.length][moveTime[0].length];
        v[0][0]=1;
        q.add(new Node(0,0));
        while(q.size()>0)
        {
            Node node=q.poll();
            int x=node.a;
            int y=node.b;
            v[x][y]=0;
            int time=arr[x][y];
            int flag=f[x][y];
            //System.out.println(x+" "+y+" "+arr[x][y]+" "+flag);
            if(x-1>=0)
            {
                if(visited[x-1][y]==-1)
                {
                    visited[x-1][y]=1;
                    int tim=Math.max(moveTime[x-1][y],time);
                    if(flag==0)
                    {
                       arr[x-1][y]=tim+1;
                        f[x-1][y]=1;
                       if(v[x-1][y]==0)
                       {
                          v[x-1][y]=1;
                         
                          q.add(new Node(x-1,y));
                       }
                    }
                    else
                    {
                       arr[x-1][y]=tim+2;
                         f[x-1][y]=0;
                       if(v[x-1][y]==0)
                       {
                          v[x-1][y]=1;
                         
                        q.add(new Node(x-1,y));
                       }
                       
                    } 
                }
                else
                {
                     int tim=Math.max(moveTime[x-1][y],time);
                     if(flag==0)
                     {
                        tim=tim+1;
                     }
                     else
                     {
                        tim=tim+2;
                     }
                     if(arr[x-1][y]>tim)
                     {
                        arr[x-1][y]=tim;
                      
                        if(flag==1)
                        {
                            f[x-1][y]=0;
                            if(v[x-1][y]==0)
                            {
                                v[x-1][y]=1;
                                
                                q.add(new Node(x-1,y));
                            }
                        }
                        else
                        {
                             f[x-1][y]=1;
                            if(v[x-1][y]==0)
                            {
                                v[x-1][y]=1;
                               
                            q.add(new Node(x-1,y));
                            }
                        }
                     }
                }
            }
             if(y-1>=0)
            {
                if(visited[x][y-1]==-1)
                {
                    visited[x][y-1]=1;
                    int tim=Math.max(moveTime[x][y-1],time);
                    if(flag==0)
                    {
                        f[x][y-1]=1;
                       arr[x][y-1]=tim+1;
                       if(v[x][y-1]==0)
                       {
                        v[x][y-1]=1;
                        
                       q.add(new Node(x,y-1));
                       }
                    }
                    else
                    {
                       arr[x][y-1]=tim+2;
                        f[x][y-1]=0;
                       if(v[x][y-1]==0)
                       {
                        v[x][y-1]=1;
                       q.add(new Node(x,y-1));
                       }
                    } 
                }
                else
                {
                     int tim=Math.max(moveTime[x][y-1],time);
                     if(flag==0)
                     {
                        tim=tim+1;
                     }
                     else
                     {
                        tim=tim+2;
                     }
                     if(arr[x][y-1]>tim)
                     {
                        
                        arr[x][y-1]=tim;
                        if(flag==1)
                        {
                              f[x][y-1]=0;
                             if(v[x][y-1]==0)
                             {
                                v[x][y-1]=1;
                            q.add(new Node(x,y-1));
                             }
                        }
                        else
                        {
                              f[x][y-1]=1;
                            if(v[x][y-1]==0)
                            {
                                v[x][y-1]=1;
                                q.add(new Node(x,y-1));
                            }
                        }
                     }
                }
            }
             if(x+1<visited.length)
            {
                if(visited[x+1][y]==-1)
                {
                    visited[x+1][y]=1;
                    int tim=Math.max(moveTime[x+1][y],time);
                    if(flag==0)
                    {
                       arr[x+1][y]=tim+1;
                        f[x+1][y]=1;
                        if(v[x+1][y]==0)
                        {
                            v[x+1][y]=1;
                           q.add(new Node(x+1,y));
                        }
                    }
                    else
                    {
                       arr[x+1][y]=tim+2;
                       f[x+1][y]=0;
                       if(v[x+1][y]==0)
                        {
                            v[x+1][y]=1;
                           q.add(new Node(x+1,y));
                        }
                    } 
                }
                else
                {
                     int tim=Math.max(moveTime[x+1][y],time);
                     if(flag==0)
                     {
                        tim=tim+1;
                     }
                     else
                     {
                        tim=tim+2;
                     }
                     if(arr[x+1][y]>tim)
                     {
                        
                        arr[x+1][y]=tim;
                        if(flag==1)
                        {
                            f[x+1][y]=0;
                           if(v[x+1][y]==0)
                            {
                                v[x+1][y]=1;
                            q.add(new Node(x+1,y));
                            }
                        }
                        else
                        {
                            f[x+1][y]=1;
                           if(v[x+1][y]==0)
                            {
                                v[x+1][y]=1;
                            q.add(new Node(x+1,y));
                            }
                        }
                     }
                }
            }
             if(y+1<visited[0].length)
            {
                if(visited[x][y+1]==-1)
                {
                    visited[x][y+1]=1;
                    int tim=Math.max(moveTime[x][y+1],time);
                    if(flag==0)
                    {
                       arr[x][y+1]=tim+1;
                       f[x][y+1]=1;
                       if(v[x][y+1]==0)
                        {
                            v[x][y+1]=1;
                           q.add(new Node(x,y+1));
                        }
                    }
                    else
                    {
                       arr[x][y+1]=tim+2;
                       f[x][y+1]=0;
                       if(v[x][y+1]==0)
                        {
                            v[x][y+1]=1;
                           q.add(new Node(x,y+1));
                        }

                      
                    } 
                }
                else
                {
                     int tim=Math.max(moveTime[x][y+1],time);
                     if(flag==0)
                     {
                        tim=tim+1;
                     }
                     else
                     {
                        tim=tim+2;
                     }
                     if(arr[x][y+1]>tim)
                     {
                        
                        arr[x][y+1]=tim;
                        if(flag==1)
                        {
                          f[x][y+1]=0;
                       if(v[x][y+1]==0)
                        {
                            v[x][y+1]=1;
                           q.add(new Node(x,y+1));
                        }
                        }
                        else
                        {
                           f[x][y+1]=1;
                            if(v[x][y+1]==0)
                                {
                                    v[x][y+1]=1;
                                q.add(new Node(x,y+1));
                                }
                            }
                     }
                }
            }
        }
     
      
        return arr[visited.length-1][visited[0].length-1];

        
    }
}
