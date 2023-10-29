class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long count1=0,count2=0,sum1=0,sum2=0;
        for(int i=0;i<nums1.length;i++)
        {
            if(nums1[i]==0)
            {
                count1++;
            }
            else
            {
                sum1+=nums1[i];
            }
        }
        for(int i=0;i<nums2.length;i++)
        {
            if(nums2[i]==0)
            {
                count2++;
            }
            else
            {
                sum2+=nums2[i];
            }
        }
        if(count1==0 && count2==0)
        {
            if(sum1!=sum2)
            {
                return -1;
            }
        }
        if(count1>count2)
        {
            if(count2==0)
            {
                if(sum1+count1>sum2)
                {
                    return -1;
                }
                else 
                {
                    return sum2;
                }
            }
            if(sum1+count1>sum2+count2)
            {
                return sum1+count1;
            }
            else
            {
                return sum2+count2;
            }
        }
        else
        {
            if(count1==0)
            {
                 if(sum2+count2>sum1)
                {
                    return -1;
                }
                else 
                {
                    return sum1;
                }
            }
            if(sum1+count1<sum2+count2)
            {
                return sum2+count2;
            }
            else
            {
                return sum1+count1;
            }
        }
        
    }
}
