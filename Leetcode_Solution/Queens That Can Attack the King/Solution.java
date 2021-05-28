class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int count=0;
        List<List<Integer>> list=new ArrayList<>();
        int grid[][]=new int[8][8];
        for(int i=0;i<queens.length;i++)
        {
            grid[queens[i][0]][queens[i][1]]=1;
        }
        for(int i=king[1]-1;i>=0;i--)
        {
            if(grid[king[0]][i]==1)
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(king[0]);
                l.add(i);
                list.add(l);
                break;
            }
        }
         for(int i=king[1]+1;i<8;i++)
         {
            if(grid[king[0]][i]==1)
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(king[0]);
                l.add(i);
                list.add(l);
                break;
            }
        }
         for(int i=king[0]+1;i<8;i++)
         {
            if(grid[i][king[1]]==1)
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                l.add(king[1]);
                list.add(l);
                break;
            }
        }
         for(int i=king[0]-1;i>=0;i--)
         {
            if(grid[i][king[1]]==1)
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                l.add(king[1]);
                list.add(l);
                break;
            }
        }
        int p=king[1]-1;
        for(int i=king[0]-1;i>=0;i--)
        {
            if(p>=0)
            {
            if(grid[i][p]==1)
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                l.add(p);
                list.add(l);
                break;
            }
            }
            else
            {
                break;
            }
            p--;
        }
        p=king[1]+1;
        for(int i=king[0]-1;i>=0;i--)
        {
            if(p<8)
            {
                if(grid[i][p]==1)
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(i);
                    l.add(p);
                    list.add(l);
                    break;
                }
            }
            else
            {
                break;
            }
            
            p++;
        }
         p=king[1]-1;
        for(int i=king[0]+1;i<8;i++)
        {
            if(p>=0)
            {
                if(grid[i][p]==1)
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(i);
                    l.add(p);
                    list.add(l);
                    break;
                }
            }
            else
            {
                break;
            }
            
            p--;
        }
        p=king[1]+1;
        for(int i=king[0]+1;i<8;i++)
        {
            if(p<8)
            {
                if(grid[i][p]==1)
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(i);
                    l.add(p);
                    list.add(l);
                    break;
                }
            }
            else
            {
                break;
            }
            
            p++;
        }
     
       
        return list;
    }
}
