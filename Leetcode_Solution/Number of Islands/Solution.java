class Solution {
    public int numIslands(char[][] grid) {
        HashSet<String> h=new HashSet<String>();
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    String str=Integer.toString(i)+" "+Integer.toString(j);
                    if(!h.contains(str))
                    {
                        Queue<String> q=new LinkedList<String>();
                        count++;
                        q.add(str);
                        h.add(str);
                        while(q.size()>0)
                        {
                            String s[]=q.poll().split(" ");
                            int x=Integer.parseInt(s[0]);
                            int y=Integer.parseInt(s[1]);
                            if(x-1>=0)
                            {
                                if(grid[x-1][y]=='1')
                                {
                                    str=Integer.toString(x-1)+" "+Integer.toString(y);
                                    if(!h.contains(str))
                                    {
                                        h.add(str);
                                        q.add(str);
                                    }
                                }
                            }
                              if(x+1<grid.length)
                              {
                                if(grid[x+1][y]=='1')
                                {
                                    str=Integer.toString(x+1)+" "+Integer.toString(y);
                                    if(!h.contains(str))
                                    {
                                        h.add(str);
                                        q.add(str);
                                    }
                                }
                              }
                              if(y-1>=0)
                              {
                                if(grid[x][y-1]=='1')
                                {
                                    str=Integer.toString(x)+" "+Integer.toString(y-1);
                                    if(!h.contains(str))
                                    {
                                        h.add(str);
                                        q.add(str);
                                    }
                                }
                              }
                            if(y+1<grid[i].length)
                            {
                                if(grid[x][y+1]=='1')
                                {
                                    str=Integer.toString(x)+" "+Integer.toString(y+1);
                                    if(!h.contains(str))
                                    {
                                        h.add(str);
                                        q.add(str);
                                    }
                                }
                                
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }
}
