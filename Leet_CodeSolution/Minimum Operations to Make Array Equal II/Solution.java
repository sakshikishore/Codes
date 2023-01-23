class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long result=0;
        int sub=0,sum=0;
        if(k==0)
        {
            for(int i=0;i<nums1.length;i++)
            {
                if(nums1[i]!=nums2[i])
                {
                    return -1;
                }
            }
            
            return 0;
        }
        for(int i=0;i<nums1.length;i++)
        {
            if(nums1[i]!=nums2[i])
            {
                if(nums1[i]>nums2[i])
                {
                    int x=nums1[i]-nums2[i];
                    int r=x/k;
                    if((r*k)!=x)
                    {
                        return -1;
                    }
                    else
                    {
                        sub+=r;
                        result+=r;
                    }
                }
                else
                {
                    int x=nums2[i]-nums1[i];
                    int r=x/k;
                    if((r*k)!=x)
                    {
                        return -1;
                    }
                    else
                    {
                        sum+=r;
                        result+=r;
                    }
                }
            }
        }
        if(sub!=sum)
        {
            return -1;
        }
        else
        {
            return result/2;
        }
    }
}
