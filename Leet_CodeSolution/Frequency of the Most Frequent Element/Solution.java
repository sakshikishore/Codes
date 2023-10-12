class Solution {
    public int maxFrequency(int[] nums, int k) {
        long p=k,max=0,count=1;
        Arrays.sort(nums);
        int start=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1])
            {
                count++;
            }
            else
            {
                 int j=nums[i]-nums[i-1];
                 if(count*j<=p)
                 {
                      p=p-(count*j);
                      count++;
                 }
                 else
                 {
                     if(count>max)
                     {
                         max=count;
                     }
                     while(start<i-1 && count*j>p)
                     {
                        p=p+(nums[i-1]-nums[start]);
                        count--;
                        start++;
                     }
                     if(count*j<=p)
                     {
                            p=p-(count*j);
                            count++;
                     }
                     else
                     {
                         count=1;
                         p=k;
                     }

                 }
            }
        }

        if(count>max)
        {
            max=count;
        }

        return (int)max;
    }
}
