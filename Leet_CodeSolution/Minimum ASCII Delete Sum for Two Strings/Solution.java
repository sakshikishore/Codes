class Solution {
    public int minimumDeleteSum(String s1, String s2) {
       int arr[][]=new int[s1.length()+1][s2.length()+1];
       int score[][]=new int[s1.length()+1][s2.length()+1];
       for(int i=0;i<s1.length();i++)
       {
           for(int j=0;j<s2.length();j++)
           {
               if(s1.charAt(i)==s2.charAt(j))
               {
                   arr[i+1][j+1]=1+arr[i][j];
                   score[i+1][j+1]=score[i][j]+(97+s1.charAt(i)-'a');
               }
               else
               {
                   if(arr[i][j+1]==arr[i+1][j])
                   {
                          arr[i+1][j+1]=arr[i][j+1];
                          score[i+1][j+1]=Math.max(score[i][j+1],score[i+1][j]);
                          
                   }
                   else
                   {
                    arr[i+1][j+1]=Math.max(arr[i][j+1],arr[i+1][j]);
                    if(arr[i+1][j+1]==arr[i][j+1])
                    {
                        score[i+1][j+1]=score[i][j+1];
                    }
                    else
                    {
                            score[i+1][j+1]=score[i+1][j];
                    }
                   }
               }
           }
       }
       int p=score[arr.length-1][arr[0].length-1];
       int score1=0,score2=0;
       for(int i=0;i<s1.length();i++)
       {
          score1+=(97+s1.charAt(i)-'a');
       }
       for(int i=0;i<s2.length();i++)
       {
          score2+=(97+s2.charAt(i)-'a');
       }

       return (score1-p)+(score2-p);
    }
}
