class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        HashSet<String> h=new HashSet<String>();
        int max=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                     String str=Integer.toString(i)+" "+Integer.toString(j);
                    if(!h.contains(str))
                    {
                        int count=0;
                        Queue<String> q=new LinkedList<String>();
                        q.add(str);
                        while(q.size()!=0)
                        {
                            String p=q.poll();
                            h.add(p);
                            count++;
                            String st[]=p.split(" ");
                            int a=Integer.parseInt(st[0]);
                            int b=Integer.parseInt(st[1]);
                            if(a+1<grid.length)
                            {
                                if(grid[a+1][b]==1)
                                {
                            String s=Integer.toString(a+1)+" "+Integer.toString(b);
                                     if(!h.contains(s))
                                     {
                                         h.add(s);
                                         q.add(s);
                                     }
                                }
                            }
                            if(a-1>=0)
                            {
                                if(grid[a-1][b]==1)
                                {
                            String s=Integer.toString(a-1)+" "+Integer.toString(b);
                                    if(!h.contains(s))
                                    {
                                        h.add(s);
                                        q.add(s);
                                    }
                                }
                            }
                            if(b+1<grid[i].length)
                            {
                                if(grid[a][b+1]==1)
                                {
                                String s=Integer.toString(a)+" "+Integer.toString(b+1);
                                     if(!h.contains(s))
                                    {
                                        h.add(s);
                                        q.add(s);
                                    }
                                }
                            }
                            if(b-1>=0)
                            {
                                if(grid[a][b-1]==1)
                                {
                                String s=Integer.toString(a)+" "+Integer.toString(b-1);
                                     if(!h.contains(s))
                                    {
                                        h.add(s);
                                        q.add(s);
                                    }
                                }
                            }
                        }
                        if(count>max)
                        {
                            max=count;
                        }
                    }
                }

            }
        }
        
        return max;
    }
}
