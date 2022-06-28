class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        if(nums[0]==nums[nums.length-1])
        {
            return 0;
        }
        else
        {
            int result=0;
            int x=nums.length/2;
            for(int i=0;i<nums.length;i++)
            {
               result+=Math.abs(nums[x]-nums[i]);
            }
             return result;
        }
        
    }
}
