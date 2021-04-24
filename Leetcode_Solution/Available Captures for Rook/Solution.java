class Solution {
    public int numRookCaptures(char[][] board) {
        int p=0,q=0;
        int count=0;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]=='R')
                {
                    p=i;
                    q=j;
                    break;
                }
            }
        }
        System.out.println(p+" "+q);
        for(int i=q-1;i>=0;i--)
        {
            if(board[p][i]=='p')
            {
                count++;
                break;
            }
            else if(board[p][i]=='B')
            {
                break;
            }
        }
        
         for(int i=q+1;i<board[p].length;i++)
        {
            if(board[p][i]=='p')
            {
                count++;
                break;
            }
            else if(board[p][i]=='B')
            {
                break;
            }
        }
        for(int i=p+1;i<board.length;i++)
        {
            if(board[i][q]=='p')
            {
                count++;
                break;
            }
             else if(board[i][q]=='B')
            {
                break;
            }
        }
        
        for(int i=p-1;i>=0;i--)
        {
            if(board[i][q]=='p')
            {
                count++;
                break;
            }
             else if(board[i][q]=='B')
            {
                break;
            }
        }
        
        return count;
        
    }
}
