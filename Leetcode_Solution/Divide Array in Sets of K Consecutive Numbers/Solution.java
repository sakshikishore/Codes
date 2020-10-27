class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        boolean result=false;
         int g=0;
        if(nums.length%k==0)
        {
            Arrays.sort(nums);
            int count=1;
            int m=0,l=0;
            int prev=0;
            int i=1;
            while(i<nums.length)
            {
                if(nums[i]!=-1)
                {
                    if(nums[i]-nums[m]!=1)
                    {
                        if(l==prev)
                        {
                            l=i;
                        }
                    }
                    else
                    {          
                        nums[m]=-1;
                        m=i;     
                        count++;
                       
                        if(count==k)
                        { 
                            g++;
                            nums[i]=-1;
                          
                         if(l==prev)
                         {
                             m=i+1;
                             prev=i+1;
                             l=prev;
                         }
                         else
                         {
                              m=l;
                              prev=m;
                              i=l;
                         }
                                                
                           
                            count=1;
                        }
                    }
                }
                i++;
            }            
            
        }
        if(g*k==nums.length)
        {
            result=true;
        }
      
        
        return result;
        
    }
}
