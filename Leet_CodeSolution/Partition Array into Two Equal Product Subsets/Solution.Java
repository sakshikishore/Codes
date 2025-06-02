class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        long totalP=1;
        for(int i=0;i<nums.length;i++)
            {
                totalP=totalP*nums[i];
            }
        if(target*target!=totalP)
        {
            return false;
        }
        for(int i=0;i<(1<<nums.length);i++)
            {
                long p=1;
                for(int j=0;j<nums.length;j++)
                    {
                        if((i & (1<<j))>0)
                        {
                           p=p*nums[j];
                        }
                    }
                if(p==target)
                {
                   return true;
                }
            }

        return false;
    }
}
