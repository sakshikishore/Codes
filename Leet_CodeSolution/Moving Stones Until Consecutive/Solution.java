class Solution {
    public int[] numMovesStones(int a, int b, int c) {
       int arr[]=new int[3];
       arr[0]=a;
       arr[1]=b;
       arr[2]=c;
       Arrays.sort(arr);
       int max=(arr[1]-arr[0]-1)+(arr[2]-arr[1]-1);
       int min=0;
       if(arr[2]-arr[1]==1)
       {
          min=Math.min(arr[1]-arr[0]-1,1);
       }
       else
       {
           if(arr[1]-arr[0]==1)
           {
               min=1;
           }
           else
           {
               if(arr[2]-arr[1]==2 || arr[1]-arr[0]==2)
               {
                   min=1;
               }
               else
               {
                   min=2;
               }
           }
       }

       int result[]=new int[2];
       result[0]=min;
       result[1]=max;

       return result;
    }
}
