class Solution {
    public int[] kWeakestRows(int[][] mat, int l) {
        int arr[]=new int [mat.length];
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]==1)
                {
                    arr[i]++;
                }
            }
        }
        int k[]=new int[mat.length];
        for(int i=0;i<mat.length;i++)
        {
            k[i]=i;
        }
        for(int i=0;i<mat.length;i++)
        {
            for(int j=i+1;j<mat.length;j++)
            {
                if(arr[i]>arr[j])
                {
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;

                    int t=k[i];
                    k[i]=k[j];
                    k[j]=t;
                }
                if(arr[i]==arr[j] && k[i]>k[j])
                {
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;

                    int t=k[i];
                    k[i]=k[j];
                    k[j]=t;
                }
            }
        }
        int result[]=new int[l];
        for(int i=0;i<l;i++)
        {
            result[i]=k[i];
        }
        
        return result;
        
    }
}
