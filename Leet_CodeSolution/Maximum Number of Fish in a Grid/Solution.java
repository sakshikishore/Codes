class Solution {
    public int findMaxFish(int[][] grid) {
        HashSet<String> h=new HashSet<String>();
        int max=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]!=0)
                {
                    String str=Integer.toString(i)+" "+Integer.toString(j);
                    if(!h.contains(str))
                    {
                        h.add(str);
                        int totalFish=0;
                        Queue<String> q=new LinkedList<String>();
                        q.add(str);
                        while(q.size()>0)
                        {
                            String s[]=q.poll().split(" ");
                            int x=Integer.parseInt(s[0]);
                            int y=Integer.parseInt(s[1]);
                            totalFish+=grid[x][y];
                            if(x-1>=0 && grid[x-1][y]!=0)
                            {
                                str=Integer.toString(x-1)+" "+Integer.toString(y);
                                if(!h.contains(str))
                                {
                                    h.add(str);
                                    q.add(str);
                                }
                            }
                            if(x+1<grid.length && grid[x+1][y]!=0)
                            {
                                str=Integer.toString(x+1)+" "+Integer.toString(y);
                                if(!h.contains(str))
                                {
                                    h.add(str);
                                    q.add(str);
                                }
                            }
                            if(y-1>=0 && grid[x][y-1]!=0)
                            {
                                str=Integer.toString(x)+" "+Integer.toString(y-1);
                                if(!h.contains(str))
                                {
                                    h.add(str);
                                    q.add(str);
                                }
                            }
                            if(y+1<grid[0].length && grid[x][y+1]!=0)
                            {
                                str=Integer.toString(x)+" "+Integer.toString(y+1);
                                if(!h.contains(str))
                                {
                                    h.add(str);
                                    q.add(str);
                                }
                            }
                            
                        }
                        
                        if(totalFish>max)
                        {
                            max=totalFish;
                        }
                    }
                }
            }
        }
        
        return max;
    }
}
