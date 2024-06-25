class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int result=0;
        if(n%2!=0 && mines.length==0)
        {
            return (n/2)+1;
        }
        else
        {
            if(n%2==0 && mines.length==0)
            {
                return n/2;
            }
            else
            {
                int arr[][]=new int[n][n];
                for(int i=0;i<n;i++)
                {
                    Arrays.fill(arr[i],1);
                }
                for(int i=0;i<mines.length;i++)
                {
                        int x=mines[i][0];
                        int y=mines[i][1];
                        arr[x][y]=0;
                }

                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        if(arr[i][j]==1)
                        {
                            int max=Integer.MAX_VALUE;
                            int p=j-1,count=0;
                            while(p>=0)
                            {
                                if(arr[i][p]==1)
                                {
                                    count++;
                                    if(count>max)
                                    {
                                        count=max;
                                        break;
                                    }
                                }
                                else
                                {
                                    break;
                                }
                                p--;
                            }
                            max=Math.min(count,max);
                            if(max+1<result)
                            {
                                continue;
                            }
                            p=j+1;
                            count=0;
                            while(p<n)
                            {
                                if(arr[i][p]==1)
                                {
                                    count++;
                                    if(count>max)
                                    {
                                        count=max;
                                        break;
                                    }
                                }
                                else
                                {
                                    break;
                                }
                                p++;
                            }
                            max=Math.min(count,max);
                             if(max+1<result)
                            {
                                continue;
                            }
                            p=i+1;
                            count=0;
                            while(p<n)
                            {
                                if(arr[p][j]==1)
                                {
                                    count++;
                                    if(count>max)
                                    {
                                        count=max;
                                        break;
                                    }
                                }
                                else
                                {
                                    break;
                                }
                                p++;
                            }
                            max=Math.min(count,max);

                             if(max+1<result)
                            {
                                continue;
                            }
                            p=i-1;
                            count=0;
                            while(p>=0)
                            {
                                if(arr[p][j]==1)
                                {
                                    count++;
                                    if(count>max)
                                    {
                                        count=max;
                                        break;
                                    }
                                }
                                else
                                {
                                    break;
                                }
                                p--;
                            }
                            max=Math.min(count,max);
                            if(max+1>result)
                            {
                                result=max+1;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
