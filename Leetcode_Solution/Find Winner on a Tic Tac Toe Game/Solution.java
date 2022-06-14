class Solution {
    public String tictactoe(int[][] moves) {
        int arr[][]=new int[3][3];
        String ans="Draw";
        int count=0;
        for(int i=0;i<moves.length;i++)
        {
            if(count%2==0)
            {
            arr[moves[i][0]][moves[i][1]]=1;
            }
            else
            {
             arr[moves[i][0]][moves[i][1]]=2;
            }
            count++;
        }
        for(int i=0;i<3;i++)
        {
            int a=0,b=0;
            for(int j=0;j<3;j++)
            {
                if(arr[i][j]==1)
                {
                     a++;
                }
               else if(arr[i][j]==2)
                {
                    b++;
                }
                else
                {
                    ans="Pending";
                }
                
            }
            if(a==3)
            {
                ans="A";
                break;
            }
           else if(b==3)
            {
                ans="B";
                break;
            }
             
        }
        if(ans.equals("Draw") || ans.equals("Pending"))
        {
            for(int i=0;i<3;i++)
            {
                int a=0,b=0;
                for(int j=0;j<3;j++)
                {
                    if(arr[j][i]==1)
                    {
                         a++;
                    }
                   else if(arr[j][i]==2)
                    {
                        b++;
                    }
                }
                if(a==3)
                {
                    ans="A";
                    break;
                }
               else if(b==3)
                {
                    ans="B";
                   break;
                }
              
            }
        }
         if(ans.equals("Draw") || ans.equals("Pending"))
         {
             if(arr[0][0]==1 && arr[1][1]==1 && arr[2][2]==1)
             {
                 ans="A";
             }
             else if(arr[0][0]==2 && arr[1][1]==2 && arr[2][2]==2)
             {
                 ans="B";
             }
             else if(arr[0][2]==1 && arr[1][1]==1 && arr[2][0]==1)
             {
                 ans="A";
             }
             else if(arr[0][2]==2 && arr[1][1]==2 && arr[2][0]==2)
             {
                 ans="B";
             }
                 
         }
        
        return ans;
        
    }
}
