class Solution {
    public int minimumDifference(int[] nums, int k) {
        int min=1000000;
        if(nums.length<2)
        {
            min=0;
        }
        else
        {
            Arrays.sort(nums);
            int p=k-1;
            int i=0;
            while(p<nums.length)
            {
                if(nums[p]-nums[i]<min)
                {
                    min=nums[p]-nums[i];
                }
                p++;
                i++;
            }
        }
        
        return min;
        
    }
}
