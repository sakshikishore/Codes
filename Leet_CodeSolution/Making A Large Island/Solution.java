class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        HashSet<Integer> hset=new HashSet<Integer>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && !hset.contains((i*n)+j))
                {
                    hset.add((i*n)+j);
                    int count=0;
                    Queue<String> q=new LinkedList<String>();
                    q.add(Integer.toString(i)+" "+Integer.toString(j));
                    map.put((i*n)+j,(i*n)+j);
                    while(q.size()>0)
                    {
                        String str[]=q.poll().split(" ");
                        count++;
                        int x=Integer.parseInt(str[0]);
                        int y=Integer.parseInt(str[1]);
                        if(x-1>=0 && grid[x-1][y]==1 && !hset.contains(((x-1)*n)+y))
                        {
                            hset.add(((x-1)*n)+y);
                            q.add(Integer.toString(x-1)+" "+Integer.toString(y));
                            map.put(((x-1)*n)+y,(i*n)+j);
                        }
                        if(y-1>=0 && grid[x][y-1]==1 && !hset.contains(((x)*n)+y-1))
                        {
                            hset.add((x*n)+y-1);
                            q.add(Integer.toString(x)+" "+Integer.toString(y-1));
                            map.put((x*n)+y-1,(i*n)+j);
                        }
                        if(x+1<n && grid[x+1][y]==1 && !hset.contains(((x+1)*n)+y))
                        {
                            hset.add(((x+1)*n)+y);
                            q.add(Integer.toString(x+1)+" "+Integer.toString(y));
                            map.put(((x+1)*n)+y,(i*n)+j);
                        }
                        if(y+1<n && grid[x][y+1]==1 && !hset.contains(((x)*n)+y+1))
                        {
                            hset.add((x*n)+y+1);
                            q.add(Integer.toString(x)+" "+Integer.toString(y+1));
                            map.put((x*n)+y+1,(i*n)+j);
                        }
                    }
                    h.put(i*n+j,count);
                    if(count==n*n)
                    {
                        return count;
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    HashSet<Integer> temp=new HashSet<Integer>();
                    if(i+1<n && grid[i+1][j]==1)
                    {
                       int p=((i+1)*n)+j;
                       temp.add(map.get(p));
                    }
                    if(i-1>=0 && grid[i-1][j]==1)
                    {
                       int p=((i-1)*n)+j;
                       temp.add(map.get(p));
                    }
                    if(j-1>=0 && grid[i][j-1]==1)
                    {
                         int p=(i*n)+j-1;
                         temp.add(map.get(p));
                    }
                    if(j+1<n && grid[i][j+1]==1)
                    {
                         int p=(i*n)+j+1;
                         temp.add(map.get(p));
                    }
                    Iterator<Integer> itr=temp.iterator();
                    int totalConnection=1;
                    while(itr.hasNext())
                    {
                        totalConnection+=h.get(itr.next());
                    }
                    if(totalConnection>max)
                    {
                        max=totalConnection;
                    }
                }
            }
        }
    

        return max;
    }
}
