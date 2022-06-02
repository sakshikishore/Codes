class Solution {
    public int uniquePaths(int m, int n) {
        int arr[][]=new int[m][n];
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(i==m-1)
                {
                    arr[i][j]=1;
                }
                else if(j==n-1)
                {
                    arr[i][j]=1;
                }
                else
                {
                    arr[i][j]=arr[i][j+1]+arr[i+1][j];
                }
            }
        }
        
        int ans=arr[0][0];
        return ans;
        
    }
}
