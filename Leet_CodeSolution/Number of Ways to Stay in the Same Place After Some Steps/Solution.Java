class Solution {
    public int numWays(int steps, int arrLen) {
        if(arrLen==1)
        {
           return 1;
        }
        int min=Math.min(steps,arrLen);
       long arr[][]=new long[steps+1][min+1];
        arr[1][0]=1l;
        arr[1][1]=1l;
        for(int i=2;i<=steps;i++)
        {
           // stay
           for(int j=0;j<arr[i].length;j++)
           {
             arr[i][j]=arr[i-1][j];
             arr[i][j]=arr[i][j]%(1000000007);
           }
           // right
           for(int j=0;j<arr[i].length-1;j++)
           {
                arr[i][j+1]+=arr[i-1][j];
                arr[i][j+1]=arr[i][j+1]%(1000000007);
           }
           //Left
           for(int j=1;j<arr[i].length-1;j++)
           {
            
                arr[i][j-1]+=arr[i-1][j];
                arr[i][j-1]=arr[i][j-1]%(1000000007);
           }
           if(i==steps)
           {
              return (int)arr[i][0];
           }
        }

        return 0;
    }
}
