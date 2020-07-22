class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean result=true;
        
        for(int i=0;i<9;i++)
        {
            ArrayList<Character> l=new ArrayList<Character>();
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.' && !l.contains(board[i][j]))
                {
                    l.add(board[i][j]);
                }
                else
                {
                    if(board[i][j]!='.')
                    {
                        result=false;
                        break;
                    }
                }
            }
             if(result==false)
             {
               break;
             }
        }
            if(result==true)
            {
               for(int i=0;i<9;i++)
                {
                   ArrayList<Character> l=new ArrayList<Character>();
                   for(int j=0;j<9;j++)
                   {
                        if(board[j][i]!='.' && !l.contains(board[j][i]))
                        {
                            l.add(board[j][i]);
                        }
                        else
                        {
                            if(board[j][i]!='.')
                            {
                                result=false;
                                break;
                            }
                        }
                  }
                   if(result==false)
                   {
                       break;
                   }
              }
            }
            
            if(result==true)
            {
                int s=0;
                int p=-3;
                for(int k=0;k<9;k++)
                {
                    ArrayList<Character> l=new ArrayList<Character>();
                    
                    if(k%3==0)
                    {
                        p=p+3;
                        s=0;
                    }
                        for(int i=0+p;i<3+p;i++)
                        {
                            for(int j=0+s;j<3+s;j++)
                            {
                                if(board[i][j]!='.' && !l.contains(board[i][j]))
                                {
                                    l.add(board[i][j]);
                                }
                                else
                                {
                                    if(board[i][j]!='.')
                                    {
                                        result=false;
                                        break;
                                    }
                                }
                            }
                            
                            if(result==false)
                            {
                                break;
                            }
                        }
                    
                        if(result==false)
                        {
                          break;
                        }

                        s=s+3;
                      
                    }
                    
                    
                }
            
        
        return result;
    
}
}
