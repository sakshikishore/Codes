class Solution {
    public int longestNiceSubarray(int[] nums) {
        int start=0;
        int result=1;
        int pref[][]=new int[nums.length][33];
        for(int i=0;i<nums.length;i++)
        {
           int p=nums[i];
           int c=0;
           while(p>0)
           {
               if(i==0)
               {
                   pref[i][c]=(p & 1);
               }
               else
               {
                 pref[i][c]=(p & 1)+pref[i-1][c];
               }
              p>>=1;
              c++;
           }
           if(i!=0)
           {
           for(int j=c;j<33;j++)
           {
                pref[i][j]=pref[i-1][j];
           }
           }
        }
        for(int i=1;i<nums.length;i++)
        {
             for(int j=0;j<33;j++)
             {
                if(start==0)
                {
                    if(pref[i][j]>1)
                    {
                        if(i-start>result)
                        {
                            result=i-start;
                        }
                        start++;
                    }
                }
                else
                {
                    if(pref[i][j]-pref[start-1][j]>1)
                    {
                        if(i-start>result)
                        {
                            
                            result=i-start;
                        }
                        start++;
                    }
                }
             }
        }
     
        if(nums.length-start>result)
        {
            result=nums.length-start;
        }


        return result;
    }
}
