class Solution {
    public boolean Solve(char[][] board, int i, int j, String word, int index)
    {
       if(index==word.length())
       {
             return true;         
       }    
       if(i<0 || j<0|| i==board.length || j==board[0].length || board[i][j]!=word.charAt(index))
       {
           return false;
       }
       char c=board[i][j];
       board[i][j]='1';
       boolean option1=Solve(board,i+1,j,word,index+1);
       boolean option2=Solve(board,i-1,j,word,index+1);
       boolean option3=Solve(board,i,j+1,word,index+1);
       boolean option4=Solve(board,i,j-1,word,index+1);
       board[i][j]=c;

       return option1 || option2 || option3 || option4;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(Solve(board,i,j,word,0))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
