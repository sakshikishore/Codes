class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        long result=0;
        int prev=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
             {
                prev=target[i]-nums[i];
                result+=Math.abs(prev);
             }
             else
             {
                int x=target[i]-nums[i];
                if(prev>=0)
                {
                    if(x>prev)
                    {
                        result+=(x-prev);
                        prev=x;
                    }
                    else
                    {
                        if(x<0)
                        {
                        result+=Math.abs(x);
                        prev=x;
                        }
                        else
                        {
                             prev=x;
                        }
                    }
                }
                else
                {
                    if(x<prev)
                    {
                        result+=(prev-x);
                        prev=x;
                    }
                    else
                    {
                        if(x>=0)
                        {
                        result+=x;
                        prev=x;
                        }
                        else
                        {
                            prev=x;
                        }
                    }
                }
             }
        }

        return result;
    }
}
