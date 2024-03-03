class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n=grid.length;
        int center=n/2;
        int count=0,res=0;
       //Case1 Y=2, X=0 || Y=2 X=1
        int visited[][]=new int[grid.length][grid[0].length];
        int i=0,j=0;
        while(i<=center && j<=center)
        {
            if(grid[i][i]==2)
            {
                count++;
                
            }
            visited[i][j]=1;
            i++;
            j++;
        }
        j=grid[0].length-1;
        i=0;
        while(j>center && i<center)
        {
            if(grid[i][j]==2)
            {
                count++;
               
            }
            visited[i][j]=1;
            i++;
            j--;
        }
        j=center;
        i=center+1;
        while(i<grid.length)
        {
            if(grid[i][j]==2)
            {
                
                count++;
            }
            visited[i][j]=1;
            i++;
        }
        int a=0,b=0; 
        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid.length;j++)
            {
                if(visited[i][j]==0)
                {
                    if(grid[i][j]==1)
                    {
                        a++;
                    }
                    else if(grid[i][j]==0)
                    {
                        b++;
                    }
                }
            }
        }
        
        int res1=count+a;
        int res2=count+b;
            
            res=n*n-Math.max(res1,res2);

               //CASE2 Y=1, X=0 || Y=1 X=2
        count=0;
        visited=new int[grid.length][grid[0].length];
        i=0;
        j=0;
        while(i<=center && j<=center)
        {
            if(grid[i][i]==1)
            {
                count++;
                
            }
            visited[i][j]=1;
            i++;
            j++;
        }
        j=grid[0].length-1;
        i=0;
        while(j>center && i<center)
        {
            if(grid[i][j]==1)
            {
                count++;
               
            }
            visited[i][j]=1;
            i++;
            j--;
        }
        j=center;
        i=center+1;
        while(i<grid.length)
        {
            if(grid[i][j]==1)
            {
                 
                count++;
            }
            visited[i][j]=1;
            i++;
        }
         a=0;
        b=0; 
        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid.length;j++)
            {
                if(visited[i][j]==0)
                {
                    if(grid[i][j]==2)
                    {
                        a++;
                    }
                    else if(grid[i][j]==0)
                    {
                        b++;
                    }
                }
            }
        }
        
         res1=count+a;
        res2=count+b;
            
          int p=n*n-Math.max(res1,res2);
        res=Math.min(res,p);
        
        // Case 3 
        //Y=0, X=1 || Y=0 X=2
        count=0;
        visited=new int[grid.length][grid[0].length];
        i=0;
        j=0;
        while(i<=center && j<=center)
        {
            if(grid[i][i]==0)
            {
                count++;
                
            }
            visited[i][j]=1;
            i++;
            j++;
        }
        j=grid[0].length-1;
        i=0;
        while(j>center && i<center)
        {
            if(grid[i][j]==0)
            {
                count++;
               
            }
             visited[i][j]=1;
            i++;
            j--;
        }
        j=center;
        i=center+1;
        while(i<grid.length)
        {
            if(grid[i][j]==0)
            {
                
                count++;
            }
             visited[i][j]=1;
            i++;
        }
    
         a=0;
        b=0; 
        for( i=0;i<grid.length;i++)
        {
            for(j=0;j<grid.length;j++)
            {
                if(visited[i][j]==0)
                {
                    if(grid[i][j]==2)
                    {
                        a++;
                    }
                    else if(grid[i][j]==1)
                    {
                        b++;
                    }
                }
            }
        }

         res1=count+a;
         res2=count+b;
         p=n*n-Math.max(res1,res2);
        res=Math.min(res,p);
        
        
        return res;
        
    }
}
