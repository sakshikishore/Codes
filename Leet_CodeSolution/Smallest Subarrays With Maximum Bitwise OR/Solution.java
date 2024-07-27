class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int result[]=new int[nums.length];
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
            }
        }
        String str=Integer.toBinaryString(max);
        int ch[][]=new int[nums.length][str.length()];
        result[result.length-1]=1;
        int count=0;
        str=Integer.toBinaryString(nums[nums.length-1]);
        for(int i=str.length()-1;i>=0;i--)
        {
            if(str.charAt(i)=='1')
            {
                ch[nums.length-1][count]=1;
            }
            count++;
        }
        
        int start=nums.length-1;
        for(int i=nums.length-2;i>=0;i--)
        {
           int x=nums[i];
           count=0;
           while(x>0)
           {
             int p=( x & 1);
             if(p==1)
             {
                 ch[i][count]=1;
             }
             x>>=1;
            count++;
           }
           for(int j=0;j<ch[i].length;j++)
           {
            ch[i][j]+=ch[i+1][j];
           }
           while(start!=i)
           {
                int flag=0;
                for(int j=0;j<ch[i].length;j++)
                {
                   
                    if(ch[i][j]!=0 && ch[i][j]-ch[start][j]==0)
                    {
                        
                        flag=1;
                        break;
                    }
                }
                
            if(flag==0)
            {
                 start--;
            }
            else
            {
                break;
            }
           }
           result[i]=start-i+1;

        }

        return result;

    }
}
