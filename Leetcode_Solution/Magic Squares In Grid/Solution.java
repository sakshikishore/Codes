class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count=0;
        if(grid.length<3 || grid[0].length<3)
        {
            return 0;
        }
        for(int i=0;i<=grid.length-3;i++)
        {
            for(int j=0;j<=grid[i].length-3;j++)
            {
                int flag=0;
                int ch[]=new int[10];
                int rowSum[]=new int[3];
                int colSum[]=new int[3];
                int k=0;
                int requiredSum=0;
                for(int x=i;x<i+3;x++)
                {
                    int sum=0;
                    for(int y=j;y<j+3;y++)
                    {
                        if(grid[x][y]>9)
                        {
                            flag=1;
                            break;
                        }
                        if(grid[x][y]==0 ||  ch[grid[x][y]]==1)
                        {
                            flag=1;
                            break;
                        }
                        ch[grid[x][y]]++;
                        sum=sum+grid[x][y];
                        if(y==j)
                        {
                            colSum[0]=colSum[0]+grid[x][y];
                        }
                        else if(y==j+1)
                        {
                            colSum[1]=colSum[1]+grid[x][y];
                        }
                        else
                        {
                            colSum[2]=colSum[2]+grid[x][y];
                        }
                    }
                    if(flag==1)
                    {
                        break;
                    }
                    requiredSum=sum;
                    rowSum[k]=sum;
                    k++;
                }
                if(flag==0)
                {
            if(rowSum[0]==requiredSum && rowSum[1]==requiredSum && rowSum[2]==requiredSum && colSum[0]==requiredSum && colSum[1]==requiredSum && colSum[2]==requiredSum)
            {
                int diagonal1Sum=grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
                int diagonal2Sum=grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j];
                if(diagonal1Sum==requiredSum && diagonal2Sum==requiredSum)
                {
                    count++;
                }
            }
            }
        }
        }
        
        return count;
    }
}
