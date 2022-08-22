class Solution {
    public void solve(char[][] board) {
        HashSet<String> h=new HashSet<String>();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]=='O')
                {
                    String str=Integer.toString(i)+" "+Integer.toString(j);
                    if(!h.contains(str))
                    {
                        h.add(str);
                        ArrayList<String> l=new ArrayList<String>();
                        Queue<String> q=new LinkedList<String>();
                        q.add(str);
                        int flag=0;
                        while(q.size()>0)
                        {
                            String p=q.poll();
                            String s[]=p.split(" ");
                            l.add(p);
                             int x=Integer.parseInt(s[0]);
                             int y=Integer.parseInt(s[1]);
                        if(x==0 || x==board.length-1 || y==0 || y==board[i].length-1)
                                {
                                    flag=1;
                                }
                            if(x-1>=0)
                            {
                                if(board[x-1][y]=='O')
                                {
                                     str=Integer.toString(x-1)+" "+Integer.toString(y);
                                    if(!h.contains(str))
                                    {
                                        h.add(str);
                                        q.add(str);
                                    }
                                }
                            }
                             if(x+1<board.length)
                            {
                                if(board[x+1][y]=='O')
                                {
                                     str=Integer.toString(x+1)+" "+Integer.toString(y);
                                    if(!h.contains(str))
                                    {
                                        h.add(str);
                                        q.add(str);
                                    }
                                }
                            }
                            if(y-1>=0)
                            {
                                if(board[x][y-1]=='O')
                                {
                                     str=Integer.toString(x)+" "+Integer.toString(y-1);
                                    if(!h.contains(str))
                                    {
                                        h.add(str);
                                        q.add(str);
                                    }
                                }
                            }
                             if(y+1<board[i].length)
                            {
                                if(board[x][y+1]=='O')
                                {
                                     str=Integer.toString(x)+" "+Integer.toString(y+1);
                                    if(!h.contains(str))
                                    {
                                        h.add(str);
                                        q.add(str);
                                    }
                                }
                            }
                        }
                        if(flag==0)
                        {
                           for(int k=0;k<l.size();k++)
                           {
                               String st[]=l.get(k).split(" ");
                               int x=Integer.parseInt(st[0]);
                               int y=Integer.parseInt(st[1]);
                               board[x][y]='X';
                               
                           }
                        }
                    }
                }
            }
        }
        
    }
}
