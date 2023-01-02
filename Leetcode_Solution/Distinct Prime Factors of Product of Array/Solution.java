class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> h = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int count=0;
            for(int k=2;k<=nums[i]/2;k++)
            {
                if(nums[i]%k==0)
                {
                    count++;
                    break;
                }
            }
            if(count==0)
            {
                h.add(nums[i]);
            }
            else
            {
                for(int j=2;j<=nums[i]/2;j++)
                {
                    if(nums[i]%j==0)
                    {
                        int l=0;
                         for(int k=2;k<=j/2;k++)
                            {
                                if(j%k==0)
                                {
                                    l++;
                                    break;
                                }
                            }
                        if(l==0)
                        {
                            h.add(j);
                        }
                    }
                }
            }
        }
        
        return h.size();
    }
}
