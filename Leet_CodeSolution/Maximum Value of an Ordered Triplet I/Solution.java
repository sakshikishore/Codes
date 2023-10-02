class Solution {
    public long maximumTripletValue(int[] nums) {
        long rightMax[]=new long[nums.length];
        for(int i=nums.length-1;i>=0;i--)
        {
           if(i==nums.length-1)
           {
               rightMax[i]=nums[i];
           }
           else 
           {
               if(rightMax[i+1]>nums[i])
               {
                   rightMax[i]=rightMax[i+1];
               }
               else
               {
                   rightMax[i]=nums[i];
               }
           }
        }
        long leftMax[]=new long[nums.length];
          for(int i=0;i<nums.length;i++)
          {
                if(i==0)
                {
                    leftMax[i]=nums[i];
                }
                else
                {
                    if(leftMax[i-1]>nums[i])
                    {
                        leftMax[i]=leftMax[i-1];
                    }
                    else
                    {
                        leftMax[i]=nums[i];
                    }
                }
          }
          long result=0;
          for(int i=1;i<nums.length-1;i++)
          {
              if((leftMax[i-1]-nums[i])*rightMax[i+1]>result)
              {
                  result=(leftMax[i-1]-nums[i])*rightMax[i+1];
              }
          }

          return result;       
    }
}
