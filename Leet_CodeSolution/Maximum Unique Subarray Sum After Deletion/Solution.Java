class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> hset=new HashSet<Integer>();
        int sum=0;
        for(int i=0;i<nums.length;i++)
            {
                if(nums[i]>0)
                {
                    if(!hset.contains(nums[i]))
                    {
                        hset.add(nums[i]);
                        sum+=nums[i];
                    }
                }
            }
        if(sum==0)
        {
            Arrays.sort(nums);
            sum=nums[nums.length-1];
        }
        return sum;
    }
}
