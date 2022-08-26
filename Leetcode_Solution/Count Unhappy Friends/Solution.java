class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int count=0;
        for(int i=0;i<pairs.length;i++)
        {
            h.put(pairs[i][0],pairs[i][1]);
            h.put(pairs[i][1],pairs[i][0]);
            
        }
        for(int i=0;i<pairs.length;i++)
        {
            int x=pairs[i][0];
            int y=pairs[i][1];
            for(int j=0;j<preferences[x].length;j++)
            {
                if(preferences[x][j]==y)
                {
                    break;
                }
                else
                {
                    int flag=0;
                    int u=preferences[x][j];
                    int v=h.get(u);
                    for(int k=0;k<preferences[u].length;k++)
                    {
                        if(preferences[u][k]==v)
                        {
                            break;
                        }
                        else if(preferences[u][k]==x)
                        {
                            flag=1;
                            count++;
                            break;
                        }
                    }
                    if(flag==1)
                    {
                        break;
                    }
                }
            }
            /*****************************************************/
             x=pairs[i][1];
             y=pairs[i][0];
            for(int j=0;j<preferences[x].length;j++)
            {
                if(preferences[x][j]==y)
                {
                    break;
                }
                else
                {
                    int flag=0;
                    int u=preferences[x][j];
                    int v=h.get(u);
                    for(int k=0;k<preferences[u].length;k++)
                    {
                        if(preferences[u][k]==v)
                        {
                            break;
                        }
                        else if(preferences[u][k]==x)
                        {
                            flag=1;
                            count++;
                            break;
                        }
                    }
                    if(flag==1)
                    {
                        break;
                    }
                }
            }
        }
        
        return count;
    }
}
