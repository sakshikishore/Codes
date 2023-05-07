class Solution {
    public boolean validTicTacToe(String[] board) {
        int x=0,o=0;
        boolean XWinner=false,OWinner=false;
        for(int i=0;i<3;i++)
        {
            if(board[i].equals("XXX"))
            {
               XWinner=true;
            }
            else if(board[i].equals("OOO"))
            {
               OWinner=true;
            }
            for(int j=0;j<3;j++)
            {
                if(board[i].charAt(j)=='X')
                {
                    x++;
                }
                else if(board[i].charAt(j)=='O')
                {
                      o++;
                }
            }
        }
        if(o>x)
        {
            return false;
        }
        else if(x-o>1)
        {
            return false;
        }
        if(XWinner)
        {
            if(x-o==1 && !OWinner)
            {
                return true;
            }
            else 
            {
                return false;
            }
        }
        else if(OWinner)
        {
            if(x-o==0)
            {
                return true;
            }
            else 
            {
                return false;
            }
        }
        // Vertical check
        for(int i=0;i<3;i++)
        {
            String str="";
            for(int j=0;j<3;j++)
            {
                str=str+board[j].charAt(i);
            }
             if(str.equals("XXX"))
            {
               XWinner=true;
            }
            else if(str.equals("OOO"))
            {
               OWinner=true;
            }
        }
        // Diagonals Check
           StringBuffer s1=new StringBuffer("");
           s1.append(board[0].charAt(0)).append(board[1].charAt(1)).append(board[2].charAt(2));
           String str=new String(s1);
           if(str.equals("XXX"))
            {
               XWinner=true;
            }
            else if(str.equals("OOO"))
            {
               OWinner=true;
            }
            s1=new StringBuffer("");
            s1.append(board[0].charAt(2)).append(board[1].charAt(1)).append(board[2].charAt(0));
             str=new String(s1);
           if(str.equals("XXX"))
            {
               XWinner=true;
            }
            else if(str.equals("OOO"))
            {
               OWinner=true;
            }

             System.out.println(XWinner+" "+OWinner);
        
        if(XWinner)
        {
            if(x-o==1 && !OWinner)
            {
                return true;
            }
            else 
            {
                return false;
            }
        }
       else if(OWinner)
        {
            if(x-o==0)
            {
                return true;
            }
            else 
            {
                return false;
            }
        }
        return true;

    }
}
