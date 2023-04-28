class Solution {
    List<List<String>> list=new ArrayList();
    HashSet<String> h=new HashSet<String>();
public void Solve(int col, char board[][])
{
   if(col==board[0].length)
   {
       ArrayList<String> l=new ArrayList<String>();
       String str="";
       for(int i=0;i<board.length;i++)
       {
           String s="";
           for(int j=0;j<board.length;j++)
           {
                str+=board[i][j];
                s+=board[i][j];
           }
           l.add(s);
           if(i<board.length-1)
           {
               str=str+",";
           }
       }
       if(!h.contains(str))
       {
           h.add(str);
           list.add(l);
       }
       return;
   }
   for(int i=0;i<board.length;i++)
   {
       if(isSafePosition(board,i,col))
       {
        board[i][col]='Q';
        Solve(col+1,board);
        board[i][col]='.';
       }
   }
}

public boolean isSafePosition(char board[][], int row, int col)
{
   // Check Row
   for(int i=0;i<board.length;i++)
   {
       if(board[i][col]=='Q')
       {
           return false;
       }
   }

   // Check Column
   for(int i=0;i<board[0].length;i++)
   {
       if(board[row][i]=='Q')
       {
           return false;
       }
   }
   // Upperleft
    int j=row-1, k=col-1;
    while(j>=0 && k>=0)
    {
        if(board[j][k]=='Q')
        {
            return false;
        }
        j--;
        k--;
    }
    // Lower Right
    j=row+1;
    k=col+1;
    while(j<board.length && k<board.length)
    {
        if(board[j][k]=='Q')
        {
            return false;
        }
        j++;
        k++;
    }

    // Upper Right
    j=row-1;
    k=col+1;
    while(j>=0 && k<board.length)
    {
        if(board[j][k]=='Q')
        {
            return false;
        }
        j--;
        k++;
    }

    //Lower Left

    j=row+1;
    k=col-1;
    while(k>=0 && j<board.length)
    {
        if(board[j][k]=='Q')
        {
            return false;
        }
        j++;
        k--;
    }

    return true;


}
    public List<List<String>> solveNQueens(int n) {
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        Solve(0,board);

        return list;
    }
}
