class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        HashSet<String> hset=new HashSet<String>();
        int result=0;
        for(int i=0;i<grid2.length;i++)
        {
            for(int j=0;j<grid2[i].length;j++)
            {
                if(grid2[i][j]==1)
                {
                    String str=Integer.toString(i)+" "+Integer.toString(j);
                    if(!hset.contains(str))
                    {
                        hset.add(str);
                        Queue<String> q=new LinkedList<String>();
                        q.add(str);
                        int flag=0;
                        while(q.size()>0)
                        {
                            String s1=q.poll();
                            String s[]=s1.split(" ");
                            int x=Integer.parseInt(s[0]);
                            int y=Integer.parseInt(s[1]);
                            if(grid1[x][y]!=1)
                            {
                                flag=1;
                            }
                            if(x-1>=0)
                            {
                                if(grid2[x-1][y]==1)
                                {
                                    str=Integer.toString(x-1)+" "+Integer.toString(y);
                                    if(!hset.contains(str))
                                    {
                                        hset.add(str);
                                        q.add(str);
                                    }
                                }
                            }
                            if(x+1<grid2.length)
                            {
                                if(grid2[x+1][y]==1)
                                {
                                    str=Integer.toString(x+1)+" "+Integer.toString(y);
                                    if(!hset.contains(str))
                                    {
                                        hset.add(str);
                                        q.add(str);
                                    }
                                }
                            }
                            if(y-1>=0)
                            {
                                if(grid2[x][y-1]==1)
                                {
                                    str=Integer.toString(x)+" "+Integer.toString(y-1);
                                    if(!hset.contains(str))
                                    {
                                        hset.add(str);
                                        q.add(str);
                                    }
                                }
                            }
                            if(y+1<grid2[0].length)
                            {
                                if(grid2[x][y+1]==1)
                                {
                                    str=Integer.toString(x)+" "+Integer.toString(y+1);
                                    if(!hset.contains(str))
                                    {
                                        hset.add(str);
                                        q.add(str);
                                    }
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
