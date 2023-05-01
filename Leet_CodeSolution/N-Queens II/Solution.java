class Solution {
    HashSet<String> h=new HashSet<String>();
    public void Solve(int col, char board[][])
    {
        if(col==board.length)
        {
            String result="";
            for(int i=0;i<board.length;i++)
            {
                for(int j=0;j<board[0].length;j++)
                {
                     result=result+board[i][j];
                }
                result=result+" ";
            }

            if(!h.contains(result))
            {
                h.add(result);
            }
        }
        for(int i=0;i<board.length;i++)
        {
            if(isSafePosition(board, i, col))
            {
              board[i][col]='Q';
              Solve(col+1,board);
              board[i][col]='.';
            }


        }
    }
    public boolean isSafePosition(char board[][], int row, int col)
    {
        // Row wise check
        for(int i=0;i<board[0].length;i++)
        {
            if(board[row][i]=='Q')
            {
                return false;
            }
        }

        // Column wise Check
        for(int i=0;i<board.length;i++)
        {
            if(board[i][col]=='Q')
            {
                return false;
            }
        }

        // Upper Left
        int r=row-1,c=col-1;
        while(r>=0 && c>=0)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
            c--;
            r--;
        }

        // Upper Right

        r=row-1;
        c=col+1;
        while(r>=0 && c<board[0].length)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
            c++;
            r--;
        }

        // Lower Left
        r=row+1;
        c=col-1;
        while(r<board.length && c>=0)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
            c--;
            r++;
        }

        // Lower Right
        r=row+1;
        c=col+1;
        while(r<board.length && c<board[0].length)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
            c++;
            r++;
        }

        return true;


    }
    public int totalNQueens(int n) {
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        Solve(0, board);

        return h.size();
    }
}
