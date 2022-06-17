class Solution {
    public void gameOfLife(int[][] board) {
        int arr[][]=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(j==0)
                {
                    if(i==0)
                    {
                        if(board[i][j]==0)
                        {
                            if(j+1<arr[i].length && i+1<arr.length)
                            {
                                if(board[i][j+1]==1 && board[i+1][j+1]==1 && board[i+1][j]==1)
                                {
                                    arr[i][j]=1;
                                }
                            }
                        }
                        else
                        {
                            int count=0;
                            if(j+1<arr[i].length && i+1<arr.length)
                            {
                                if(board[i][j+1]==1)
                                {
                                    count++;
                                }
                                if(board[i+1][j+1]==1)
                                {
                                    count++;
                                }
                                if(board[i+1][j]==1)
                                {
                                    count++;
                                }
                                if(count==2 || count==3)    
                                {
                                    arr[i][j]=1;
                                }
                            }
                        }
                    }
                    else if(i==board.length-1)
                    {
                        if(j+1<arr[0].length)
                        {
                            if(board[i][j]==0)
                            {
                                if(board[i-1][j]==1 && board[i-1][j+1]==1 && board[i][j+1]==1)
                                {
                                    arr[i][j]=1;
                                }
                            }
                            else
                            {
                                int count=0;
                                if(board[i-1][j]==1)
                                {
                                    count++;
                                }
                                 if(board[i-1][j+1]==1)
                                 {
                                     count++;
                                 }
                                 if(board[i][j+1]==1)
                                 {
                                     count++;
                                 }
                                if(count==2 || count==3)
                                {
                                    arr[i][j]=1;
                                }
                                
                            }
                        }
                    }
                    else
                    {
                        int a=0;
                        a=board[i+1][j]+board[i-1][j];
                        if(j+1<arr[i].length)
                        {
                            a=a+board[i+1][j+1]+board[i-1][j+1]+board[i][j+1];
                        }
                        if(board[i][j]==0)
                        {
                            if(a==3)
                            {
                                arr[i][j]=1;
                            }
                        }
                        else
                        {
                           if(a==2 || a==3)
                           {
                               arr[i][j]=1;
                           }
                        }
                        
                    }
                        
                }
                else if(j==arr[i].length-1)
                {
                    if(i==0)
                    {
                        if(board[i][j]==0)
                        {
                            if(i+1<arr.length)
                            {
                                if(board[i][j-1]==1 && board[i+1][j]==1 && board[i+1][j-1]==1)
                                {
                                    arr[i][j]=1;
                                }
                            }
                        }
                        else
                        {
                            int a=0;
                            if(i+1<arr.length)
                            {
                             a=board[i][j-1]+ board[i+1][j]+ board[i+1][j-1];
                            }
                            if(a==2 || a==3)
                            {
                                arr[i][j]=1;
                            }
                        }
                    }
                    else if(i==arr.length-1)
                    {
                        if(j-1>=0)
                        {
                             int a=0;
                             a=board[i-1][j]+board[i][j-1]+ board[i-1][j-1];
                             if(board[i][j]==0)
                             {
                                 if(a==3)
                                 {
                                     arr[i][j]=1;
                                 }

                            }
                            else
                            {
                                if(a==2 || a==3)
                                {
                                    arr[i][j]=1;
                                }
                            }
                        }
                    }
                    else
                    {
                        int a=0;
                        a=board[i+1][j]+board[i-1][j];
                        if(j-1>=0)
                        {
                            a=a+board[i][j-1]+board[i+1][j-1]+board[i-1][j-1];
                        }
                        if(board[i][j]==0)
                        {
                            if(a==3)
                            {
                                arr[i][j]=1;
                            }
                            
                        }
                        else
                        {
                            if(a==2 || a==3)
                            {
                                arr[i][j]=1;
                            }
                        }
                    }
                }
                else if(i==0)
                {
                    int a=0;
                    a=board[i][j-1]+board[i][j+1];
                    if(i+1<arr.length)
                    {
                        a=a+board[i+1][j]+board[i+1][j-1]+board[i+1][j+1];
                    }
                    
                    if(board[i][j]==0)
                    {
                        if(a==3)
                        {
                            arr[i][j]=1;
                        }
                    }
                    else
                    {
                        if(a==2 || a==3)
                        {
                            arr[i][j]=1;
                        }
                    }
                }
                else if(i==arr.length-1)
                {
                    int a=0;
                    a=board[i][j-1]+board[i][j+1]+board[i-1][j]+board[i-1][j-1]+board[i-1][j+1];
                    if(board[i][j]==0)
                    {
                        if(a==3)
                        {
                            arr[i][j]=1;
                        }
                    }
                    else
                    {
                        if(a==2 || a==3)
                        {
                            arr[i][j]=1;
                        }
                    }
                }
                else
                {
                    int a=0;
                    a=board[i][j-1]+board[i][j+1]+board[i+1][j]+board[i+1][j-1]+board[i+1][j+1]+board[i-1][j]+board[i-1][j-1]+board[i-1][j+1];
                    if(board[i][j]==0)
                    {
                        if(a==3)
                        {
                            arr[i][j]=1;
                        }
                    }
                    else
                    {
                        if(a==2 || a==3)
                        {
                            arr[i][j]=1;
                        }
                    }
                    
                }
            }
        }
        
       for(int i=0;i<arr.length;i++)
       {
           for(int j=0;j<arr[i].length;j++)
           {
               board[i][j]=arr[i][j];
           }
       }
        
    }
}
