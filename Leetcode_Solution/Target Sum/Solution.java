class Solution {
    int result=0;
    public void getSolution(int[] nums, int target,int index,int score)
    {
        if(index==nums.length)
        {
            if(score==target)
            {
                result++;
            }
            return;
        }
        getSolution(nums,target,index+1,score-nums[index]);
        getSolution(nums,target,index+1,score+nums[index]);
    }
    public int findTargetSumWays(int[] nums, int target) {
       getSolution(nums,target,0,0);
        
        return result;
    }
}
