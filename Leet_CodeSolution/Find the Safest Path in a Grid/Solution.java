class Node
{
    int x,y,val;
    public Node(int x,int y,int val)
    {
        this.x=x;
        this.y=y;
        this.val=val;
    }
}
class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int max=0;
        int arr[][]=new int[grid.size()][grid.size()];
        Queue<Node> q=new LinkedList<Node>();
        int visited[][]=new int[arr.length][arr.length];
        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid.get(0).size();j++)
            {
                if(grid.get(i).get(j)==1)
                {
                    Node node=new Node(i,j,0);
                    q.add(node);
                    visited[i][j]=1;
                }
            }
        }
        while(q.size()>0)
        {
           Node node=q.poll();
           int x=node.x;
           int y=node.y;
           int val=node.val;
           if(x-1>=0)
           {
               if(visited[x-1][y]==0)
               {
                   visited[x-1][y]=1;
                   Node p=new Node(x-1,y,val+1);
                   q.add(p);
                   arr[x-1][y]=val+1;
               }
           }
           if(x+1<arr.length)
           {
                if(visited[x+1][y]==0)
               {
                   visited[x+1][y]=1;
                   Node p=new Node(x+1,y,val+1);
                   q.add(p);
                   arr[x+1][y]=val+1;
               }
           }
           if(y-1>=0)
           {
               if(visited[x][y-1]==0)
               {
                   visited[x][y-1]=1;
                   Node p=new Node(x,y-1,val+1);
                   q.add(p);
                   arr[x][y-1]=val+1;
                   
               }
           }
           if(y+1<arr[0].length)
           {
               if(visited[x][y+1]==0)
               {
                   visited[x][y+1]=1;
                   Node p=new Node(x,y+1,val+1);
                   q.add(p);
                   arr[x][y+1]=val+1;

               }
           }
        }
       if(arr[0][0]==0 || arr[arr.length-1][arr.length-1]==0)
       {
           return 0;
       }
       Node node=new Node(0,0,arr[0][0]);
       q.add(node);
       int a[][]=new int[arr.length][arr.length];
       for(int i=0;i<a.length;i++)
       {
           for(int j=0;j<a.length;j++)
           {
               a[i][j]=-1;
           }
       }
       a[0][0]=arr[0][0];
       while(q.size()>0)
       {
           node=q.poll();
           int x=node.x;
           int y=node.y;
           int val=node.val;
           if(x==arr.length-1 && y==arr.length-1)
           {
               if(val>max)
               {
                   max=val;
               }
           }
           if(x-1>=0)
           {
                if(arr[x-1][y]<val)
                {
                    if(a[x-1][y]==-1)
                    {
                        a[x-1][y]=arr[x-1][y];
                        q.add(new Node(x-1,y,a[x-1][y]));
                    }
                    else
                    {
                        if(a[x-1][y]<arr[x-1][y])
                        {
                            a[x-1][y]=arr[x-1][y];
                            q.add(new Node(x-1,y,a[x-1][y]));
                        }

                    }
                }
                else
                {
                    if(a[x-1][y]==-1)
                    {
                        a[x-1][y]=val;
                        q.add(new Node(x-1,y,a[x-1][y]));
                    }
                    else
                    {
                        if(a[x-1][y]<val)
                        {
                            a[x-1][y]=val;
                            q.add(new Node(x-1,y,a[x-1][y]));
                        }

                    }
                }
           }
            if(y-1>=0)
           {
                if(arr[x][y-1]<val)
                {
                    if(a[x][y-1]==-1)
                    {
                        a[x][y-1]=arr[x][y-1];
                        q.add(new Node(x,y-1,a[x][y-1]));
                    }
                    else
                    {
                        if(a[x][y-1]<arr[x][y-1])
                        {
                            a[x][y-1]=arr[x][y-1];
                            q.add(new Node(x,y-1,a[x][y-1]));
                        }

                    }
                }
                else
                {
                    if(a[x][y-1]==-1)
                    {
                        a[x][y-1]=val;
                        q.add(new Node(x,y-1,a[x][y-1]));
                    }
                    else
                    {
                        if(a[x][y-1]<val)
                        {
                            a[x][y-1]=val;
                            q.add(new Node(x,y-1,a[x][y-1]));
                        }

                    }
                }
                
           }
            if(x+1<arr.length)
           {
                if(arr[x+1][y]<val)
                {
                    if(a[x+1][y]==-1)
                    {
                        a[x+1][y]=arr[x+1][y];
                        q.add(new Node(x+1,y,a[x+1][y]));
                    }
                    else
                    {
                        if(a[x+1][y]<arr[x+1][y])
                        {
                            a[x+1][y]=arr[x+1][y];
                            q.add(new Node(x+1,y,a[x+1][y]));
                        }

                    }
                }
                else
                {
                    if(a[x+1][y]==-1)
                    {
                        a[x+1][y]=val;
                        q.add(new Node(x+1,y,a[x+1][y]));
                    }
                    else
                    {
                        if(a[x+1][y]<val)
                        {
                            a[x+1][y]=val;
                            q.add(new Node(x+1,y,a[x+1][y]));
                        }

                    }
                }
           }
            if(y+1<arr.length)
           {
                if(arr[x][y+1]<val)
                {
                    if(a[x][y+1]==-1)
                    {
                        a[x][y+1]=arr[x][y+1];
                        q.add(new Node(x,y+1,a[x][y+1]));
                    }
                    else
                    {
                        if(a[x][y+1]<arr[x][y+1])
                        {
                            a[x][y+1]=arr[x][y+1];
                            q.add(new Node(x,y+1,a[x][y+1]));
                        }

                    }
                }
                else
                {
                    if(a[x][y+1]==-1)
                    {
                        a[x][y+1]=val;
                        q.add(new Node(x,y+1,a[x][y+1]));
                    }
                    else
                    {
                        if(a[x][y+1]<val)
                        {
                            a[x][y+1]=val;
                            q.add(new Node(x,y+1,a[x][y+1]));
                        }

                    }
                }
                
           }
       }

       return max;
       
    }
}
