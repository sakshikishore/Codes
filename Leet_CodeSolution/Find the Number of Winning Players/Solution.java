class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int c[][]=new int[n][11];
        int count=0;
        for(int i=0;i<pick.length;i++)
        {
            c[pick[i][0]][pick[i][1]]++;
        }
        for(int i=0;i<c.length;i++)
        {
            for(int j=0;j<11;j++)
            {
                if(c[i][j]>i)
                {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
