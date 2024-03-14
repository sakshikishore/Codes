class Solution {
    public int movesToMakeZigzag(int[] nums) {
        if(nums.length==1)
        {
            return 0;
        }
        
         // case 1 lastElement>2ndLastElement
         int res=0;
        int prev=nums[nums.length-1];
        int direc=0;
        for(int i=nums.length-2;i>=0;i--)
        {
           if(direc==0)
           {
            if(prev>nums[i])
            {
               prev=nums[i];
            }
            else
            {
                res+=nums[i]-prev+1;
                prev=prev-1;

            }
            direc=1;
           }
           else
           {
                if(nums[i]>prev)
                {
                    prev=nums[i];
                }
                else
                {
                       res+=prev-nums[i]+1;
                       prev=nums[i];
                        
                }
                direc=0;
           }
        }
        // case 2 lastElement<2ndLastElement
        int result=0;
        prev=nums[nums.length-1];
        direc=0;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(direc==0)
           {
            if(prev<nums[i])
            {
               prev=nums[i];
            }
            else
            {
                result+=prev-nums[i]+1;
                prev=nums[i];

            }
            direc=1;
           }
           else
           {
                if(nums[i]<prev)
                {
                    prev=nums[i];
                }
                else
                {
                       result+=nums[i]-prev+1;
                       prev=prev-1;        
                }
                direc=0;
           }
        }

        
   
        return Math.min(res,result);
    }
}
