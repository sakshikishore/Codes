class Solution {
    public int minOperations(int[] nums) {
       int i=0;
        int ans=0;
        while(i<nums.length && nums[i]==1)
        {
            i++;
        }
        while(i<nums.length)
        {
            if(i==nums.length-1 || i==nums.length-2)
            {
                if(nums[i]==0)
                {
                    return -1;
                }
            }
            else
            {
                if(nums[i]==0)
                {
                   ans++;
                   nums[i]=1;
                   nums[i+1]=(nums[i+1]^1);
                   nums[i+2]=(nums[i+2]^1);
                }
            }
            i++;
        }
        
        return ans;
    }
}
