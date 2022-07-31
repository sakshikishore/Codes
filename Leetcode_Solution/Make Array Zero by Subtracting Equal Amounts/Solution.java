class Solution {
    public int minimumOperations(int[] nums) {
        int flag=0,count=0;
        while(flag!=1)
        {
           Arrays.sort(nums);
           if(nums[nums.length-1]==0)
           {
               flag=1;
           }
            else
            {
                count++;
                int x=-1;
                for(int i=0;i<nums.length;i++)
                {
                    if(nums[i]!=0)
                    {
                        if(x==-1)
                        {
                            x=nums[i];
                            nums[i]=0;
                        }
                        else
                        {
                            nums[i]=nums[i]-x;
                        }
                    }
                }
            }
        }
        
        return count;
    }
}
