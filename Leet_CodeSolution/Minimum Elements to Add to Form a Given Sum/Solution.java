class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        if(sum==goal)
        {
            return 0;
        }
        else if(Math.abs(goal-sum)<limit)
        {
            return 1;
        }
        else
        {
            long p=Math.abs(goal-sum);
            return (int)Math.ceil(p*1.0/limit);
        }
    }
}
