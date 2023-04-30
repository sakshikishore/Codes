class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
      int rowSum[]=new int[mat.length];
      int colSum[]=new int[mat[0].length];
        HashMap<Integer,String> h=new HashMap<Integer,String>();
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                rowSum[i]+=mat[i][j];
                String str=Integer.toString(i)+" "+Integer.toString(j);
                h.put(mat[i][j],str);
            }
        }
        for(int i=0;i<mat[0].length;i++)
        {
            for(int j=0;j<mat.length;j++)
            {
                colSum[i]+=mat[j][i];
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            String s[]=h.get(arr[i]).split(" ");
            int x=Integer.parseInt(s[0]);
            int y=Integer.parseInt(s[1]);
            rowSum[x]=rowSum[x]-arr[i];
            if(rowSum[x]==0)
            {
                return i;
            }
            colSum[y]=colSum[y]-arr[i];
            if(colSum[y]==0)
            {
                return i;
            }
        }
        
        return 0;

    }
}
