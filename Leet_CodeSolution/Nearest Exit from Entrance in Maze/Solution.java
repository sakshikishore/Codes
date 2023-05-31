class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int arr[][]=new int[maze.length][maze[0].length];
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                arr[i][j]=-1;
            }
        }
        arr[entrance[0]][entrance[1]]=0;
        HashSet<String> h=new HashSet<String>();
        String str=Integer.toString(entrance[0])+" "+Integer.toString(entrance[1]);
        h.add(str);
        Queue<String> q=new LinkedList<String>();
        q.add(str);
        while(q.size()>0)
        {
            String s[]=q.poll().split(" ");
            int x=Integer.parseInt(s[0]);
            int y=Integer.parseInt(s[1]);
            int steps=arr[x][y];
            if(x-1>=0)
            {
                if(maze[x-1][y]=='.')
                {
                    str=Integer.toString(x-1)+" "+Integer.toString(y);
                    if(h.contains(str))
                    {
                        int p=arr[x-1][y];
                        if(p>steps+1)
                        {
                            arr[x-1][y]=steps+1;
                            q.add(str);
                        }
                    }
                    else
                    {
                        h.add(str);
                        arr[x-1][y]=steps+1;
                        q.add(str);
                    }
                }
            }
            if(x+1<arr.length)
            {
                if(maze[x+1][y]=='.')
                {
                    str=Integer.toString(x+1)+" "+Integer.toString(y);
                    if(h.contains(str))
                    {
                        int p=arr[x+1][y];
                        if(p>steps+1)
                        {
                            arr[x+1][y]=steps+1;
                            q.add(str);
                        }
                    }
                    else
                    {
                        h.add(str);
                        arr[x+1][y]=steps+1;
                        q.add(str);
                    }
                }
            }
            if(y-1>=0)
            {
                if(maze[x][y-1]=='.')
                {
                    str=Integer.toString(x)+" "+Integer.toString(y-1);
                    if(h.contains(str))
                    {
                        int p=arr[x][y-1];
                        if(p>steps+1)
                        {
                            arr[x][y-1]=steps+1;
                            q.add(str);
                        }
                    }
                    else
                    {
                        h.add(str);
                        arr[x][y-1]=steps+1;
                        q.add(str);
                    }
                }
            }
            if(y+1<arr[0].length)
            {
                if(maze[x][y+1]=='.')
                {
                    str=Integer.toString(x)+" "+Integer.toString(y+1);
                    if(h.contains(str))
                    {
                        int p=arr[x][y+1];
                        if(p>steps+1)
                        {
                            arr[x][y+1]=steps+1;
                            q.add(str);
                        }
                    }
                    else
                    {
                        h.add(str);
                        arr[x][y+1]=steps+1;
                        q.add(str);
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr[0].length;i++)
        {
           if(arr[0][i]!=-1 && arr[0][i]<min && arr[0][i]!=0)
           {
               min=arr[0][i];
           }

           if(arr[arr.length-1][i]!=-1 && arr[arr.length-1][i]<min && arr[arr.length-1][i]!=0 )
           {
               min=arr[arr.length-1][i];
           }
          
        }
         for(int i=0;i<arr.length;i++)
        {
           if(arr[i][0]!=-1 && arr[i][0]<min && arr[i][0]!=0)
           {
               min=arr[i][0];
           }

           if(arr[i][arr[0].length-1]!=-1 && arr[i][arr[0].length-1]<min && arr[i][arr[0].length-1]!=0)
           {
               min=arr[i][arr[0].length-1];
           }
          
        }
        if(min==Integer.MAX_VALUE)
        {
            min=-1;
        }
        return min;
    }
}
