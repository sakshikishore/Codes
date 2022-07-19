class Solution {
    public int numSubmat(int[][] mat) {
        int count=0;
        for(int i=0;i<mat[0].length;i++)
        {
             int arr[]=new int[mat.length];
            for(int j=i;j<mat[0].length;j++)
            {
                for(int p=0;p<mat.length;p++)
                {
                    arr[p]+=mat[p][j];
                }
                for(int l=0;l<arr.length;l++)
                {
                    for(int m=l;m<arr.length;m++)
                    {
                        
                        if(arr[m]==((j-i)+1))
                        {
                            count++;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
            }
        }
        
        return count;
    }
}
