class Solution {
    public int smallestRangeI(int[] nums, int k) {
        Arrays.sort(nums);
        int result=0;
        int p=nums[nums.length-1]-k;
        if(nums[0]+k>=p)
        {
            result=0;
        }
        else
        {
          result=p-(nums[0]+k);
        }
        
        return result;
    
        
    }
}
