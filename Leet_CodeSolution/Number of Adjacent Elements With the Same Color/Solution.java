class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int arr[]=new int[n];
        int ans=0;
        int result[]=new int[queries.length];
         if(n==1)
        {
            return result;
        }
        for(int i=0;i<queries.length;i++)
        {
             int index=queries[i][0];
             int color=queries[i][1];
             if(index==0)
             {
                 if((arr[index]==arr[index+1]) && arr[index]!=0)
                 {
                     ans--;
                 }
                 arr[index]=color;
                 if((arr[index]==arr[index+1]))
                 {
                     ans++;
                 }
             }
             else if(index==n-1)
             {
                 if((arr[index]==arr[index-1]) && arr[index]!=0)
                 {
                     ans--;
                 }
                 arr[index]=color;
                 if((arr[index]==arr[index-1]))
                 {
                     ans++;
                 }
             }
             else
             {
                 if((arr[index]==arr[index-1]) && arr[index]!=0)
                 {
                     ans--;
                 }
                 if((arr[index]==arr[index+1]) && arr[index]!=0)
                 {
                     ans--;
                 }
                 arr[index]=color;
                 if(arr[index]==arr[index-1])
                 {
                     ans++;
                 }
                 if(arr[index]==arr[index+1])
                 {
                     ans++;
                 }
             }
             result[i]=ans;
        }

        return result;
    }
}
