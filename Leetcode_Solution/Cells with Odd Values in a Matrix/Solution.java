class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int arr[][]=new int[n][m];
        for(int i=0;i<indices.length;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[indices[i][0]][j]+=1;
            }
            for(int j=0;j<n;j++)
            {
                arr[j][indices[i][1]]+=1;
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]%2!=0)
                {
                    count++;
                }
            }
        }
        
        return count;
        
    }
}
