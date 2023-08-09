class Solution {
    public int maxProductPath(int[][] grid) {
        List<List<Long>> list=new ArrayList();
        int count=-1;
        for(int i=grid.length-1;i>=0;i--)
        {
            for(int j=grid[i].length-1;j>=0;j--)
            {
                ArrayList<Long> l=new ArrayList<Long>();
                count++;
                list.add(l);
                if(i==grid.length-1)
                {
                    if(j==grid[i].length-1)
                    {
                        list.get(count).add(grid[i][j]*1l);
                    }
                    else
                    {
                        
                        list.get(count).add(grid[i][j]*list.get(count-1).get(0));
                        
                    }
                }
                else if(j==grid[i].length-1)
                {
                        int x=count-grid[0].length;
                        list.get(count).add(grid[i][j]*list.get(x).get(0));
                }
                else
                {
                    long max=-1;
                    long min=Long.MAX_VALUE;
                   for(int k=0;k<list.get(count-1).size();k++)
                   {
                      if(grid[i][j]*list.get(count-1).get(k)>max)
                      {
                           max=grid[i][j]*list.get(count-1).get(k);
                      }
                      if(grid[i][j]*list.get(count-1).get(k)<min)
                      {
                           min=grid[i][j]*list.get(count-1).get(k);
                      }
                   }
                   int p=grid[0].length;
                   int x=count-grid[0].length;
                   for(int k=0;k<list.get(x).size();k++)
                   {
                      if(grid[i][j]*list.get(x).get(k)>max)
                      {
                           max=grid[i][j]*list.get(x).get(k);
                      }
                      if(grid[i][j]*list.get(x).get(k)<min)
                      {
                           min=grid[i][j]*list.get(x).get(k);
                      }
                   }
                   list.get(count).add(max);
                   list.get(count).add(min);


                }
            }
        }
        long max=-1;
        for(int i=0;i<list.get(count).size();i++)
        {
           long val=list.get(count).get(i);
           if(val>max)
           {
               max=val;
           }

        }
        long res=max%(1000000007);
        return (int)res;

    }
}
