class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int arr[][]=new int[rowSum.length][colSum.length];
        int i=0,j=0;
        while(i<rowSum.length && j<colSum.length)
        {
            if(rowSum[i]<colSum[j])
            {
                arr[i][j]=rowSum[i];
                colSum[j]=colSum[j]-rowSum[i];
                i++;
            }
            else
            {
                arr[i][j]=colSum[j];
                rowSum[i]=rowSum[i]-colSum[j];
                j++;
            }
        }
        
        return arr;
    }
}
