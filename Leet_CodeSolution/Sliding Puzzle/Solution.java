class Solution {
    int result=Integer.MAX_VALUE;
    HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
    public void Solve(int[][] board, int i, int j,int count)
    {
        if(board[0][0]==1 && board[0][1]==2 && board[0][2]==3 && board[1][0]==4 && board[1][1]==5)
        {
            result=Math.min(result,count);
            return;
        }
       int x=board[1][2]+board[1][1]*10+board[1][0]*100+board[0][2]*1000+board[0][1]*10000+board[0][0]*100000;
       if(h.containsKey(x) && h.get(x)<count)
       {
          return;
       }
       h.put(x,count);
       if(i-1>=0)
       {
          int p=board[i-1][j];
          board[i][j]=p;
          board[i-1][j]=0;
          Solve(board,i-1,j,count+1);
          board[i][j]=0;
          board[i-1][j]=p;
       }
       if(i+1<2)
       {
          int p=board[i+1][j];
          board[i][j]=p;
          board[i+1][j]=0;
          Solve(board,i+1,j,count+1);
          board[i][j]=0;
          board[i+1][j]=p;
       }
       if(j-1>=0)
       {
        int p=board[i][j-1];
          board[i][j]=p;
          board[i][j-1]=0;
          Solve(board,i,j-1,count+1);
          board[i][j]=0;
          board[i][j-1]=p;
       }
       if(j+1<3)
       {
        int p=board[i][j+1];
          board[i][j]=p;
          board[i][j+1]=0;
          Solve(board,i,j+1,count+1);
          board[i][j]=0;
          board[i][j+1]=p;
       }



    }
    public int slidingPuzzle(int[][] board) {
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==0)
                {
                    Solve(board,i,j,0);
                }
            }
        }

        if( result==Integer.MAX_VALUE)
        {
            return -1;
        }

        return result;
    }
}
