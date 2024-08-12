class Solution {
    public void Solve(char[][] board, int x, int y, char[][] result)
    {
        if(x==board.length-1 && y==board[0].length)
        {
            for(int j=0;j<board.length;j++)
            {
                for(int k=0;k<board[0].length;k++)
                {
                    result[j][k]=board[j][k];
;                }
            }
            return;
        }
        if(y==board[0].length)
        {
            y=0;
            x++;
        }
        if(board[x][y]=='.')
        {
            for(int i=1;i<=9;i++)
            {
                if(isValid(board,x,y,(char)(48+i)))
                {
                    board[x][y]=(char)(48+i);
                    Solve(board,x,y+1,result);
                }
                board[x][y]='.';
            }
        }
        else
        {
            Solve(board,x,y+1,result);
        }
    }
    public Boolean isValid(char[][] board,int x,int y,char val)
    {
        for(int j=0;j<9;j++)
        {
            if(board[x][j]==val)
            {
                return false;
            }
        }
        for(int i=0;i<9;i++)
        {
            if(board[i][y]==val)
            {
                return false;
            }
        }
        if(x<=2)
        {
            for(int i=0;i<3;i++)
            {
                if(y<=2)
                {
                    for(int j=0;j<3;j++)
                    {
                        if(board[i][j]==val)
                        {
                            return false;
                        }
                    }
                }
                else if(y<=5)
                {
                    for(int j=3;j<6;j++)
                    {
                         if(board[i][j]==val)
                        {
                            return false;
                        }
                    }
                }
                else
                {
                    for(int j=6;j<9;j++)
                    {
                         if(board[i][j]==val)
                        {
                            return false;
                        }
                    }
                }
            }
        }
        else if(x<=5)
        {
             for(int i=3;i<6;i++)
            {
                if(y<=2)
                {
                    for(int j=0;j<3;j++)
                    {
                        if(board[i][j]==val)
                        {
                            return false;
                        }
                    }
                }
                else if(y<=5)
                {
                    for(int j=3;j<6;j++)
                    {
                         if(board[i][j]==val)
                        {
                            return false;
                        }
                    }
                }
                else
                {
                    for(int j=6;j<9;j++)
                    {
                         if(board[i][j]==val)
                        {
                            return false;
                        }
                    }
                }
            }
        }
        else
        {
            for(int i=6;i<9;i++)
            {
                if(y<=2)
                {
                    for(int j=0;j<3;j++)
                    {
                        if(board[i][j]==val)
                        {
                            return false;
                        }
                    }
                }
                else if(y<=5)
                {
                    for(int j=3;j<6;j++)
                    {
                         if(board[i][j]==val)
                        {
                            return false;
                        }
                    }
                }
                else
                {
                    for(int j=6;j<9;j++)
                    {
                         if(board[i][j]==val)
                        {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
    public void solveSudoku(char[][] board) {
        char[][] result=new char[board.length][board[0].length];
        Solve(board,0,0,result);
         for(int j=0;j<board.length;j++)
            {
                for(int k=0;k<board[0].length;k++)
                {
                    board[j][k]=result[j][k]
;                }
            }

    }
}
