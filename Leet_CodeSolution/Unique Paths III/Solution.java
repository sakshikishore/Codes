class Solution {
    public int uniquePathsIII(int[][] grid) {
       Queue<String> q=new LinkedList<String>();
       int count=0,result=0;
       for(int i=0;i<grid.length;i++)
       {
           for(int j=0;j<grid[0].length;j++)
           {
               if(grid[i][j]==1)
               {
                String str=Integer.toString(i)+"|"+Integer.toString(j);
                q.add(str);
               }
               else if(grid[i][j]==-1)
               {
                   count++;
               }

           }
       }
       int total=grid[0].length*grid.length;
       while(q.size()>0)
       {
           String s=q.poll();
           String str[]=s.split(" ");
           String p[]=str[str.length-1].split("[|]");
           int x=Integer.parseInt(p[0]);
           int y=Integer.parseInt(p[1]);
           if(x+1<grid.length && grid[x+1][y]!=-1)
           {
                  String st=Integer.toString(x+1)+"|"+Integer.toString(y);
                  int flag=0;
                  for(int j=0;j<str.length;j++)
                  {
                      if(str[j].equals(st))
                      {
                          flag=1;
                          break;
                      }
                  }
                  if(flag==0)
                  {
                     if(grid[x+1][y]==2)
                     {
                         if(str.length+1==total-count)
                         {
                             result++;
                         }
                     }
                     else
                     {
                        q.add(s+" "+st);
                     }
                  }
           }
           if(x-1>=0 && grid[x-1][y]!=-1)
           {
                  String st=Integer.toString(x-1)+"|"+Integer.toString(y);
                  int flag=0;
                  for(int j=0;j<str.length;j++)
                  {
                      if(str[j].equals(st))
                      {
                          flag=1;
                          break;
                      }
                  }
                  if(flag==0)
                  {
                     if(grid[x-1][y]==2)
                     {
                         if(str.length+1==total-count)
                         {
                             result++;
                         }
                     }
                     else
                     {
                        q.add(s+" "+st);
                     }
                  }
           }

           if(y+1<grid[0].length && grid[x][y+1]!=-1)
           {
                  String st=Integer.toString(x)+"|"+Integer.toString(y+1);
                  int flag=0;
                  for(int j=0;j<str.length;j++)
                  {
                      if(str[j].equals(st))
                      {
                          flag=1;
                          break;
                      }
                  }
                  if(flag==0)
                  {
                     if(grid[x][y+1]==2)
                     {
                         if(str.length+1==total-count)
                         {
                             result++;
                         }
                     }
                     else
                     {
                        q.add(s+" "+st);
                     }
                  }
           }
           if(y-1>=0 && grid[x][y-1]!=-1)
           {
                  String st=Integer.toString(x)+"|"+Integer.toString(y-1);
                  int flag=0;
                  for(int j=0;j<str.length;j++)
                  {
                      if(str[j].equals(st))
                      {
                          flag=1;
                          break;
                      }
                  }
                  if(flag==0)
                  {
                     if(grid[x][y-1]==2)
                     {
                         if(str.length+1==total-count)
                         {
                             result++;
                         }
                     }
                     else
                     {
                        q.add(s+" "+st);
                     }
                  }
           }

       }

       return result;


    }
}
