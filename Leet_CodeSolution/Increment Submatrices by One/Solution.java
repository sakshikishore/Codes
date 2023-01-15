class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int arr[][]=new int[n][n];
        for(int i=0;i<queries.length;i++)
        {
            int r1=queries[i][0];
            int c1=queries[i][1];
            int r2=queries[i][2];
            int c2=queries[i][3];
            for(int k=r1;k<=r2;k++)
            {
                for(int j=c1;j<=c2;j++)
                {
                    arr[k][j]+=1;
                }
            }
            
        }
        
        return arr;
    }
}
