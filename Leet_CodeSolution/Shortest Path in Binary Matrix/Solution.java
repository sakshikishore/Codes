class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1)
        {
            return -1;
        }
        int arr[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
               if(grid[i][j]==1)
               {
                   arr[i][j]=-1;
               }
            }
        }

        arr[arr.length-1][arr[0].length-1]=1;
        Queue<String> q=new LinkedList<String>();
        String str=Integer.toString(arr.length-1)+" "+Integer.toString(arr[0].length-1);
        q.add(str);
        while(q.size()>0)
        {
            String s[]=q.poll().split(" ");
            int x=Integer.parseInt(s[0]);
            int y=Integer.parseInt(s[1]);
            int val=arr[x][y];
            if(x-1>=0)
            {
                if(arr[x-1][y]!=-1)
                {
                    if(arr[x-1][y]==0)
                    {
                        arr[x-1][y]=val+1;
                        str=Integer.toString(x-1)+" "+Integer.toString(y);
                        q.add(str);
                    }
                    else
                    {
                        if(arr[x-1][y]>val+1)
                        {
                            arr[x-1][y]=val+1;
                            str=Integer.toString(x-1)+" "+Integer.toString(y);
                            q.add(str);

                        }
                    }
                }
            }
            if(y-1>=0)
            {
                if(arr[x][y-1]!=-1)
                {
                    if(arr[x][y-1]==0)
                    {
                        arr[x][y-1]=val+1;
                        str=Integer.toString(x)+" "+Integer.toString(y-1);
                        q.add(str);
                    }
                    else
                    {
                        if(arr[x][y-1]>val+1)
                        {
                            arr[x][y-1]=val+1;
                            str=Integer.toString(x)+" "+Integer.toString(y-1);
                            q.add(str);

                        }
                    }
                }
            }
            if(x+1<arr.length)
            {
                if(arr[x+1][y]!=-1)
                {
                    if(arr[x+1][y]==0)
                    {
                        arr[x+1][y]=val+1;
                        str=Integer.toString(x+1)+" "+Integer.toString(y);
                        q.add(str);
                    }
                    else
                    {
                        if(arr[x+1][y]>val+1)
                        {
                            arr[x+1][y]=val+1;
                            str=Integer.toString(x+1)+" "+Integer.toString(y);
                            q.add(str);

                        }
                    }
                }
            }
            if(y+1<arr[0].length)
            {
                if(arr[x][y+1]!=-1)
                {
                    if(arr[x][y+1]==0)
                    {
                        arr[x][y+1]=val+1;
                        str=Integer.toString(x)+" "+Integer.toString(y+1);
                        q.add(str);
                    }
                    else
                    {
                        if(arr[x][y+1]>val+1)
                        {
                            arr[x][y+1]=val+1;
                            str=Integer.toString(x)+" "+Integer.toString(y+1);
                            q.add(str);

                        }
                    }
                }
            }
            if(x-1>=0 && y-1>=0)
            {
                    System.out.println("here");
                if(arr[x-1][y-1]!=-1)
                {
                    if(arr[x-1][y-1]==0)
                    {
                        arr[x-1][y-1]=val+1;
                        str=Integer.toString(x-1)+" "+Integer.toString(y-1);
                        q.add(str);
                    }
                    else
                    {
                        if(arr[x-1][y-1]>val+1)
                        {
                            arr[x-1][y-1]=val+1;
                            str=Integer.toString(x-1)+" "+Integer.toString(y-1);
                            q.add(str);

                        }
                    }
                }
            }
            if(x-1>=0 && y+1<arr[0].length)
            {
                if(arr[x-1][y+1]!=-1)
                {
                    if(arr[x-1][y+1]==0)
                    {
                        arr[x-1][y+1]=val+1;
                        str=Integer.toString(x-1)+" "+Integer.toString(y+1);
                        q.add(str);
                    }
                    else
                    {
                        if(arr[x-1][y+1]>val+1)
                        {
                            arr[x-1][y+1]=val+1;
                            str=Integer.toString(x-1)+" "+Integer.toString(y+1);
                            q.add(str);

                        }
                    }
                }
            }
            if(x+1<arr.length && y-1>=0)
            {
                if(arr[x+1][y-1]!=-1)
                {
                    if(arr[x+1][y-1]==0)
                    {
                        arr[x+1][y-1]=val+1;
                        str=Integer.toString(x+1)+" "+Integer.toString(y-1);
                        q.add(str);
                    }
                    else
                    {
                        if(arr[x+1][y-1]>val+1)
                        {
                            arr[x+1][y-1]=val+1;
                            str=Integer.toString(x+1)+" "+Integer.toString(y-1);
                            q.add(str);

                        }
                    }
                }
            }
            if(x+1<arr.length && y+1<arr[0].length)
            {
                if(arr[x+1][y+1]!=-1)
                {
                    if(arr[x+1][y+1]==0)
                    {
                        arr[x+1][y+1]=val+1;
                        str=Integer.toString(x+1)+" "+Integer.toString(y+1);
                        q.add(str);
                    }
                    else
                    {
                        if(arr[x+1][y+1]>val+1)
                        {
                            arr[x+1][y+1]=val+1;
                            str=Integer.toString(x+1)+" "+Integer.toString(y+1);
                            q.add(str);

                        }
                    }
                }
            }




        }
            if(arr[0][0]==0)
            {
                return -1;
            }
        return arr[0][0];

    }
}
