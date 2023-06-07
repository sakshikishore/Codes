class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int arr[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                arr[i][j]=grid[i][j];
            }
        }
        int existingColor=grid[row][col];
        Queue<String> q=new LinkedList<String>();
        String str=Integer.toString(row)+" "+Integer.toString(col);
        q.add(str);
        HashSet<String> h=new HashSet<String>();
        h.add(str);
        if(row==0 || row==grid.length-1 || col==0 || col==grid[0].length-1)
        {
         arr[row][col]=color;
        }
        else
        {
            if((row-1>=0 && grid[row-1][col]!=existingColor) ||((row+1)<grid.length && grid[row+1][col]!=existingColor) || (col-1>=0 && grid[row][col-1]!=existingColor) ||(col+1<grid[0].length && grid[row][col+1]!=existingColor))
            {
                arr[row][col]=color;
            }
        }
        while(q.size()>0)
        {
           String s[]=q.poll().split(" ");
           int x=Integer.parseInt(s[0]);
           int y=Integer.parseInt(s[1]);
           if(x-1>=0) 
           {
               if(grid[x-1][y]==existingColor && (y==0 || x-1==0 || y==grid[0].length-1))
               {
                   str=Integer.toString(x-1)+" "+Integer.toString(y);
                   if(!h.contains(str))
                   {
                       h.add(str);
                       q.add(str);
                       arr[x-1][y]=color;
                   }
               }
               else if(grid[x-1][y]==existingColor)
               {
                   str=Integer.toString(x-1)+" "+Integer.toString(y);
                   if((x-2>=0 && grid[x-2][y]!=existingColor) || (grid[x][y]!=existingColor) || (y-1>=0 && grid[x-1][y-1]!=existingColor) ||(y+1<grid[0].length && grid[x-1][y+1]!=existingColor))
                    {
                      if(!h.contains(str))
                        {
                            h.add(str);
                            q.add(str);
                            arr[x-1][y]=color;
                        }
                    }
                    else
                    {
                            if(!h.contains(str))
                            {
                                h.add(str);
                                q.add(str);
                            }
                    }
               }
           }
           if(x+1<grid.length)
           {
               if(grid[x+1][y]==existingColor && (x+1==grid.length-1 || y==grid[0].length-1 || y==0))
               {
                   str=Integer.toString(x+1)+" "+Integer.toString(y);
                   if(!h.contains(str))
                   {
                       h.add(str);
                       q.add(str);
                       arr[x+1][y]=color;
                   }
               }
               else if(grid[x+1][y]==existingColor)
               {
                   str=Integer.toString(x+1)+" "+Integer.toString(y);
                 if(grid[x][y]!=existingColor || (x+2<grid.length && grid[x+2][y]!=existingColor) || (y-1>=0 && grid[x+1][y-1]!=existingColor) ||(y+1<grid[0].length && grid[x+1][y+1]!=existingColor))
                    {
                      if(!h.contains(str))
                        {
                            h.add(str);
                            q.add(str);
                            arr[x+1][y]=color;
                        }
                    }
                    else
                    {
                        if(!h.contains(str))
                        {
                            h.add(str);
                            q.add(str);
                        }
                    }
               }
           }
           if(y-1>=0)
           {
               if(grid[x][y-1]==existingColor && (x==0 || x==grid.length-1 || y-1==0))
                {
                   str=Integer.toString(x)+" "+Integer.toString(y-1);
                   if(!h.contains(str))
                   {
                       h.add(str);
                       q.add(str);
                       arr[x][y-1]=color;
                   }
                }
                else if(grid[x][y-1]==existingColor)
                {
                   str=Integer.toString(x)+" "+Integer.toString(y-1);
                   if((x-1>=0 && grid[x-1][y-1]!=existingColor) || (x+1<grid.length && grid[x+1][y-1]!=existingColor) || (y-2>=0 && grid[x][y-2]!=existingColor) ||(grid[x][y]!=existingColor))
                    {
                      if(!h.contains(str))
                        {
                            h.add(str);
                            q.add(str);
                            arr[x][y-1]=color;
                        }
                    }
                    else
                    {
                        if(!h.contains(str))
                        {
                            h.add(str);
                            q.add(str);
                        }
                    }
                }
           }
           if(y+1<grid[0].length)
           {
               if(grid[x][y+1]==existingColor && (x==0 || x==grid.length-1 || y+1==grid[0].length-1))
               {
                   str=Integer.toString(x)+" "+Integer.toString(y+1);
                   if(!h.contains(str))
                   {
                       h.add(str);
                       q.add(str);
                       arr[x][y+1]=color;
                   }
               }
               else if(grid[x][y+1]==existingColor)
               {
                   str=Integer.toString(x)+" "+Integer.toString(y+1);
                   if((x-1>=0 && grid[x-1][y+1]!=existingColor) || (x+1<grid.length && grid[x+1][y+1]!=existingColor) || (grid[x][y]!=existingColor) ||(y+2<grid[0].length && grid[x][y+2]!=existingColor))
                    {
                      if(!h.contains(str))
                        {
                            h.add(str);
                            q.add(str);
                            arr[x][y+1]=color;
                        }
                    }
                    else
                    {
                        if(!h.contains(str))
                        {
                            h.add(str);
                            q.add(str);
                        }
                    }
               }
           }
        }

        return arr;
    }
}
