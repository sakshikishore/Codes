class Solution {
    public boolean containsCycle(char[][] grid) {
        HashSet<String> hset=new HashSet<String>();
        boolean result=false;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                String str=Integer.toString(i)+" "+Integer.toString(j);
                
                if(!hset.contains(str))
                {
                    char c=grid[i][j];
                    Queue<String> q=new LinkedList<String>();
                    hset.add(str);
                    String a="-1 -1";
                    q.add(str+","+a);
                    while(q.size()>0)
                    {
                        String s=q.poll();
                        String k[]=s.split(",");
                        String p[]=k[0].split(" ");
                        int x=Integer.parseInt(p[0]);
                        int y=Integer.parseInt(p[1]);
                        if(x+1<grid.length && grid[x+1][y]==c)
                        {
                             str=Integer.toString(x+1)+" "+Integer.toString(y);
                            if(!str.equals(k[1]))
                            {
                                str=Integer.toString(x+1)+" "+Integer.toString(y);
                                if(hset.contains(str))
                                {
                                    result=true;
                                    break;
                                }
                                else
                                {
                                    q.add(str+","+k[0]);
                                    hset.add(str);
                                }
                            }
                        }
                        if(x-1>=0 && grid[x-1][y]==c)
                        {
                            str=Integer.toString(x-1)+" "+Integer.toString(y);
                            if(!str.equals(k[1]))
                            {
                                q.add(str+","+k[0]);
                                if(hset.contains(str))
                                {
                                    result=true;
                                    break;
                                }
                                else
                                {
                                    hset.add(str);
                                }
                            }
                        }
                        if(y+1<grid[0].length && grid[x][y+1]==c)
                        {
                            str=Integer.toString(x)+" "+Integer.toString(y+1);
                            if(!str.equals(k[1]))
                            {
                               str=Integer.toString(x)+" "+Integer.toString(y+1);
                                q.add(str+","+k[0]);
                                if(hset.contains(str))
                                {
                                    result=true;
                                    break;
                                }
                                else
                                {
                                    hset.add(str);
                                }
                            }
                        }
                        if(y-1>=0 && grid[x][y-1]==c)
                        {
                            str=Integer.toString(x)+" "+Integer.toString(y-1);
                            if(!str.equals(k[1]))
                            {
                                q.add(str+","+k[0]);
                                if(hset.contains(str))
                                {
                                    result=true;
                                    break;
                                }
                                else
                                {
                                    hset.add(str);
                                }
                            }
                        }
                    }
                }
                if(result)
                {
                    break;
                }
            }
            if(result)
                {
                    break;
                }
        }
        
        return result;
    }
}
