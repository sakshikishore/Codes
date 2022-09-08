class Solution {
    public int largestMagicSquare(int[][] grid) {
        int r=Math.min(grid.length,grid[0].length);
        int result=-1;
        for(int i=r;i>=1;i--)
        {
            for(int j=0;j<=grid.length-i;j++)
            {
                for(int k=0;k<=grid[0].length-i;k++)
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    for(int x=j;x<j+i;x++)
                    {
                        int rowSum=0;
                        for(int y=k;y<k+i;y++)
                        {
                            rowSum+=grid[x][y];
                        }
                        l.add(rowSum);
                    }
                    for(int y=k;y<k+i;y++)
                    {
                        int colSum=0;
                        for(int x=j;x<j+i;x++)
                        {
                            colSum+=grid[x][y];
                        }
                        l.add(colSum);
                    }
                    int x=j,y=k;
                    int D1=0;
                    while(x<j+i && y<k+i)
                    {
                        D1+=grid[x][y];
                        x++;
                        y++;
                    }
                    l.add(D1);
                    x=j;
                    y=k+i-1;
                    int D2=0;
                    while(y>=k && x<j+i)
                    {
                        D2+=grid[x][y];
                        x++;
                        y--;
                    }
                    l.add(D2);
                    Collections.sort(l);
             
                        int a=l.get(0);
                        int b=l.get(l.size()-1);
                    if(a==b)
                    {
                        result=i;
                        break;
                    }
                }
                if(result!=-1)
                {
                    break;
                }
            }
            if(result!=-1)
            {
                break;
            }
        }
        
        return result;
    }
}
