class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=i+1;j<nums1.length;j++)
            {
                int p=0;
                int flag=0,diff=0;
                for(int t=0;t<nums2.length;t++)
                {
                   while(p==i || p==j)
                   {
                      p++;
                   }
                    if(flag==0)
                    {
                        diff=nums2[t]-nums1[p];
                        if(diff>min)
                        {
                            flag=-1;
                            break;
                        }
                        flag=1;
                    }
                    else
                    {
                        if(nums2[t]-nums1[p]!=diff)
                        {
                            flag=-1;
                            break;
                        }
                    }

                    p++;

                }
                if(flag==1)
                {
                    min=diff;
                }
            }
        }

        return min;
    }
}
