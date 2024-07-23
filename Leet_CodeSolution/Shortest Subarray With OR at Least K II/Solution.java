class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int x=Integer.toBinaryString(k).length();
        int ch[][]=new int[nums.length][x];
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>=k)
            {
                return 1;
            }
            int p=nums[i];
            int count=0;
            int n=x-1;
            while(p>0)
            {
                 int v= (p & 1);
                 if(v==1)
                 {
                    if(i==0)
                    {
                      ch[i][n]=1;
                    }
                    else
                    {
                        ch[i][n]=1+ch[i-1][n];
                    }
                 }
                 else
                 {
                    if(i!=0)
                    {
                        ch[i][n]=ch[i-1][n];
                    }
                 }
                 p>>=1;
                 n--;
            }
            while(n>=0)
            {
               if(i!=0)
               {
                ch[i][n]=ch[i-1][n];
               }
               n--;
            }
        }
        int start=0;
        int val=0;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
           val=(val | nums[i]);
           if(val>=k)
           {
                if(i-start+1<result)
                {
                    result=i-start+1;
                }
                while(val>=k)
                {
                    int a[]=new int[x];
                    int flag=0;
                    for(int j=ch[i].length-1;j>=0;j--)
                    {
                        if(ch[i][j]!=0 && ch[i][j]-ch[start][j]==0)
                        {
                            flag=1;
                            
                        }
                        a[j]=ch[i][j]-ch[start][j];
                      
                        
                    }
                    if(flag==0)
                    {
                        start++;
                        if(i-start+1<result)
                        {
                            result=i-start+1;
                        }

                    }
                    else
                    {
                        val=0;
                        for(int j=a.length-1;j>=0;j--)
                        {
                            if(a[j]>=1)
                            {
                            val=val+(int)Math.pow(2,a.length-1-j);
                            }
                            
                        }
                      
                        if(val>=k)
                        {
                            start++;
                        }
                        if(i-start+1<result)
                        {
                            result=i-start+1;
                        }
                    }
                }
           }
        }
        if(result==Integer.MAX_VALUE)
        {
            return -1;
        }

        return result;

    }
}
