class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int mat[][]=new int[grid.size()][grid.get(0).size()];
        int max=Integer.MIN_VALUE;
        for(int i=grid.size()-1;i>=0;i--)
        { 
            
            for(int j=grid.get(0).size()-1;j>=0;j--)
            {
                if(i==grid.size()-1)
                {
                    if(j==grid.get(0).size()-1)
                    {
                        mat[i][j]=grid.get(i).get(j);
                    }
                    else
                    {
                        int p=mat[i][j+1]-grid.get(i).get(j);
                        if(p>max)
                        {
                            max=p;
                        }
                        if(p>0)
                        {
                            mat[i][j]=grid.get(i).get(j)+p;
                        }
                        else
                        {
                            mat[i][j]=grid.get(i).get(j);
                        }
                    }
                }
                else if(j==grid.get(0).size()-1)
                {
                    int p=mat[i+1][j]-grid.get(i).get(j);
                    if(p>max)
                        {
                            max=p;
                        }
                        if(p>0)
                        {
                            mat[i][j]=grid.get(i).get(j)+p;
                        }
                        else
                        {
                            mat[i][j]=grid.get(i).get(j);
                        }
                }
                else
                {
                    int p=mat[i+1][j]-grid.get(i).get(j);
                    int q=mat[i][j+1]-grid.get(i).get(j);
                    if(p>q)
                    {
                         if(p>max)
                          {
                            max=p;
                          }
                          
                            if(p>0)
                            {
                                mat[i][j]=grid.get(i).get(j)+p;
                            }
                            else
                            {
                                mat[i][j]=grid.get(i).get(j);
                            }

                    }
                    else
                    {
                        if(q>max)
                        {
                            max=q;
                        }
                         if(q>0)
                            {
                                mat[i][j]=grid.get(i).get(j)+q;
                            }
                            else
                            {
                                mat[i][j]=grid.get(i).get(j);
                            }
                    }
                }
            }
        }

        return max;
    }
}
