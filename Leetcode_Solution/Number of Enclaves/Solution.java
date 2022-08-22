class Solution {
    public int numEnclaves(int[][] grid) {
        HashSet<String> hset=new HashSet<String>();
        int result=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                    String s=Integer.toString(i)+" "+Integer.toString(j);
                    if(!hset.contains(s))
                    {
                        int flag=0;
                        int count=0;
                        Queue<String> q=new LinkedList<String>();
                        q.add(s);
                        hset.add(s);
                        while(q.size()>0)
                        {
                            String str[]=q.poll().split(" ");
                            count++;
                            int x=Integer.parseInt(str[0]);
                            int y=Integer.parseInt(str[1]);
                            if(flag==0)
                            {
                            if((x==0) || (x==grid.length-1) || (y==0) || (y==grid[i].length-1))
                                {
                                    flag=1;
                                }
                            }
                                if(x-1>=0)
                                {
                                    if(grid[x-1][y]==1)
                                    {
                                      s=Integer.toString(x-1)+" "+Integer.toString(y);
                                      if(!hset.contains(s))
                                      {
                                          hset.add(s);
                                          q.add(s);
                                      }
                                    
                                    }
                                    
                                }
                                if(x+1<grid.length)
                                {
                                    if(grid[x+1][y]==1)
                                    {
                                      s=Integer.toString(x+1)+" "+Integer.toString(y);
                                      if(!hset.contains(s))
                                      {
                                          hset.add(s);
                                          q.add(s);
                                      }
                                    
                                    }
                                }
                                if(y-1>=0)
                                {
                                    if(grid[x][y-1]==1)
                                    {
                                      s=Integer.toString(x)+" "+Integer.toString(y-1);
                                      if(!hset.contains(s))
                                      {
                                          hset.add(s);
                                          q.add(s);
                                      }
                                    
                                    }
                                }
                                if(y+1<grid[0].length)
                                {
                                    if(grid[x][y+1]==1)
                                    {
                                      s=Integer.toString(x)+" "+Integer.toString(y+1);
                                      if(!hset.contains(s))
                                      {
                                          hset.add(s);
                                          q.add(s);
                                      }
                                    
                                    }
                                }
                        }
                        if(flag==0)
                        {
                            result=result+count;
                        }
                    }
                }
            }
        }
        
        return result;
    }
}
