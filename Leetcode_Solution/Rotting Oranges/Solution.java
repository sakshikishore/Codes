class Solution {
    public int orangesRotting(int[][] grid) {
        HashMap<String,Integer> h=new HashMap<String,Integer>();
        int result=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    String str=Integer.toString(i)+" "+Integer.toString(j);
                    h.put(str,0);
                    Queue<String> q=new LinkedList<String>();
                    q.add(str);
                    HashSet<String> hset=new HashSet<String>();
                    hset.add(str);
                    grid[i][j]=-1;
                    while(q.size()>0)
                    {
                        String s=q.poll();
                        int t=h.get(s);
                        String st[]=s.split(" ");
                        int x=Integer.parseInt(st[0]);
                        int y=Integer.parseInt(st[1]);
                        if(x-1>=0)
                        {
                            if(grid[x-1][y]==1)
                            {
                                str=Integer.toString(x-1)+" "+Integer.toString(y);
                                if(!hset.contains(str))
                                {
                                    hset.add(str);
                                    if(h.containsKey(str))
                                    {
                                        int t1=h.get(str);
                                        int t2=t+1;
                                        h.put(str,Math.min(t1,t2));
                                    }
                                    else
                                    {
                                      h.put(str,t+1);
                                    }
                                    q.add(str);
                                }
                            }
                        }
                            if(x+1<grid.length && grid[x+1][y]==1)
                            {
                                str=Integer.toString(x+1)+" "+Integer.toString(y);
                                if(!hset.contains(str))
                                {
                                    hset.add(str);
                                     if(h.containsKey(str))
                                    {
                                        int t1=h.get(str);
                                        int t2=t+1;
                                        h.put(str,Math.min(t1,t2));
                                    }
                                    else
                                    {
                                      h.put(str,t+1);
                                    }
                                    q.add(str);
                                }
                            }
                            if(y-1>=0 && grid[x][y-1]==1)
                            {
                                str=Integer.toString(x)+" "+Integer.toString(y-1);
                                if(!hset.contains(str))
                                {
                                    hset.add(str);
                                    if(h.containsKey(str))
                                    {
                                        int t1=h.get(str);
                                        int t2=t+1;
                                        h.put(str,Math.min(t1,t2));
                                    }
                                    else
                                    {
                                      h.put(str,t+1);
                                    }
                                    q.add(str);
                                }
                            }
                           if(y+1<grid[0].length && grid[x][y+1]==1)
                            {
                                str=Integer.toString(x)+" "+Integer.toString(y+1);
                                if(!hset.contains(str))
                                {
                                    hset.add(str);
                                     if(h.containsKey(str))
                                    {
                                        int t1=h.get(str);
                                        int t2=t+1;
                                        h.put(str,Math.min(t1,t2));
                                    }
                                    else
                                    {
                                      h.put(str,t+1);
                                    }
                                    q.add(str);
                                }
                           }        
                    }
                }
            }
        }
         for(int i=0;i<grid.length;i++)
         {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    String str=Integer.toString(i)+" "+Integer.toString(j);
                    if(!h.containsKey(str))
                    {
                        result=-1;
                        break;
                    }
                }
            }
            if(result==-1)
            {
                break;
            }
         }
        if(result!=-1)
        {
            for(Map.Entry<String,Integer> entry:h.entrySet())
            {
                int x=entry.getValue();
                if(x>result)
                {
                    result=x;
                }
            }
        }
        
        return result;
    }
}
