class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean result=false;
        int flag=1;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]!=target[i][j])
                {
                    flag=0;
                    break;
                }
            }
            
            if(flag==0)
            {
                break;
            }
        }
        if(flag==1)
        {
            result=true;
        }
        else
        {
            int l=-1;
            flag=1;
            for(int i=mat.length-1;i>=0;i--)
            {
                l++;
                int k=0;
                for(int j=mat[i].length-1;j>=0;j--)
                {
                    if(mat[i][j]!=target[l][k])
                    {
                        flag=0;
                        break;
                    }
                    else
                    {
                        k++;
                    }
                }
                if(flag==0)
                {
                    break;
                }
            }
        }
        if(flag==1)
        {
            result=true;
        }
        else
        {
            flag=1;
            int l=mat.length;
            for(int i=0;i<mat[0].length;i++)
            {
                l--;
                int k=0;
                for(int j=0;j<mat.length;j++)
                {
                    if(target[j][i]!=mat[l][k])
                    {
                        flag=0;
                        break;
                    }
                    else
                    {
                        k++;
                    }
                }
                
                if(flag==0)
                {
                    break;
                }
            }
        }
         if(flag==1)
        {
            result=true;
        }
        else
        {
            flag=1;
            int l=-1;
            for(int i=0;i<mat[0].length;i++)
            {
                l++;
                int k=mat[i].length-1;;
                for(int j=0;j<mat.length;j++)
                {
                    if(target[j][i]!=mat[l][k])
                    {
                        flag=0;
                        break;
                    }
                    else
                    {
                        k--;
                    }
                }
                
                if(flag==0)
                {
                    break;
                }
            }
            
        }
        
        if(flag==1)
        {
            result=true;
        }
        
        return result;
    }
}
