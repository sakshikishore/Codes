class Solution {
    public int longestPalindromeSubseq(String s) {
        int arr[][]=new int[s.length()][s.length()];
        for(int i=1;i<=s.length();i++)
        {
           for(int j=0;j<=s.length()-i;j++)
           {
               String str=s.substring(j,j+i);
               if(str.length()==1)
               {
                   arr[j][j]=1;
               }
               else
               {
                   if(str.charAt(0)==str.charAt(str.length()-1))
                   {
                       arr[j][j+i-1]=2;
                       if(j+1<=j+i-2)
                       {
                           arr[j][j+i-1]+=arr[j+1][j+i-2];
                       }
                   }
                   else
                   {
                       arr[j][j+i-1]=Math.max(arr[j][j+i-2],arr[j+1][j+i-1]);
                   }
               }
           }
        }
        return arr[0][arr[0].length-1];
        
    }
}
