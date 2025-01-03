class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int arr[][]=new int[board.size()][board.size()];
        long a[][]=new long[board.size()][board.size()];
        for(int i=board.size()-1;i>=0;i--)
        {
            for(int j=board.size()-1;j>=0;j--)
            {
                if(i==board.size()-1 && j==board.size()-1)
                {
                    a[i][j]=1;
                    continue;
                }
                else if(i==board.size()-1)
                {
                    if(board.get(i).charAt(j)=='X')
                    {
                        arr[i][j]=-1;
                        a[i][j]=-1;
                    }
                    else if(arr[i][j+1]==-1)
                    {
                        arr[i][j]=-1;
                        a[i][j]=-1;
                    }
                    else
                    {
                        arr[i][j]=arr[i][j+1]+board.get(i).charAt(j)-'0';
                        a[i][j]=1;
                    }
                }
                else if(j==board.size()-1)
                {
                    if(board.get(i).charAt(j)=='X')
                    {
                        arr[i][j]=-1;
                        a[i][j]=-1;
                    }
                    else if(arr[i+1][j]==-1)
                    {
                        arr[i][j]=-1;
                        a[i][j]=-1;
                    }
                    else
                    {
                        arr[i][j]=arr[i+1][j]+board.get(i).charAt(j)-'0';
                        a[i][j]=1;
                    }
                }
                else
                {
                    if(i==0 && j==0)
                    {
                         arr[i][j]=-1;
                         if(arr[i+1][j]!=-1)
                         {
                            arr[i][j]=arr[i+1][j];
                         }
                        arr[i][j]=Math.max(arr[i][j],arr[i][j+1]);   
                        arr[i][j]=Math.max(arr[i][j],arr[i+1][j+1]);
                        
                        if(arr[i][j]==arr[i+1][j])
                        {
                           
                            a[i][j]=a[i+1][j];
                        }
                        if(arr[i][j]==arr[i][j+1])
                        {
                            
                            a[i][j]+=a[i][j+1];
                        }
                        if(arr[i][j]==arr[i+1][j+1])
                        {
                             
                             a[i][j]+=a[i+1][j+1];
                        }
                        a[i][j]=a[i][j]%(1000000007);
                    }
                    else
                    {
                        if(board.get(i).charAt(j)=='X')
                        {
                            arr[i][j]=-1;
                            a[i][j]=-1;
                        }
                        else
                        {
                            if(arr[i][j+1]==-1 && arr[i+1][j]==-1 && arr[i+1][j+1]==-1)
                            {
                                arr[i][j]=-1;
                                a[i][j]=-1;
                            }
                            else
                            {
                            int p=board.get(i).charAt(j)-'0'+arr[i+1][j];
                            int q=board.get(i).charAt(j)-'0'+arr[i][j+1];
                            int r=board.get(i).charAt(j)-'0'+arr[i+1][j+1];
                            int max=Math.max(p,q);
                            max=Math.max(max,r);
                            if(p==max)
                            {
                                a[i][j]=a[i+1][j];
                            }
                            if(q==max)
                            {
                                a[i][j]+=a[i][j+1];
                            }
                            if(r==max)
                            {
                                a[i][j]+=a[i+1][j+1];
                            }
                            a[i][j]=a[i][j]%(1000000007);

                            arr[i][j]=max;
                            }
                        }
                    }
                    
                }
            }      
        }

        int result[]=new int[2];
        if(arr[0][0]==-1)
        {
            result[0]=0;
            result[1]=0;
        }
        else if(arr[0][0]==0)
        {
            result[0]=0;
            result[1]=1;
        }
        else
        {
        result[0]=arr[0][0];
        result[1]=(int)(a[0][0]);
        }

        return result;

    }
}
