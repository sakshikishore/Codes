class Solution {
    public int closedIsland(int[][] grid) {
        int result=0;
        HashSet<String> h=new HashSet<String>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==0)
                {
                    String str=Integer.toString(i)+" "+Integer.toString(j);
                    if(!h.contains(str))
                    {
                        h.add(str);
                        Queue<String> q=new LinkedList<String>();
                        q.add(str);
                        int flag=0;
                        while(q.size()>0)
                        {
                            String s[]=q.poll().split(" ");
                            int x=Integer.parseInt(s[0]);
                            int y=Integer.parseInt(s[1]);
                            if(x==0 || x==grid.length-1 || y==0 || y==grid[0].length-1)
                            {
                                flag=1;
                            }
                            if((x-1>=0) && grid[x-1][y]==0)
                            {
                                str=Integer.toString(x-1)+" "+Integer.toString(y);
                                if(!h.contains(str))
                                {
                                    q.add(str);
                                    h.add(str);
                                }
                            } 
                            if((x+1<grid.length) && grid[x+1][y]==0)
                            {
                                str=Integer.toString(x+1)+" "+Integer.toString(y);
                                if(!h.contains(str))
                                {
                                    q.add(str);
                                    h.add(str);
                                }
                            } 
                            if((y-1>=0) && grid[x][y-1]==0)
                            {
                                str=Integer.toString(x)+" "+Integer.toString(y-1);
                                if(!h.contains(str))
                                {
                                    q.add(str);
                                    h.add(str);
                                }
                            }
                             if((y+1<grid[0].length) && grid[x][y+1]==0)
                            {
                                str=Integer.toString(x)+" "+Integer.toString(y+1);
                                if(!h.contains(str))
                                {
                                    q.add(str);
                                    h.add(str);
                                }
                            } 
                        }
                        if(flag==0)
                        {
                            result++;
                        }
                    }
                }
            }
        }
        
        return result;
    }
}
