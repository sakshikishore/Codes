class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0)
        {
            return false;
        }
        int n=grid.length;
        HashSet<Integer> h=new HashSet<Integer>();
        int i=0,j=0;
        Queue<String> q=new LinkedList<String>();
        String s=Integer.toString(i)+" "+Integer.toString(j);
        q.add(s);
        h.add(grid[0][0]);
        while(q.size()>0)
        {
            String str[]=q.poll().split(" ");
            int x=Integer.parseInt(str[0]);
            int y=Integer.parseInt(str[1]);
            int r=grid[x][y];
            System.out.println(r);
            HashSet<Integer> hset=new HashSet<Integer>();
            if(x+2<grid.length && y+1<grid[0].length)
            {
                hset.add(grid[x+2][y+1]);
                if(!h.contains(grid[x+2][y+1]))
                {
                    h.add(grid[x+2][y+1]);
                    String p=Integer.toString(x+2)+" "+Integer.toString(y+1);
                    q.add(p);
                }
            }
            if(x+2<grid.length && y-1>=0)
            {
                hset.add(grid[x+2][y-1]);
                if(!h.contains(grid[x+2][y-1]))
                {
                    h.add(grid[x+2][y-1]);
                    String p=Integer.toString(x+2)+" "+Integer.toString(y-1);
                    q.add(p);
                }
            }
             if(x-2>=0 && y-1>=0)
            {
                hset.add(grid[x-2][y-1]);
                if(!h.contains(grid[x-2][y-1]))
                {
                    h.add(grid[x-2][y-1]);
                    String p=Integer.toString(x-2)+" "+Integer.toString(y-1);
                    q.add(p);
                }
            }
             if(x-2>=0 && y+1<grid[0].length)
            {
                hset.add(grid[x-2][y+1]);
                if(!h.contains(grid[x-2][y+1]))
                {
                    h.add(grid[x-2][y+1]);
                    String p=Integer.toString(x-2)+" "+Integer.toString(y+1);
                    q.add(p);
                }
            }
            
            // Two Horizontal move and 1 vertical move
            
            if(x+1<grid.length && y+2<grid[0].length)
            {
                hset.add(grid[x+1][y+2]);
                if(!h.contains(grid[x+1][y+2]))
                {
                    h.add(grid[x+1][y+2]);
                    String p=Integer.toString(x+1)+" "+Integer.toString(y+2);
                    q.add(p);
                }
            }
            if(x+1<grid.length && y-2>=0)
            {
                hset.add(grid[x+1][y-2]);
                if(!h.contains(grid[x+1][y-2]))
                {
                    h.add(grid[x+1][y-2]);
                    String p=Integer.toString(x+1)+" "+Integer.toString(y-2);
                    q.add(p);
                }
            }
             if(x-1>=0 && y-2>=0)
            {
                hset.add(grid[x-1][y-2]);
                if(!h.contains(grid[x-1][y-2]))
                {
                    h.add(grid[x-1][y-2]);
                    String p=Integer.toString(x-1)+" "+Integer.toString(y-2);
                    q.add(p);
                }
            }
             if(x-1>=0 && y+2<grid[0].length)
            {
                hset.add(grid[x-1][y+2]);
                if(!h.contains(grid[x-1][y+2]))
                {
                    h.add(grid[x-1][y+2]);
                    String p=Integer.toString(x-1)+" "+Integer.toString(y+2);
                    q.add(p);
                }
            }

            if((r != (n*n)-1) && !hset.contains(r+1))
            {
                System.out.println(r+1);
                return false;
            }
            
        }
        
        if(h.size()==n*n)
        {
            return true;
        }
        
        return false;
        
    }
}
