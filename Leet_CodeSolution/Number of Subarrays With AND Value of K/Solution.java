class Solution {
    public long countSubarrays(int[] nums, int k) {
        char c[]=Integer.toBinaryString(k).toCharArray();
        long res=0;
        int start=0;
        int val=1;
        int ch[]=new int[32];
        for(int i=0;i<nums.length;i++)
        {
            if(start==i)
            {
                val=nums[i];
                ch=new int[32];
                
            }
            else
            {
                val=(val & nums[i]);
            }
            String s=Integer.toBinaryString(nums[i]);
           if(s.length()<c.length)
           {
             start=i+1;     
           }
           else
           {
            int a=ch.length-1;
            for(int j=s.length()-1;j>=0;j--)
            {
                if(s.charAt(j)=='1')
                {
                    ch[a]++;
                }
                else
                {
                    ch[a]=0;
                }
                a--;
            }
            while(a>=0)
            {
                ch[a]=0;
                a--;
            }
             if(val==k)
             {
              if(nums[i]==k)
              {
                  res+=i-start+1;
              }
              else
              {
                        int p=c.length-1;
                        int j=ch.length-1;
                        int maxCount=0;
                        while(p>=0)
                        {
                            if(ch[j]>0 && c[p]=='0')
                            {
                               if(ch[j]>maxCount)
                               {
                                 maxCount=ch[j];
                               }
                            }
                            j--;
                            p--;
                        }
                        while(j>=0)
                        {
                            if(ch[j]>maxCount)
                            {
                               
                                maxCount=ch[j];
                            }
                            j--;
                        }

                        res+=(i-maxCount)-start+1;
              }
           }
           else
           {
            int p=c.length-1;
            int j=s.length()-1;
            int flag=0;
            while(p>=0)
            {
                if(s.charAt(j)=='0' && c[p]=='1')
                {
                    flag=1;
                    break;
                }
                j--;
                p--;
            }
            if(flag==1)
            {
                 start=i+1;
            }
           }
           }

           
        }

        return res;
    }
}
