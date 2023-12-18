class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]]=='M')
        {
            board[click[0]][click[1]]='X';
            return board;
        }
        int flag=0;
       for(int i=0;i<board.length;i++)
       {
           for(int j=0;j<board[0].length;j++)
           {
               if(board[i][j]=='M')
               {
                   flag=1;
                   break;
               }
           }
       }
       if(flag==0)
       {
           for(int i=0;i<board.length;i++)
            {
                for(int j=0;j<board[0].length;j++)
                {
                   board[i][j]='B';
                }
            }

            return board;
       }

       Queue<String> q=new LinkedList<String>();
        q.add(Integer.toString(click[0])+" "+Integer.toString(click[1]));
        while(q.size()>0)
        {
            String str[]=q.poll().split(" ");
            int i=Integer.parseInt(str[0]);
            int j=Integer.parseInt(str[1]);
            int count=0;
            if(i-1>=0)
            {
                if(board[i-1][j]=='M')
                {
                    count++;
                }
                if(j-1>=0)
                {
                     if(board[i-1][j-1]=='M')
                    {
                        count++;
                    }
                }
                if(j+1<board[0].length)
                {
                    if(board[i-1][j+1]=='M')
                    {
                        count++;
                    }
                }
            }
            if(i+1<board.length)
            {
                if(board[i+1][j]=='M')
                {
                    count++;
                }
                if(j-1>=0)
                {
                     if(board[i+1][j-1]=='M')
                    {
                        count++;
                    }
                }
                if(j+1<board[0].length)
                {
                    if(board[i+1][j+1]=='M')
                    {
                        count++;
                    }
                }

            }
            if(j-1>=0)
            {
                if(board[i][j-1]=='M')
                {
                    count++;
                }
            }
            if(j+1<board[0].length)
            {
                if(board[i][j+1]=='M')
                {
                    count++;
                }
            }

            if(count>0)
            {
                board[i][j]=(char)('0'+count);
            }
            else
            {
                board[i][j]='B';
                if(i-1>=0)
                {
                    if(board[i-1][j]=='E')
                    {
                        q.add(Integer.toString(i-1)+" "+Integer.toString(j));
                    }
                    if(j-1>=0)
                    {
                        if(board[i-1][j-1]=='E')
                        {
                        q.add(Integer.toString(i-1)+" "+Integer.toString(j-1));
                        }
                    }
                    if(j+1<board[0].length)
                    {
                        if(board[i-1][j+1]=='E')
                        {
                        q.add(Integer.toString(i-1)+" "+Integer.toString(j+1));
                        }
                    }
                }
                if(i+1<board.length)
                {
                    if(board[i+1][j]=='E')
                    {
                      q.add(Integer.toString(i+1)+" "+Integer.toString(j));
                    }
                    if(j-1>=0)
                    {
                        if(board[i+1][j-1]=='E')
                        {
                        q.add(Integer.toString(i+1)+" "+Integer.toString(j-1));
                        }
                    }
                    if(j+1<board[0].length)
                    {
                        if(board[i+1][j+1]=='E')
                        {
                        q.add(Integer.toString(i+1)+" "+Integer.toString(j+1));
                        }
                    }
                }
                if(j-1>=0)
                {
                    if(board[i][j-1]=='E')
                    {
                    q.add(Integer.toString(i)+" "+Integer.toString(j-1));
                    }
                }
                if(j+1<board[0].length)
                {
                    if(board[i][j+1]=='E')
                    {
                     q.add(Integer.toString(i)+" "+Integer.toString(j+1));
                    }
                }
            }
            
        }

        return board;
    }
}
