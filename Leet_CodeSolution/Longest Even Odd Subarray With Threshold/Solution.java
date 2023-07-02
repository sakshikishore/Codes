class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int max=0,l=-1,count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>threshold)
            {
                 if(count>max)
                 {
                     max=count;

                 }
                 l=-1;
                 count=0;
            }
            else
            {
                if(nums[i]%2==0)
                {
                    if(l==-1)
                    {
                        l=i;
                        count++;
                    }
                    else
                    {
                        if(count%2==0)
                        {
                            count++;
                        }
                        else
                        {
                            if(count>max)
                            {
                                max=count;
                            }
                            count=1;
                            l=i;
                        }
                    }
                }
                else
                {
                    if(l!=-1)
                    {
                        if(count%2==0)
                        {
                            if(count>max)
                            {
                                max=count;
                            }
                            l=-1;
                            count=0;
                        }
                        else
                        {
                            count++;
                        }
                    }
                }
            }
        }

        if(count>max)
        {
            max=count;
        }

        return max;
    }
}
