class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int max=0;
        for(int i=0;i<mat[0].length;i++)
        {
            int arr[]=new int[mat.length];
            for(int j=i;j<mat[0].length;j++)
            {
                for(int k=0;k<mat.length;k++)
                {
                    arr[k]+=mat[k][j];
                }
                int m=j-i+1;
                if(max<m && m<=arr.length)
                {
                    int sum=0;
                    for(int l=0;l<m;l++)
                    {
                        sum+=arr[l];
                    }
                        if(sum<=threshold)
                        {
                            max=m;
                        }
                    if(max<m)
                    {
                        int r=m;
                        for(int l=1;l<=arr.length-m;l++)
                        {
                            sum=sum-arr[l-1];
                            sum+=arr[r];
                            r++;
                            if(sum<=threshold)
                            {
                                max=m;
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return max;
    }
}
